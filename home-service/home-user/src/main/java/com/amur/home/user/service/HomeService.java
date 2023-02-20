package com.amur.home.user.service;

import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {
    public HomeEntity getHomeInfo(Long homeId);

    public List<HomeEntity> getHomeList();

    public Long createHome(HomeEntity homeEntity);

    public boolean updateHome(HomeEntity homeEntity);

    public boolean deleteHome(Long homeId);

    public List<UserInfo> getHomeUserList(Long homeId);

    public boolean updateHomeUser(Long homeId, Long userId);

    public boolean deleteHomeUser(Long homeId, Long userId);

    public boolean setHomeAdmin(Long homeId, Long userId);

//    public boolean addHomeImage(AddHomeImageDto request);
}
