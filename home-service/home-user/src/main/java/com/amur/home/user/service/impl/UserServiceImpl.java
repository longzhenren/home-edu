package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.UserMapper;
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
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    @Setter
    private UserMapper userMapper;

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
        UserInfo userInfo = userMapper.selectById(userId);
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
        if (userMapper.updateById(userInfo) > 0) {
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
        ServiceResult<Void> result = new ServiceResult<>();
        if (userMapper.deleteById(userId) > 0) {
            result.setSuccess(true);
        } else {
            result.setMessage("删除用户失败！");
        }
        return result;
    }

    /**
     * 创建用户。
     *
     * @param userName 用户名。
     * @return 新创建的用户的 ID。
     */
    @Override
    public ServiceResult<Long> createUser(String userName) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(userName);
        int res = userMapper.insert(userInfo);
        if (res <= 0) {
            return ServiceResult.fail("创建用户失败");
        } else {
            return ServiceResult.success(userInfo.getId());
        }
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
        UserInfo userInfo = userMapper.selectOne(queryWrapper);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        } else {
            return ServiceResult.success(userInfo);
        }
    }
}
