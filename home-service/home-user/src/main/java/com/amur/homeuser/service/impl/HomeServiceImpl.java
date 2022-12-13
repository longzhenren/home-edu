package com.amur.homeuser.service.impl;

import com.amur.homeuser.dto.AddHomeImageDto;
import com.amur.homeuser.entity.HomeEntity;
import com.amur.homeuser.entity.UserEntity;
import com.amur.homeuser.mapper.HomeMapper;
import com.amur.homeuser.service.HomeService;
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
        return homeMapper.getHomeById(homeId);
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
        HomeEntity homeEntity = homeMapper.getHomeById(homeId);
        return homeEntity.getHomeUserIds().stream().map(entity -> {
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
        HomeEntity homeEntity = homeMapper.getHomeById(homeId);
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
        HomeEntity homeEntity = homeMapper.getHomeById(homeId);
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
        HomeEntity homeEntity = homeMapper.getHomeById(homeId);
        homeEntity.setAdminId(userId);
        return homeMapper.updateById(homeEntity) > 0;
    }

    /**
     * @param request
     * @return
     */
    @Override
    public boolean addHomeImage(AddHomeImageDto request) {
        HomeEntity homeEntity = homeMapper.getHomeById(request.getHomeId());
        homeEntity.getImageUrls().addAll(request.getImageUrl());
        return homeMapper.updateById(homeEntity) > 0;
    }
}
