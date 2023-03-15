package com.amur.home.msg.service.impl;

import com.amur.home.msg.client.UserGrpcClient;
import com.amur.home.msg.config.RabbitMQConfig;
import com.amur.home.msg.dto.ChatDetailDTO;
import com.amur.home.msg.dto.ListChatDTO;
import com.amur.home.msg.entity.Chat;
import com.amur.home.msg.entity.ChatInvite;
import com.amur.home.msg.entity.ChatUserRelation;
import com.amur.home.msg.entity.Message;
import com.amur.home.msg.mapper.ChatInviteMapper;
import com.amur.home.msg.mapper.ChatMapper;
import com.amur.home.msg.mapper.ChatUserMapper;
import com.amur.home.msg.mapper.MessageMapper;
import com.amur.home.msg.service.MessageService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.minio.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Resource
    private RabbitTemplate rabbitTemplate;
    @Resource
    private ChatMapper chatMapper;
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private ChatInviteMapper chatInviteMapper;
    @Resource
    private ChatUserMapper chatUserMapper;
    @Resource
    private MinioClient minioClient;
    @Resource
    private UserGrpcClient userGrpcClient;

    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * @param senderId 发送者ID
     * @param message  消息内容
     * @param chatId   会话ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> sendMsg(Long senderId, String message, String chatId) {
        if (!userGrpcClient.checkUserExists(senderId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        QueryWrapper<ChatUserRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chat_id", chatId).eq("user_id", senderId);
        if (chatUserMapper.selectCount(queryWrapper) == 0) {
            return ServiceResult.ex("用户不在该会话中");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(queryWrapper);
        if (cur.getMute()) {
            return ServiceResult.ex("用户已被禁言");
        }
        Message msg = new Message(UUID.randomUUID().toString(), message, chatId, senderId);
        chat.setLastMessageId(msg.getId());
        QueryWrapper<ChatUserRelation> wsQueryWrapper = new QueryWrapper<>();
        wsQueryWrapper.eq("chat_id", chatId).ne("user_id", senderId);
        List<ChatUserRelation> curList = chatUserMapper.selectList(wsQueryWrapper);
        for (ChatUserRelation chatUserRelation : curList) {
            chatUserRelation.setUnread(chatUserRelation.getUnread() + 1);
            chatUserMapper.updateById(chatUserRelation);
            Long userId = chatUserRelation.getUserId();
            rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.ROUTING_KEY, msg);
        }
        if (messageMapper.insert(msg) > 0 && chatMapper.updateById(chat) > 0) {
            return ServiceResult.ex("发送失败");
        } else {
            return ServiceResult.success();
        }
    }

    /**
     * @param senderId 发送者ID
     * @param file     文件
     * @param chatId   会话ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> sendFile(Long senderId, MultipartFile file, String chatId) {
        if (!userGrpcClient.checkUserExists(senderId)) {
            return ServiceResult.ex("用户不存在");
        }
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String newFileName = "AmurMsg_" + UUID.randomUUID() + fileExtension;
        String bucketName = "msg_attachment";
        try {
            InputStream inputStream = file.getInputStream();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!isExist) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(newFileName).stream(inputStream, inputStream.available(), -1).contentType(file.getContentType()).build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config("{" + "  \"Version\": \"2012-10-17\"," + "  \"Statement\": [" + "    {" + "      \"Effect\": \"Allow\"," + "      \"Principal\": {" + "        \"AWS\": [\"*\"]" + "      }," + "      \"Action\": [\"s3:GetObject\"]," + "      \"Resource\": [\"arn:aws:s3:::" + bucketName + "/*\"]" + "    }" + "  ]" + "}").build());
            String fileUrl = "/" + bucketName + "/" + newFileName;
            Message msg = new Message(UUID.randomUUID().toString(), fileUrl, chatId, senderId);
            Chat chat = chatMapper.selectById(chatId);
            chat.setLastMessageId(msg.getId());
            if (chatMapper.updateById(chat) > 0 && messageMapper.insert(msg) > 0) {
                return ServiceResult.success();
            } else {
                return ServiceResult.ex("发送失败");
            }
        } catch (Exception e) {
            return ServiceResult.ex("文件上传失败");
        }
    }

    /**
     * @param chatId
     * @return
     */
    @Override
    public ServiceResult<List<Message>> getChatMsg(Long userId, String chatId) {
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chat_id", chatId);
        List<Message> messageList = messageMapper.selectList(queryWrapper);
        if (messageList.size() == 0) {
            return ServiceResult.ex("无消息");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        cur.setUnread(0L);
        chatUserMapper.updateById(cur);
        return ServiceResult.success(messageList);
    }

    /**
     * @param creatorId 创建者ID
     * @param name      会话名称
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<String> createChat(Long creatorId, String name) {
        if (!userGrpcClient.checkUserExists(creatorId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = new Chat();
        chat.setId(UUID.randomUUID().toString());
        chat.setCreatorId(creatorId);
        chat.setName(name);
        chat.setLastMessageId("");
        ChatUserRelation cur = new ChatUserRelation(UUID.randomUUID().toString(), chat.getId(), creatorId);
        if (chatMapper.insert(chat) > 0 && chatUserMapper.insert(cur) > 0) {
            return ServiceResult.success(chat.getId());
        } else {
            return ServiceResult.ex("创建失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> addChatUser(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        QueryWrapper<ChatUserRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chat_id", chatId).eq("user_id", userId);
        if (chatUserMapper.selectCount(queryWrapper) > 0) {
            return ServiceResult.ex("用户已在会话中");
        }
        ChatUserRelation cur = new ChatUserRelation(UUID.randomUUID().toString(), chatId, userId);
        if (chatMapper.updateById(chat) > 0 && chatUserMapper.insert(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("添加失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> delChatUser(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        if (chatUserMapper.deleteById(cur.getId()) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("删除失败");
        }
    }

    /**
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<ListChatDTO> listChats(Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        QueryWrapper<ChatUserRelation> curWrapper = new QueryWrapper<>();
        curWrapper.eq("user_id", userId);
        List<ChatUserRelation> chatUserRelations = chatUserMapper.selectList(curWrapper);
        QueryWrapper<Chat> topChatWrapper = new QueryWrapper<>();
        topChatWrapper.in("id", chatUserRelations.stream().filter(ChatUserRelation::getTop).map(ChatUserRelation::getChatId).collect(Collectors.toList())).orderByDesc("update_time");
        List<Chat> topChatList = chatMapper.selectList(topChatWrapper);
        QueryWrapper<Chat> chatWrapper = new QueryWrapper<>();
        chatWrapper.in("id", chatUserRelations.stream().filter(chatUserRelation -> !chatUserRelation.getTop()).map(ChatUserRelation::getChatId).collect(Collectors.toList())).orderByDesc("update_time");
        List<Chat> chatList = chatMapper.selectList(chatWrapper);
        return ServiceResult.success(new ListChatDTO(topChatList, chatList));
    }

    /**
     * @param chatId 会话ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<ChatDetailDTO> getChatDetail(String chatId) {
        Chat chat = chatMapper.selectById(chatId);
        ChatDetailDTO chatDetailDTO = new ChatDetailDTO();
        chatDetailDTO.setChat(chat);
        QueryWrapper<ChatUserRelation> curWrapper = new QueryWrapper<>();
        curWrapper.eq("chat_id", chatId);
        List<ChatUserRelation> chatUserRelations = chatUserMapper.selectList(curWrapper);
        List<Long> userIds = chatUserRelations.stream().map(ChatUserRelation::getUserId).collect(Collectors.toList());
        chatDetailDTO.setUserIds(userIds);
        if (chat.getLastMessageId().isEmpty()) {
            chatDetailDTO.setLastMessageTime(chat.getCreateTime());
        } else {
            Message message = messageMapper.selectById(chat.getLastMessageId());
            chatDetailDTO.setLastMessageTime(message.getCreateTime());
        }
        return ServiceResult.success(chatDetailDTO);
    }

    /**
     * @param chatId 会话ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> deleteChat(String chatId) {
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        if (chatMapper.deleteById(chatId) > 0 && chatUserMapper.delete(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId)) > 0 && messageMapper.delete(new QueryWrapper<Message>().eq("chat_id", chatId)) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("删除失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> clearChat(String chatId) {
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        if (messageMapper.delete(new QueryWrapper<Message>().eq("chat_id", chatId)) >= 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("清空失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> leaveChat(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        QueryWrapper<ChatUserRelation> curWrapper = new QueryWrapper<>();
        curWrapper.eq("user_id", userId);
        List<ChatUserRelation> chatUserRelations = chatUserMapper.selectList(curWrapper);
        if (chatUserRelations.size() == 1) {
            return ServiceResult.ex("无法退出，会话中至少需要一名成员");
        }
        if (chatUserMapper.delete(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId)) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("退出失败");
        }
    }

    /**
     * @param token 邀请token
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> joinChat(String token, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        ChatInvite chatInvite = chatInviteMapper.selectById(token);
        if (chatInvite == null) {
            return ServiceResult.ex("邀请码不存在");
        }
        if (chatInvite.getExpireTime().before(new Date())) {
            return ServiceResult.ex("邀请码已过期");
        }
        Chat chat = chatMapper.selectById(chatInvite.getChatId());
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatInvite.getChatId()).eq("user_id", userId));
        if (cur != null) {
            return ServiceResult.ex("用户已在会话中");
        }
        ChatUserRelation chatUserRelation = new ChatUserRelation();
        chatUserRelation.setChatId(chatInvite.getChatId());
        chatUserRelation.setUserId(userId);
        if (chatUserMapper.insert(chatUserRelation) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("加入失败");
        }
    }

    /**
     * @param chatId    会话ID
     * @param invitorId 邀请人ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<String> inviteUser(String chatId, Long invitorId) {
        if (!userGrpcClient.checkUserExists(invitorId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", invitorId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        String token = UUID.randomUUID().toString();
        ChatInvite chatInvite = new ChatInvite();
        chatInvite.setChatId(chatId);
        chatInvite.setId(token);
        chatInvite.setExpireTime(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7));
        if (chatInviteMapper.insert(chatInvite) > 0) {
            return ServiceResult.success(token);
        } else {
            return ServiceResult.ex("邀请失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> kickUser(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        if (chat.getCreatorId().equals(userId)) {
            return ServiceResult.ex("无法踢出会话创建人");
        }
        QueryWrapper<ChatUserRelation> curWrapper = new QueryWrapper<>();
        curWrapper.eq("user_id", userId);
        List<ChatUserRelation> chatUserRelations = chatUserMapper.selectList(curWrapper);
        if (chatUserRelations.size() == 1) {
            return ServiceResult.ex("无法踢出，会话中至少需要一名成员");
        }
        if (chatUserMapper.delete(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId)) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("踢出失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> muteUserAdd(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        cur.setMute(true);
        if (chatUserMapper.updateById(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("禁言失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> muteUserDel(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        cur.setMute(false);
        if (chatUserMapper.updateById(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("解除禁言失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> transferChat(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        chat.setCreatorId(userId);
        if (chatMapper.updateById(chat) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("转让失败");
        }
    }

    /**
     * @param userId  用户ID
     * @param keyword 关键字
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> searchMsg(Long userId, String keyword) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("message", keyword).orderByDesc("create_time");
        List<Message> msgList = messageMapper.selectList(queryWrapper);
        if (msgList.size() > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("未找到相关消息");
        }
    }

    /**
     * @param userId  用户ID
     * @param keyword 关键字
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> searchChat(Long userId, String keyword) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        QueryWrapper<Chat> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", keyword).orderByDesc("create_time");
        List<Chat> chatList = chatMapper.selectList(queryWrapper);
        if (chatList.size() > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("未找到相关会话");
        }
    }

    /**
     * @param chatId   会话ID
     * @param userId   用户ID
     * @param nickname 昵称
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<String> chatUserNickname(String chatId, Long userId, String nickname) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        cur.setNickname(nickname);
        if (chatUserMapper.updateById(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("修改失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> chatTopDel(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        cur.setTop(false);
        if (chatUserMapper.updateById(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("取消置顶失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> chatTopAdd(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        cur.setTop(true);
        if (chatUserMapper.updateById(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("置顶失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> notifyOff(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        cur.setNotify(false);
        if (chatUserMapper.updateById(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("开启免打扰失败");
        }
    }

    /**
     * @param chatId 会话ID
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> notifyOn(String chatId, Long userId) {
        if (!userGrpcClient.checkUserExists(userId)) {
            return ServiceResult.ex("用户不存在");
        }
        Chat chat = chatMapper.selectById(chatId);
        if (chat == null) {
            return ServiceResult.ex("会话不存在");
        }
        ChatUserRelation cur = chatUserMapper.selectOne(new QueryWrapper<ChatUserRelation>().eq("chat_id", chatId).eq("user_id", userId));
        if (cur == null) {
            return ServiceResult.ex("用户不在会话中");
        }
        cur.setNotify(true);
        if (chatUserMapper.updateById(cur) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("关闭免打扰失败");
        }
    }
}
