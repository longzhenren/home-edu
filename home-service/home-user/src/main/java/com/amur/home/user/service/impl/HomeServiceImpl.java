package com.amur.home.user.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.amur.home.user.dto.AddHomeImageDto;
import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.mapper.HomeMapper;
import com.amur.home.user.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HomeServiceImpl implements HomeService {
    @Resource
    private HomeMapper homeMapper;

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
        return JSON.parseArray(homeEntity.getHomeUserIds(),Long.class).stream().map(entity -> {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(entity);
            return userEntity;
        }).collect(Collectors.toList());
    }

    /**
     * @param homeId
     * @param userId
     * @return
     */
    @Override
    public boolean updateHomeUser(Long homeId, Long userId) {
        HomeEntity homeEntity = homeMapper.selectById(homeId);
        List<Long> userIds = JSON.parseArray(homeEntity.getHomeUserIds(),Long.class);
        userIds.add(userId);
        homeEntity.setHomeUserIds(JSONArray.toJSONString(userIds));
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
        List<Long> userIds = JSON.parseArray(homeEntity.getHomeUserIds(),Long.class);
        userIds.remove(userId);
        homeEntity.setHomeUserIds(JSONArray.toJSONString(userIds));
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

    /**
     * @param request
     * @return
     */
    @Override
    public boolean addHomeImage(AddHomeImageDto request) {
        HomeEntity homeEntity = homeMapper.selectById(request.getHomeId());
        List<String> imageUrls = JSON.parseArray(homeEntity.getImageUrls(),String.class);
        imageUrls.addAll(request.getImageUrl());
        homeEntity.setImageUrls(JSONArray.toJSONString(imageUrls));
        return homeMapper.updateById(homeEntity) > 0;
    }
}
