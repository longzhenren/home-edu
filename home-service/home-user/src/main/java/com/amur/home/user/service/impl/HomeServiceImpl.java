package com.amur.home.user.service.impl;

import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.mapper.HomeMapper;
import com.amur.home.user.mapper.UserMapper;
import com.amur.home.user.service.HomeService;
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
    public HomeEntity getHomeInfo(Long homeId) {
        return homeMapper.selectById(homeId);
    }

    /**
     * 获取家庭列表
     *
     * @return 家庭列表
     */
    @Override
    public List<HomeEntity> getHomeList() {
        return homeMapper.selectList(null);
    }

    /**
     * 创建家庭
     *
     * @param homeEntity 家庭信息
     * @return 家庭ID
     */
    @Override
    public Long createHome(HomeEntity homeEntity) {
        homeMapper.insert(homeEntity);
        return homeEntity.getId();
    }

    /**
     * 更新家庭信息
     *
     * @param homeEntity 家庭信息
     * @return 是否更新成功
     */
    @Override
    public boolean updateHome(HomeEntity homeEntity) {
        return homeMapper.updateById(homeEntity) > 0;
    }

    /**
     * 根据家庭ID删除家庭
     *
     * @param homeId 家庭ID
     * @return 是否删除成功
     */
    @Override
    public boolean deleteHome(Long homeId) {
        return homeMapper.deleteById(homeId) > 0;
    }

    /**
     * 根据家庭ID获取家庭用户列表
     *
     * @param homeId 家庭ID
     * @return 家庭用户列表
     */
    @Override
    public List<UserInfo> getHomeUserList(Long homeId) {
        HomeEntity homeEntity = homeMapper.selectById(homeId);
        if (homeEntity == null) {
            return null;
        }
        List<Long> userIdList = new ArrayList<>(homeEntity.getHomeUserIds());
        return userIdList.stream().map(userId -> userMapper.selectById(userId)).collect(Collectors.toList());
    }

    /**
     * 更新家庭用户
     *
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return 是否更新成功
     */
    @Override
    public boolean updateHomeUser(Long homeId, Long userId) {
        HomeEntity homeEntity = homeMapper.selectById(homeId);
        if (homeEntity == null) {
            return false;
        }
        homeEntity.getHomeUserIds().add(userId);
        return homeMapper.updateById(homeEntity) > 0;
    }

    /**
     * 删除家庭用户
     *
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return 是否删除成功
     */
    @Override
    public boolean deleteHomeUser(Long homeId, Long userId) {
        HomeEntity homeEntity = homeMapper.selectById(homeId);
        if (homeEntity == null) {
            return false;
        }
        homeEntity.getHomeUserIds().remove(userId);
        return homeMapper.updateById(homeEntity) > 0;
    }

    /**
     * 设置家庭管理员
     *
     * @param homeId 家庭ID
     * @param userId 用户ID
     * @return 是否设置成功
     */
    @Override
    public boolean setHomeAdmin(Long homeId, Long userId) {
        HomeEntity homeEntity = homeMapper.selectById(homeId);
        homeEntity.setAdminId(userId);
        return homeMapper.updateById(homeEntity) > 0;
    }
}
