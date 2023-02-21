package com.amur.home.user.service;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HomeService {
    public ServiceResult<HomeInfo> getHomeInfo(Long homeId);

    public ServiceResult<List<HomeInfo>> getHomeList();

    public ServiceResult<Long> createHome(HomeInfo homeInfo);

    public ServiceResult<Void> updateHome(HomeInfo homeInfo);

    public ServiceResult<Void> deleteHome(Long homeId);

    public ServiceResult<List<UserInfo>> getHomeUserList(Long homeId);

    public ServiceResult<Void> updateHomeUser(Long homeId, Long userId);

    public ServiceResult<Void> deleteHomeUser(Long homeId, Long userId);

    public ServiceResult<Void> setHomeAdmin(Long homeId, Long userId);

//    public boolean addHomeImage(AddHomeImageDto request);
}
