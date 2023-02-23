package com.amur.home.user.service.impl;

import com.amur.home.common.Constants;
import com.amur.home.user.client.TinyIdClient;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.UserFavMapper;
import com.amur.home.user.mapper.UserInfoMapper;
import com.amur.home.user.service.UserService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    @Setter
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserFavMapper userFavMapper;

    @Resource
    private TinyIdClient tinyIdClient;

    @Resource
    private MinioClient minioClient;

    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * 根据用户 ID 获取用户信息。
     *
     * @param userId 用户 ID。
     * @return 用户实体对象。
     */
    @Override
    public ServiceResult<UserInfo> getUserInfo(Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        } else {
            return ServiceResult.success(userInfo);
        }
    }

    /**
     * 更新用户信息。
     *
     * @param userInfo 用户实体对象。
     * @return 如果更新成功，返回 true；否则，返回 false。
     */
    @Override
    public ServiceResult<Void> updateUser(UserInfo userInfo) {
        ServiceResult<Void> result = new ServiceResult<>();
        if (userInfoMapper.updateById(userInfo) > 0) {
            result.setSuccess(true);
        } else {
            result.setMessage("更新用户信息失败！");
        }
        return result;
    }

    /**
     * @param file
     * @return
     */
    @Override
    public ServiceResult<String> updateAvatar(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileExtension;

        String bucketName = "user-avatar";
        try {
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(newFileName).stream(inputStream, inputStream.available(), -1).build());
        } catch (Exception e) {
            return ServiceResult.fail("获取文件信息失败");
        }
        String fileUrl = endpoint + "/" + bucketName + "/" + newFileName;
        return ServiceResult.success(fileUrl);
    }

    /**
     * 删除用户。
     *
     * @param userId 用户 ID。
     * @return 如果删除成功，返回 true；否则，返回 false。
     */
    @Override
    public ServiceResult<Void> deleteUser(Long userId) {
        if (userInfoMapper.deleteById(userId) <= 0) {
            return ServiceResult.fail("删除用户失败");
        }
        if (userFavMapper.deleteById(userId) <= 0) {
            return ServiceResult.fail("删除用户失败");
        }
        return ServiceResult.success();
    }

    /**
     * 创建用户。
     *
     * @param userName 用户名。
     * @return 新创建的用户的 ID。
     */
    @Override
    public ServiceResult<Long> createUser(String userName) {
        ServiceResult<Long> res = tinyIdClient.getNextId(Constants.TableName.USER.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.fail("id生成失败");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setName(userName);
        userInfo.setId(res.getData());
        userInfo.setAge(0);
        userInfo.setSex("");
        userInfo.setAvatarUrl("");
        userInfo.setEmail("");
        userInfo.setPhone("");
        userInfo.setDescription("");
        userInfo.setHomeId(0L);
        userInfo.setFavCount(0);
        userInfo.setLikeCount(0);
        userInfo.setRelativeType(Constants.UserRelativeType.NONE);
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setId(res.getData());
        userFavorite.setUserMap(Collections.emptyMap());
        userFavorite.setUserIds(Collections.emptySet());
        userFavorite.setHomeIds(Collections.emptySet());
        userFavorite.setCourseIds(Collections.emptySet());
        userFavorite.setCourseWareIds(Collections.emptySet());
        userFavorite.setCourseListIds(Collections.emptySet());
        if (userInfoMapper.insert(userInfo) <= 0) {
            return ServiceResult.fail("创建用户失败");
        }
        if (userFavMapper.insert(userFavorite) <= 0) {
            return ServiceResult.fail("创建用户失败");
        }
        return ServiceResult.success(userInfo.getId());
    }

    /**
     * 根据用户名获取用户信息。
     *
     * @param username 用户名。
     * @return 用户实体对象。
     */
    @Override
    public ServiceResult<UserInfo> getUserByName(String username) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        } else {
            return ServiceResult.success(userInfo);
        }
    }

    /**
     * @param favId  被收藏的用户ID
     * @param userId 收藏的用户ID
     * @return
     */
    @Override
    public ServiceResult<Void> favUser(Long favId, String nickName, Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(favId);
        if (userInfo == null) {
            return ServiceResult.fail("被收藏的用户不存在");
        }
        UserFavorite userFavorite = userFavMapper.selectById(userId);
        if (userFavorite == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (userFavorite.getUserIds().contains(favId)) {
            return ServiceResult.fail("已经收藏过该用户");
        }
        userInfo.setFavCount(userInfo.getFavCount() + 1);
        userFavorite.getUserIds().add(favId);
        userFavorite.getUserMap().put(favId, nickName);
        if (userInfoMapper.updateById(userInfo) <= 0) {
            return ServiceResult.fail("收藏失败");
        }
        if (userFavMapper.insert(userFavorite) <= 0) {
            return ServiceResult.fail("收藏失败");
        }
        return ServiceResult.success();

    }
}
