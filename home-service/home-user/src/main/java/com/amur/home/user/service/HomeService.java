package com.amur.home.user.service;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface HomeService {
    ServiceResult<HomeInfo> getHomeInfo(Long homeId);

    ServiceResult<List<HomeInfo>> getHomeList();

    ServiceResult<Long> createHome(String name, String description, Long userId, String avatarUrl, Boolean open);

    ServiceResult<String> updateAvatar(MultipartFile file);

    ServiceResult<String> uploadPicture(MultipartFile file);

    ServiceResult<Void> updateHome(HomeInfo homeInfo);

    ServiceResult<Void> deleteHome(Long homeId, Long userId);

    ServiceResult<List<HomeInfo>> searchHome(String keyword);

    ServiceResult<List<UserInfo>> getHomeUserList(Long homeId);

    ServiceResult<Void> updateHomeUser(Long homeId, Long userId);

    ServiceResult<Void> deleteHomeUser(Long homeId, Long userId);

    ServiceResult<Void> setHomeAdmin(Long homeId, Long userId);

    ServiceResult<Void> removeHomeAdmin(Long homeId, Long userId);

    ServiceResult<Void> favHome(Long homeId, Long userId);

    ServiceResult<Void> unfavHome(Long homeId, Long userId);

    ServiceResult<List<HomeInfo>> getFavHome(Long userId);

    ServiceResult<Page<HomeInfo>> queryHomeInfo(Map<String, Map<String, Object>> params, String sortField, String sortOrder, Integer pageNumber, Integer pageSize);

    ServiceResult<List<UserInfo>> getHomeUser(Long homeId);

    ServiceResult<Boolean> isLikeHome(Long homeId, Long userId);

    ServiceResult<Boolean> isFavHome(Long homeId, Long userId);

    ServiceResult<Void> unlikeHome(Long homeId, Long userId);

    ServiceResult<Void> likeHome(Long homeId, Long userId);

//    boolean addHomeImage(AddHomeImageDto request);
}
