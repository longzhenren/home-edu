package com.amur.home.user.service.impl;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.HomeMapper;
import com.amur.home.user.mapper.UserMapper;
import com.amur.home.user.service.HomeService;
import com.amur.home.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HomeServiceImpl implements HomeService {
    @Resource
    private HomeMapper homeMapper;

    @Resource
    private UserMapper userMapper;


    /**
     * 根据家庭ID获取家庭信息
     *
     * @param homeId 家庭ID
     * @return 家庭信息
     */
    @Override
    public ServiceResult<HomeInfo> getHomeInfo(Long homeId) {
        HomeInfo homeInfo = homeMapper.selectById(homeId);
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
        List<HomeInfo> homeInfoList = homeMapper.selectList(null);
        return ServiceResult.success(homeInfoList);
    }

    /**
     * 创建家庭
     *
     * @param homeInfo 家庭信息
     * @return 家庭ID
     */
    @Override
    public ServiceResult<Long> createHome(HomeInfo homeInfo) {
        if (homeMapper.insert(homeInfo) > 0) {
            return ServiceResult.success(homeInfo.getId());
        } else {
            return ServiceResult.fail("创建家庭失败");
        }

    }

    /**
     * 更新家庭信息
     *
     * @param homeInfo 家庭信息
     * @return 是否更新成功
     */
    @Override
    public ServiceResult<Void> updateHome(HomeInfo homeInfo) {
        if (homeMapper.updateById(homeInfo) > 0) {
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
    public ServiceResult<Void> deleteHome(Long homeId) {
        if (homeMapper.deleteById(homeId) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除失败");
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
        HomeInfo homeInfo = homeMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        List<Long> userIdList = new ArrayList<>(homeInfo.getHomeUserIds());
        return ServiceResult.success(userIdList.stream().map(userId -> userMapper.selectById(userId)).collect(Collectors.toList()));
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
        HomeInfo homeInfo = homeMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        UserInfo userInfo = userMapper.selectById(userId);
        if (userInfo == null) {
            return ServiceResult.fail("用户不存在");
        }
        homeInfo.getHomeUserIds().add(userId);
        if (homeMapper.updateById(homeInfo) > 0) {
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
        HomeInfo homeInfo = homeMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        homeInfo.getHomeUserIds().remove(userId);
        if (homeMapper.updateById(homeInfo) > 0) {
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
        HomeInfo homeInfo = homeMapper.selectById(homeId);
        if (homeInfo == null) {
            return ServiceResult.fail("家庭不存在");
        }
        homeInfo.setAdminId(userId);
        if (homeMapper.updateById(homeInfo) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("设置管理员失败");
        }
    }
}
