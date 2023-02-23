package com.amur.home.user.service.impl;

import com.amur.home.common.Constants;
import com.amur.home.user.client.TinyIdClient;
import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.entity.UserFavorite;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.HomeInfoMapper;
import com.amur.home.user.mapper.UserFavMapper;
import com.amur.home.user.mapper.UserInfoMapper;
import com.amur.home.user.service.HomeService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HomeServiceImpl implements HomeService {
    @Resource
    private HomeInfoMapper homeInfoMapper;

    @Resource
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
     * 根据家庭ID获取家庭信息
     *
     * @param homeId 家庭ID
     * @return 家庭信息
     */
    @Override
    public ServiceResult<HomeInfo> getHomeInfo(Long homeId) {
        HomeInfo homeInfo = homeInfoMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        } else {
            return ServiceResult.success(homeInfo);
        }
    }

    /**
     * 获取家庭列表
     *
     * @return 家庭列表
     */
    @Override
    public ServiceResult<List<HomeInfo>> getHomeList() {
        List<HomeInfo> homeInfoList = homeInfoMapper.selectList(null);
        return ServiceResult.success(homeInfoList);
    }

    @Override
    public ServiceResult<Long> createHome(String name, String description, Long userId, String avatarUrl, Boolean open) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (userInfo.getHomeId() != null && userInfo.getHomeId() > 0) {
            return ServiceResult.fail("用户已经加入家庭");
        }
        ServiceResult<Long> res = tinyIdClient.getNextId(Constants.TableName.HOME_INFO.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.fail("id生成失败");
        }
        HomeInfo homeInfo = new HomeInfo();
        homeInfo.setId(res.getData());
        homeInfo.setCreateUserId(userId);
        homeInfo.setName(name);
        homeInfo.setDescription(description == null ? "" : description);
        homeInfo.setAvatarUrl(avatarUrl == null ? "" : avatarUrl);
        homeInfo.setAdminIds(Collections.singleton(userId));
        homeInfo.setMemberIds(Collections.singleton(userId));
        homeInfo.setImageUrls(Collections.emptyList());
        homeInfo.setLikeCount(0L);
        homeInfo.setFavCount(0L);
        homeInfo.setOpen(open != null && open);
        if (homeInfoMapper.insert(homeInfo) <= 0) {
            return ServiceResult.fail("创建家庭失败");
        }
        Long homeId = homeInfo.getId();
        userInfo.setHomeId(homeId);
        userInfo.setRelativeType(Constants.UserRelativeType.OTHER);
        if (userInfoMapper.updateById(userInfo) <= 0) {
            return ServiceResult.fail("创建家庭失败");
        }
        return ServiceResult.success(homeId);
    }

    /**
     * @param file 文件
     * @return 文件URL
     */
    @Override
    public ServiceResult<String> updateAvatar(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileExtension;

        String bucketName = "home-avatar";
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
     * @param file 文件
     * @return
     */
    @Override
    public ServiceResult<String> uploadPicture(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileExtension;

        String bucketName = "home-pic";
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
     * 更新家庭信息
     *
     * @param homeInfo 家庭信息
     * @return 是否更新成功
     */
    @Override
    public ServiceResult<Void> updateHome(HomeInfo homeInfo) {
        if (homeInfoMapper.updateById(homeInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("更新失败");
        }
    }

    /**
     * 根据家庭ID删除家庭
     *
     * @param homeId 家庭ID
     * @return 是否删除成功
     */
    @Override
    public ServiceResult<Void> deleteHome(Long homeId, Long userId) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("home_id", homeId).ne("user_id", userId);
        List<UserInfo> userInfoList = userInfoMapper.selectList(queryWrapper);
        if (userInfoList.size() > 0) {
            return ServiceResult.fail("家庭中还有其他用户，无法删除");
        }
        if (homeInfoMapper.deleteById(homeId) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除失败");
        }
    }

    /**
     * @param keyword 关键字
     * @return 家庭信息列表
     */
    @Override
    public ServiceResult<List<HomeInfo>> searchHome(String keyword) {
        QueryWrapper<HomeInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open", true).like("name", keyword).or().like("description", keyword);
        List<HomeInfo> homeInfoList = homeInfoMapper.selectList(queryWrapper);
        if (homeInfoList.size() > 0) {
            return ServiceResult.success(homeInfoList);
        } else {
            return ServiceResult.fail("没有搜索到相关家庭");
        }
    }

    /**
     * 根据家庭ID获取家庭用户列表
     *
     * @param homeId 家庭ID
     * @return 家庭用户列表
     */
    @Override
    public ServiceResult<List<UserInfo>> getHomeUserList(Long homeId) {
        HomeInfo homeInfo = homeInfoMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        List<Long> userIdList = new ArrayList<>(homeInfo.getMemberIds());
        return ServiceResult.success(userIdList.stream().map(userId -> userInfoMapper.selectById(userId)).collect(Collectors.toList()));
    }

    /**
     * 更新家庭用户
     *
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return 是否更新成功
     */
    @Override
    public ServiceResult<Void> updateHomeUser(Long homeId, Long userId) {
        HomeInfo homeInfo = homeInfoMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (userInfo.getHomeId() != null && userInfo.getHomeId() != 0) {
            return ServiceResult.fail("用户已经加入家庭");
        }
        homeInfo.getMemberIds().add(userId);
        userInfo.setHomeId(homeId);
        if (homeInfoMapper.updateById(homeInfo) > 0 && userInfoMapper.updateById(userInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("保存失败");
        }
    }

    /**
     * 删除家庭用户
     *
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return 是否删除成功
     */
    @Override
    public ServiceResult<Void> deleteHomeUser(Long homeId, Long userId) {
        HomeInfo homeInfo = homeInfoMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (!homeInfo.getMemberIds().contains(userId)) {
            return ServiceResult.fail("成员不在家庭中");
        }
        homeInfo.getMemberIds().remove(userId);
        userInfo.setHomeId(0L);
        if (homeInfoMapper.updateById(homeInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除用户失败");
        }
    }

    /**
     * 设置家庭管理员
     *
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return 是否设置成功
     */
    @Override
    public ServiceResult<Void> setHomeAdmin(Long homeId, Long userId) {
        HomeInfo homeInfo = homeInfoMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        homeInfo.getAdminIds().add(userId);
        if (homeInfoMapper.updateById(homeInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("设置管理员失败");
        }
    }

    /**
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return
     */
    @Override
    public ServiceResult<Void> removeHomeAdmin(Long homeId, Long userId) {
        HomeInfo homeInfo = homeInfoMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        if (!homeInfo.getAdminIds().contains(userId)) {
            return ServiceResult.fail("用户不是管理员");
        }
        homeInfo.getAdminIds().remove(userId);
        if (homeInfoMapper.updateById(homeInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除管理员失败");
        }
    }

    /**
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return
     */
    @Override
    public ServiceResult<Void> favHome(Long homeId, Long userId) {
        HomeInfo homeInfo = homeInfoMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        UserFavorite userFavorite = userFavMapper.selectById(userId);
        if (userFavorite == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (userFavorite.getHomeIds().contains(homeId)) {
            return ServiceResult.fail("已经收藏过该家庭");
        }
        homeInfo.setFavCount(homeInfo.getFavCount() + 1);
        userFavorite.getHomeIds().add(homeId);
        if (homeInfoMapper.updateById(homeInfo) > 0 && userFavMapper.insert(userFavorite) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("收藏失败");
        }
    }


}
