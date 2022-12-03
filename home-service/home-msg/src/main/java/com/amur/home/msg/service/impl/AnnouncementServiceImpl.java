package com.amur.home.msg.service.impl;

import com.amur.home.common.Constants;
import com.amur.home.dto.PageResult;
import com.amur.home.msg.client.TinyIdGrpcClient;
import com.amur.home.msg.entity.HomeAnnouncement;
import com.amur.home.msg.entity.SystemAnnouncement;
import com.amur.home.msg.mapper.HomeAnnouncementMapper;
import com.amur.home.msg.mapper.SystemAnnouncementMapper;
import com.amur.home.msg.service.AnnouncementService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Service
@Slf4j
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    @Resource
    private HomeAnnouncementMapper homeAnnouncementMapper;

    @Resource
    private SystemAnnouncementMapper systemAnnouncementMapper;

    @Resource
    private TinyIdGrpcClient tinyIdGrpcClient;

    /**
     * @param title
     * @param message
     * @param userIds
     * @param sendTime
     * @return
     */
    @Override
    @GlobalTransactional
    public ServiceResult<Long> createSystemAnnouncement(String title, String message, Set<Long> userIds, Date sendTime) {
        ServiceResult<Long> res = tinyIdGrpcClient.getNextId(Constants.TableName.MSG_SYS.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.ex("id生成失败");
        }
        SystemAnnouncement systemAnnouncement = new SystemAnnouncement(res.getData(), title, message, userIds, sendTime);
        if (systemAnnouncementMapper.insert(systemAnnouncement) > 0) {
            return ServiceResult.success(systemAnnouncement.getId());
        } else {
            return ServiceResult.ex("创建失败");
        }
    }

    /**
     * @param senderId
     * @param homeId
     * @param title
     * @param message
     * @param userIds
     * @param sendTime
     * @return
     */
    @Override
    @GlobalTransactional
    public ServiceResult<Long> createHomeAnnouncement(Long senderId, Long homeId, String title, String message, Set<Long> userIds, Date sendTime) {
        ServiceResult<Long> res = tinyIdGrpcClient.getNextId(Constants.TableName.MSG_HOME.getDesc());
        if (!res.isSuccess()) {
            return ServiceResult.ex("id生成失败");
        }
        HomeAnnouncement homeAnnouncement = new HomeAnnouncement(res.getData(), senderId, homeId, title, message, userIds, sendTime);
        if (homeAnnouncementMapper.insert(homeAnnouncement) > 0) {
            return ServiceResult.success(homeAnnouncement.getId());
        } else {
            return ServiceResult.ex("创建失败");
        }
    }

    /**
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServiceResult<PageResult<HomeAnnouncement>> getHomeAnnouncementList(Long userId, Integer page, Integer size) {
        QueryWrapper<HomeAnnouncement> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_ids", "," + userId + ",");
        queryWrapper.le("send_time", new Date());
//        queryWrapper.apply("FIND_IN_SET({0}, user_ids)", userId);
        IPage<HomeAnnouncement> announcementPage = homeAnnouncementMapper.selectPage(new Page<>(page, size), queryWrapper);
        if (announcementPage.getTotal() == 0) {
            return ServiceResult.successMsg("没有搜索到相关公告");
        }
        if (page > announcementPage.getPages()) {
            return ServiceResult.ex("页数超出限制或当前页无公告");
        }
        PageResult<HomeAnnouncement> result = new PageResult<>(page, size, announcementPage.getTotal(), announcementPage.getPages(), announcementPage.getRecords());
        return ServiceResult.success(result);
    }

    /**
     * @param homeId
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServiceResult<PageResult<HomeAnnouncement>> getHomeAnnouncementListByHomeId(Long homeId, Integer page, Integer size) {
        QueryWrapper<HomeAnnouncement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("home_id", homeId);
        queryWrapper.le("send_time", new Date());
        IPage<HomeAnnouncement> announcementPage = homeAnnouncementMapper.selectPage(new Page<>(page, size), queryWrapper);
        if (announcementPage.getTotal() == 0) {
            return ServiceResult.successMsg("没有搜索到相关公告");
        }
        if (page > announcementPage.getPages()) {
            return ServiceResult.ex("页数超出限制或当前页无公告");
        }
        PageResult<HomeAnnouncement> result = new PageResult<>(page, size, announcementPage.getTotal(), announcementPage.getPages(), announcementPage.getRecords());
        return ServiceResult.success(result);
    }

    /**
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @Override
    public ServiceResult<PageResult<SystemAnnouncement>> getSystemAnnouncementList(Long userId, Integer page, Integer size) {
        QueryWrapper<SystemAnnouncement> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_ids", "," + userId + ",");
        queryWrapper.le("send_time", new Date());
        IPage<SystemAnnouncement> announcementPage = systemAnnouncementMapper.selectPage(new Page<>(page, size), queryWrapper);
        if (announcementPage.getTotal() == 0) {
            return ServiceResult.successMsg("没有搜索到相关公告");
        }
        if (page > announcementPage.getPages()) {
            return ServiceResult.ex("页数超出限制或当前页无公告");
        }
        PageResult<SystemAnnouncement> result = new PageResult<>(page, size, announcementPage.getTotal(), announcementPage.getPages(), announcementPage.getRecords());
        return ServiceResult.success(result);
    }

    /**
     * @param announcementId
     * @return
     */
    @Override
    public ServiceResult<HomeAnnouncement> getHomeAnnouncementDetail(Long announcementId) {
        HomeAnnouncement homeAnnouncement = homeAnnouncementMapper.selectById(announcementId);
        if (homeAnnouncement == null) {
            return ServiceResult.ex("公告不存在");
        }
        return ServiceResult.success(homeAnnouncement);
    }

    /**
     * @param announcementId
     * @return
     */
    @Override
    public ServiceResult<SystemAnnouncement> getSystemAnnouncementDetail(Long announcementId) {
        SystemAnnouncement sysAnnouncement = systemAnnouncementMapper.selectById(announcementId);
        if (sysAnnouncement == null) {
            return ServiceResult.ex("公告不存在");
        }
        return ServiceResult.success(sysAnnouncement);
    }

    /**
     * @param announcementId
     * @param type
     * @return
     */
    @Override
    public ServiceResult<Void> deleteAnnouncement(Long announcementId, String type) {
        if (type.equals("home")) {
            if (homeAnnouncementMapper.deleteById(announcementId) > 0) {
                return ServiceResult.success();
            } else {
                return ServiceResult.ex("删除失败");
            }
        } else if (type.equals("system")) {
            if (systemAnnouncementMapper.deleteById(announcementId) > 0) {
                return ServiceResult.success();
            } else {
                return ServiceResult.ex("删除失败");
            }
        } else {
            return ServiceResult.ex("类型错误");
        }
    }

    /**
     * @param announcementId
     * @param title
     * @param message
     * @param userIds
     * @param sendTime
     * @return
     */
    @Override
    public ServiceResult<Void> updateHomeAnnouncement(Long announcementId, String title, String message, Collection<Long> userIds, Date sendTime) {
        HomeAnnouncement homeAnnouncement = homeAnnouncementMapper.selectById(announcementId);
        if (homeAnnouncement == null) {
            return ServiceResult.ex("公告不存在");
        }
        if (title != null) {
            homeAnnouncement.setTitle(title);
        }
        if (message != null) {
            homeAnnouncement.setMessage(message);
        }
        if (userIds != null) {
            homeAnnouncement.getUserIds().addAll(userIds);
        }
        if (sendTime != null) {
            homeAnnouncement.setSendTime(sendTime);
        }
        if (homeAnnouncementMapper.updateById(homeAnnouncement) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("更新失败");
        }
    }

    /**
     * @param announcementId
     * @param title
     * @param message
     * @param userIds
     * @param sendTime
     * @return
     */
    @Override
    public ServiceResult<Void> updateSystemAnnouncement(Long announcementId, String title, String message, Collection<Long> userIds, Date sendTime) {
        SystemAnnouncement systemAnnouncement = systemAnnouncementMapper.selectById(announcementId);
        if (systemAnnouncement == null) {
            return ServiceResult.ex("公告不存在");
        }
        if (title != null) {
            systemAnnouncement.setTitle(title);
        }
        if (message != null) {
            systemAnnouncement.setMessage(message);
        }
        if (userIds != null) {
            systemAnnouncement.getUserIds().addAll(userIds);
        }
        if (sendTime != null) {
            systemAnnouncement.setSendTime(sendTime);
        }
        if (systemAnnouncementMapper.updateById(systemAnnouncement) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("更新失败");
        }
    }
}
