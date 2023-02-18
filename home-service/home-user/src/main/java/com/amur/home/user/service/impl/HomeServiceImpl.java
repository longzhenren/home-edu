package com.amur.home.user.service.impl;

import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.entity.UserEntity;
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
     * @param homeId
     * @return
     */
    @Override
    public HomeEntity getHomeInfo(Long homeId) {
        return homeMapper.selectById(homeId);
    }

    /**
     * @return
     */
    @Override
    public List<HomeEntity> getHomeList() {
        return homeMapper.selectList(null);
    }

    /**
     * @param homeEntity
     * @return
     */
    @Override
    public Long createHome(HomeEntity homeEntity) {
        homeMapper.insert(homeEntity);
        return homeEntity.getId();
    }

    /**
     * @param homeEntity
     * @return
     */
    @Override
    public boolean updateHome(HomeEntity homeEntity) {
        return homeMapper.updateById(homeEntity) > 0;
    }

    /**
     * @param homeId
     * @return
     */
    @Override
    public boolean deleteHome(Long homeId) {
        return homeMapper.deleteById(homeId) > 0;
    }

    /**
     * @param homeId
     * @return
     */
    @Override
    public List<UserEntity> getHomeUserList(Long homeId) {
        HomeEntity homeEntity = homeMapper.selectById(homeId);
        if (homeEntity == null) {
            return null;
        }
        List<Long> userIdList = new ArrayList<>(homeEntity.getHomeUserIds());
        return userIdList.stream().map(userId -> userMapper.selectById(userId)).collect(Collectors.toList());
    }

    /**
     * @param homeId
     * @param userId
     * @return
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
     * @param homeId
     * @param userId
     * @return
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
     * @param homeId
     * @param userId
     * @return
     */
    @Override
    public boolean setHomeAdmin(Long homeId, Long userId) {
        HomeEntity homeEntity = homeMapper.selectById(homeId);
        homeEntity.setAdminId(userId);
        return homeMapper.updateById(homeEntity) > 0;
    }
}
