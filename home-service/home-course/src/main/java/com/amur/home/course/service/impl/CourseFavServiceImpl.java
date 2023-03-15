package com.amur.home.course.service.impl;

import com.amur.home.course.client.UserGrpcClient;
import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.entity.CourseWare;
import com.amur.home.course.mapper.CourseInfoMapper;
import com.amur.home.course.mapper.CourseListMapper;
import com.amur.home.course.mapper.CourseWareMapper;
import com.amur.home.course.service.CourseFavService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CourseFavServiceImpl implements CourseFavService {
    @Resource
    private CourseInfoMapper courseInfoMapper;

    @Resource
    private CourseListMapper courseListMapper;

    @Resource
    private CourseWareMapper courseWareMapper;

    @Resource
    private UserGrpcClient userGrpcClient;

    /**
     * 获取收藏的课程id列表
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<Long>> courseFavList(Long userId) {
        return userGrpcClient.getFavCourses(userId);
    }

    /**
     * 获取收藏的课程详细信息
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<CourseInfo>> courseFavListInfo(Long userId) {
        ServiceResult<List<Long>> res = userGrpcClient.getFavCourses(userId);
        List<Long> courseIds = res.getData();
        List<CourseInfo> courseInfos = new ArrayList<>();
        if (courseIds != null && !courseIds.isEmpty()) {
            QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().in(CourseInfo::getId, courseIds);
            courseInfos = courseInfoMapper.selectList(queryWrapper);
        }
        return ServiceResult.success(courseInfos);
    }

    /**
     * 添加收藏的课程id
     *
     * @param userId   用户ID
     * @param courseId 添加收藏课程ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseFavAdd(Long userId, Long courseId) {
        return userGrpcClient.addFavCourse(userId, courseId);
    }

    /**
     * 删除收藏的课程id
     *
     * @param userId   用户ID
     * @param courseId 删除收藏课程ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseFavDel(Long userId, Long courseId) {
        return userGrpcClient.delFavCourse(userId, courseId);
    }

    /**
     * 获取收藏的课程列表id
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<Long>> courseListFavList(Long userId) {
        return userGrpcClient.getFavCourseLists(userId);
    }

    /**
     * 获取收藏的课程列表详细信息
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<CourseList>> courseListFavListInfo(Long userId) {
        ServiceResult<List<Long>> res = userGrpcClient.getFavCourseLists(userId);
        List<Long> courseListIds = res.getData();
        List<CourseList> courseLists = new ArrayList<>();
        if (courseListIds != null && !courseListIds.isEmpty()) {
            QueryWrapper<CourseList> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().in(CourseList::getId, courseListIds);
            courseLists = courseListMapper.selectList(queryWrapper);
        }
        return ServiceResult.success(courseLists);
    }

    /**
     * 添加收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseListId 添加收藏课程列表ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseListFavAdd(Long userId, Long courseListId) {
        return userGrpcClient.addFavCourseList(userId, courseListId);
    }

    /**
     * 删除收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseListId 删除收藏课程列表ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseListFavDel(Long userId, Long courseListId) {
        return userGrpcClient.delFavCourseList(userId, courseListId);
    }

    /**
     * 获取收藏的课件id
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<Long>> courseWareFavList(Long userId) {
        return userGrpcClient.getFavCourseWares(userId);
    }

    /**
     * 获取收藏的课件详细信息
     *
     * @param userId 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<List<CourseWare>> courseWareFavListInfo(Long userId) {
        ServiceResult<List<Long>> res = userGrpcClient.getFavCourseWares(userId);
        List<Long> courseWareIds = res.getData();
        List<CourseWare> courseWares = new ArrayList<>();
        if (courseWareIds != null && !courseWareIds.isEmpty()) {
            QueryWrapper<CourseWare> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().in(CourseWare::getId, courseWareIds);
            courseWares = courseWareMapper.selectList(queryWrapper);
        }
        return ServiceResult.success(courseWares);
    }

    /**
     * 添加收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseWareId 添加收藏课件ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseWareFavAdd(Long userId, Long courseWareId) {
        return userGrpcClient.addFavCourseWare(userId, courseWareId);
    }

    /**
     * 删除收藏的课程列表id
     *
     * @param userId       用户ID
     * @param courseWareId 删除收藏课件ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> courseWareFavDel(Long userId, Long courseWareId) {
        return userGrpcClient.delFavCourseWare(userId, courseWareId);
    }
}
