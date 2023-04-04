package com.amur.home.user.service.impl;

import com.amur.home.common.Constants;
import com.amur.home.dto.PageResult;
import com.amur.home.user.client.TinyIdGrpcClient;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.entity.UserLike;
import com.amur.home.user.mapper.UserFavMapper;
import com.amur.home.user.mapper.UserInfoMapper;
import com.amur.home.user.mapper.UserLikeMapper;
import com.amur.home.user.service.UserService;
import com.amur.home.user.util.RedisUtils;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.minio.*;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    @Setter
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserFavMapper userFavMapper;

    @Resource
    private UserLikeMapper userLikeMapper;

    @Resource
    private TinyIdGrpcClient tinyIdGrpcClient;

    @Resource
    private MinioClient minioClient;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 根据用户 ID 获取用户信息
     *
     * @param userId 用户 ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<UserInfo> getUserInfo(Long userId) {
        if (redisUtils.exists("user_info:" + userId)) {
            return ServiceResult.success((UserInfo) redisUtils.get("user_info:" + userId));
        }
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (userInfo == null) {
            return ServiceResult.ex("用户不存在");
        } else {
            return ServiceResult.success(userInfo);
        }
    }

    /**
     * 更新用户信息
     *
     * @param userId       用户 ID
     * @param description  用户描述
     * @param phone        手机号
     * @param email        邮箱
     * @param avatarUrl    头像地址
     * @param sex          性别
     * @param age          年龄
     * @param relativeType 亲属类型
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> updateUser(Long userId, String description, String phone, String email, String avatarUrl, String sex, Integer age, Constants.UserRelativeType relativeType) {
        ServiceResult<Void> result = new ServiceResult<>();
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (userInfo == null) {
            result.setMessage("用户不存在");
            return result;
        }
        if (description != null) {
            userInfo.setDescription(description);
        }
        if (phone != null) {
            userInfo.setPhone(phone);
        }
        if (email != null) {
            userInfo.setEmail(email);
        }
        if (avatarUrl != null) {
            userInfo.setAvatarUrl(avatarUrl);
        }
        if (sex != null) {
            userInfo.setSex(sex);
        }
        if (age != null) {
            userInfo.setAge(age);
        }
        if (relativeType != null) {
            userInfo.setRelativeType(relativeType);
        }
        if (userInfoMapper.updateById(userInfo) > 0) {
            result.setSuccess(true);
        } else {
            return ServiceResult.ex("更新用户信息失败！");
        }
        redisUtils.set("user_info:" + userId, userInfo);
        return result;
    }

    /**
     * @param file 用户头像文件
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<String> updateAvatar(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        if (!(fileExtension.equalsIgnoreCase(".jpg") || fileExtension.equalsIgnoreCase(".jpeg") || fileExtension.equalsIgnoreCase(".png") || fileExtension.equalsIgnoreCase(".gif"))) {
            return ServiceResult.ex("仅支持jpg/png/gif格式图片");
        }
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileExtension;
        String bucketName = "avatar";
        try {
            InputStream inputStream = file.getInputStream();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!isExist) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(newFileName).stream(inputStream, inputStream.available(), -1).contentType(file.getContentType()).build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config("{" + "  \"Version\": \"2012-10-17\"," + "  \"Statement\": [" + "    {" + "      \"Effect\": \"Allow\"," + "      \"Principal\": {" + "        \"AWS\": [\"*\"]" + "      }," + "      \"Action\": [\"s3:GetObject\"]," + "      \"Resource\": [\"arn:aws:s3:::" + bucketName + "/*\"]" + "    }" + "  ]" + "}").build());
        } catch (Exception e) {
            return ServiceResult.ex("文件上传失败" + e.getMessage());
        }
//        try {
//            String url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().bucket("my-bucket").object("my-object").expiry(3600).build());
//        } catch (Exception e) {
//            return ServiceResult.ex("文件链接生成失败" + e.getMessage());
//        }
        String fileUrl = "/" + bucketName + "/" + newFileName;
        return ServiceResult.success(fileUrl);
    }

    /**
     * 删除用户
     *
     * @param userId 用户 ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> deleteUser(Long userId) {
        if (userInfoMapper.deleteById(userId) <= 0) {
            return ServiceResult.ex("删除用户失败");
        }
        if (userFavMapper.deleteById(userId) <= 0) {
            return ServiceResult.ex("删除用户失败");
        }
        redisUtils.remove("user_info:" + userId);
        return ServiceResult.success();
    }

    /**
     * 创建用户
     *
     * @param userName 用户名
     * @return 服务返回结果统一封装
     */
    @Override
    @GlobalTransactional
    //@ShardingTransactionType(TransactionType.BASE)
    public ServiceResult<Long> createUser(String userName) {
        ServiceResult<Long> res = tinyIdGrpcClient.getNextId(Constants.TableName.USER.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.ex("id生成失败");
        }
        UserInfo userInfo = new UserInfo(res.getData(), userName);
        UserFavorite userFavorite = new UserFavorite(res.getData());
        UserLike userLike = new UserLike(res.getData());
        if (userInfoMapper.insert(userInfo) <= 0) {
            return ServiceResult.ex("创建用户失败");
        }
        if (userFavMapper.insert(userFavorite) <= 0) {
            return ServiceResult.ex("创建用户失败");
        }
        if (userLikeMapper.insert(userLike) <= 0) {
            return ServiceResult.ex("创建用户失败");
        }
        redisUtils.set("user_info:" + userInfo.getId(), userInfo);
        return ServiceResult.success(userInfo.getId());
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<UserInfo> getUserByName(String username) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            return ServiceResult.ex("用户不存在");
        } else {
            return ServiceResult.success(userInfo);
        }
    }

    /**
     * @param favId  被收藏的用户ID
     * @param userId 收藏的用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> favUser(Long favId, String nickName, Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(favId);
        if (userInfo == null) {
            return ServiceResult.ex("被收藏的用户不存在");
        }
        UserFavorite userFavorite = userFavMapper.selectById(userId);
        if (userFavorite == null) {
            return ServiceResult.ex("用户不存在");
        }
        if (userFavorite.getUserIds().contains(favId)) {
            return ServiceResult.ex("已经收藏过该用户");
        }
        userInfo.setFavCount(userInfo.getFavCount() + 1);
        userFavorite.getUserIds().add(favId);
        userFavorite.getUserMap().put(favId, nickName);
        if (userInfoMapper.updateById(userInfo) <= 0) {
            return ServiceResult.ex("收藏失败");
        }
        if (userFavMapper.insert(userFavorite) <= 0) {
            return ServiceResult.ex("收藏失败");
        }
        return ServiceResult.success();

    }

    /**
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Boolean> checkUserExists(long userId) {
        return ServiceResult.success(userInfoMapper.selectById(userId) != null);
    }

    /**
     * @param homeId
     * @param keyword
     * @return
     */
    @Override
    public ServiceResult<PageResult<UserInfo>> searchUserInfo(Long homeId, String keyword, String email, String phone, Integer pageNum, Integer pageSize) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        if (homeId != null) {
            queryWrapper.eq("home_id", homeId);
        }
        if (keyword != null) {
            queryWrapper.like("name", keyword);
        }
        if (email != null) {
            queryWrapper.eq("email", email);
        }
        if (phone != null) {
            queryWrapper.eq("phone", phone);
        }
        Page<UserInfo> page = new Page<>(pageNum, pageSize);
        IPage<UserInfo> userPage = userInfoMapper.selectPage(page, queryWrapper);
        if (userPage.getTotal() == 0) {
            return ServiceResult.successMsg("没有搜索到相关课程");
        }
        if (pageNum > userPage.getPages()) {
            return ServiceResult.ex("页数超出限制或当前页无课程");
        }
        PageResult<UserInfo> result = new PageResult<>(pageNum, pageSize, userPage.getTotal(), userPage.getPages(), userPage.getRecords());
        return ServiceResult.success(result);

    }
}
