package com.amur.home.msg.service;

import com.amur.home.dto.PageResult;
import com.amur.home.msg.entity.HomeAnnouncement;
import com.amur.home.msg.entity.SystemAnnouncement;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Service
public interface AnnouncementService {
    ServiceResult<Long> createSystemAnnouncement(String title, String message, Set<Long> userIds, Date sendTime);

    ServiceResult<Long> createHomeAnnouncement(Long senderId, Long homeId, String title, String message, Set<Long> userIds, Date sendTime);

    ServiceResult<PageResult<HomeAnnouncement>> getHomeAnnouncementList(Long userId, Integer page, Integer size);

    ServiceResult<PageResult<HomeAnnouncement>> getHomeAnnouncementListByHomeId(Long homeId, Integer page, Integer size);

    ServiceResult<PageResult<SystemAnnouncement>> getSystemAnnouncementList(Long userId, Integer page, Integer size);

    ServiceResult<HomeAnnouncement> getHomeAnnouncementDetail(Long announcementId);

    ServiceResult<SystemAnnouncement> getSystemAnnouncementDetail(Long announcementId);

    ServiceResult<Void> deleteAnnouncement(Long announcementId, String type);

    ServiceResult<Void> updateHomeAnnouncement(Long announcementId, String title, String message, Collection<Long> userIds, Date sendTime);

    ServiceResult<Void> updateSystemAnnouncement(Long announcementId, String title, String message, Collection<Long> userIds, Date sendTime);

}
