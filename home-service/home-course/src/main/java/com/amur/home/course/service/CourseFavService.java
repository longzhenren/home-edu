package com.amur.home.course.service;

import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.entity.CourseWare;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseFavService {
    ServiceResult<List<Long>> courseFavList(Long userId);

    ServiceResult<List<CourseInfo>> courseFavListInfo(Long userId);

    ServiceResult<Void> courseFavAdd(Long userId, Long courseId);

    ServiceResult<Void> courseFavDel(Long userId, Long courseId);

    ServiceResult<List<Long>> courseListFavList(Long userId);

    ServiceResult<List<CourseList>> courseListFavListInfo(Long userId);

    ServiceResult<Void> courseListFavAdd(Long userId, Long courseListId);

    ServiceResult<Void> courseListFavDel(Long userId, Long courseListId);

    ServiceResult<List<Long>> courseWareFavList(Long userId);

    ServiceResult<List<CourseWare>> courseWareFavListInfo(Long userId);

    ServiceResult<Void> courseWareFavAdd(Long userId, Long courseWareId);

    ServiceResult<Void> courseWareFavDel(Long userId, Long courseWareId);

}
