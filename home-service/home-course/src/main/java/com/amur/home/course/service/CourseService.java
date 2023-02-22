package com.amur.home.course.service;

import com.amur.home.common.Constants;
import com.amur.home.course.dto.PageResult;
import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.entity.CourseShare;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public interface CourseService {
    ServiceResult<Long> courseAdd(Long homeId, Long userId, String name, String description, Date startTime, Date endTime, String coverUrl);

    ServiceResult<String> courseAddCover(MultipartFile cover);

    ServiceResult<Void> courseDel(Long courseId);

    ServiceResult<PageResult<CourseInfo>> courseSearch(Long homeId, String keyword, Integer pageNum, Integer pageSize);

    ServiceResult<Void> courseUpdate(CourseInfo courseInfo);

    ServiceResult<CourseInfo> courseInfo(Long courseId);

    ServiceResult<?> courseInfoByUserId(Long userId);

    ServiceResult<?> courseInfoByHomeId(Long homeId);

    ServiceResult<?> rank(Long courseId, Double rank);

    ServiceResult<?> commentAdd(Long courseId, Long userId, String comment);

    ServiceResult<?> commentDel(Long courseId, Long userId);

    ServiceResult<?> commentInfoList(Long courseId);

    ServiceResult<?> commentInfoList(Long courseId, String keyword);

    ServiceResult<?> commentInfoByUserId(Long userId);

    ServiceResult<?> share(Long courseId, Long inviterId, Constants.InviteAs as, Date expireTime);

    ServiceResult<CourseShare> shareInfo(String shareToken);

    ServiceResult<CourseShare> joinByToken(String shareToken, Long userId);

    ServiceResult<?> shareInfoByUserId(Long userId);

    ServiceResult<?> shareInfoById(Long courseId);

    ServiceResult<?> shareCancel(String shareToken);

    ServiceResult<?> addStudent(Long courseId, Long userId);

    ServiceResult<?> delStudent(Long courseId, Long userId);

    ServiceResult<?> listStudent(Long courseId);

    ServiceResult<?> addTeacher(Long courseId, Long userId);

    ServiceResult<?> delTeacher(Long courseId, Long userId);

    ServiceResult<?> listTeacher(Long courseId);

    ServiceResult<?> createList(Long homeId, String title, String description, boolean open, List<Long> courseIdList);

    ServiceResult<?> courseListInfo(Long courseId);

    ServiceResult<?> courseListSearch(String keyword);

    ServiceResult<?> courseListInfoByHomeId(Long homeId);

    ServiceResult<?> deleteList(Long listId);

    ServiceResult<?> listAdd(Long listId, Long courseId);

    ServiceResult<?> listRemove(Long listId, Long courseId);

    ServiceResult<?> listUpdate(CourseList courseList);

}
