package com.amur.home.course.controller;

import com.amur.home.course.dto.UserCourseInterDTO;
import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.service.CourseFavService;
import com.amur.home.course.service.CourseService;
import com.amur.home.dto.PageResult;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Tag(name = "课程信息接口")
@Slf4j
@RestController
@RequestMapping("/course")
public class CourseListController {
    @Resource
    private CourseService courseService;

    @Resource
    private CourseFavService courseFavService;

    @PostMapping("/list/create")
    @Parameters({@Parameter(name = "homeId", in = ParameterIn.QUERY, required = true, description = "家庭ID"), @Parameter(name = "title", in = ParameterIn.QUERY, required = true, description = "课程集合标题"), @Parameter(name = "description", in = ParameterIn.QUERY, required = true, description = "课程集合描述"), @Parameter(name = "open", in = ParameterIn.QUERY, required = true, description = "是否公开"), @Parameter(name = "courseIdList", in = ParameterIn.QUERY, required = true, description = "课程ID列表")})
    @Operation(summary = "创建课程集合")
    public ResponseWrapper<?> createList(Long homeId, String title, String description, Boolean open, List<Long> courseIdList) {
        ServiceResult<?> res = courseService.createList(homeId, title, description, open, courseIdList);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/list/info")
    @Operation(summary = "查看课程集合")
    @Parameters({@Parameter(name = "listId", in = ParameterIn.QUERY, required = true, description = "课程集合ID")})
    public ResponseWrapper<?> courseListInfo(Long courseId) {
        ServiceResult<?> res = courseService.courseListInfo(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/list/search")
    @Operation(summary = "搜索课程集合")
    @Parameters({@Parameter(name = "keyword", in = ParameterIn.QUERY, required = true, description = "关键字")})
    public ResponseWrapper<?> courseListSearch(String keyword) {
        ServiceResult<?> res = courseService.courseListSearch(keyword);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/list/info/home")
    @Operation(summary = "查看家庭创建的课程集合")
    @Parameters({@Parameter(name = "homeId", in = ParameterIn.QUERY, required = true, description = "家庭ID")})
    public ResponseWrapper<?> courseListInfoByHomeId(Long homeId) {
        ServiceResult<?> res = courseService.courseListInfoByHomeId(homeId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/list/del")
    @Operation(summary = "删除课程集合")
    @Parameters({@Parameter(name = "listId", in = ParameterIn.QUERY, required = true, description = "课程集合ID")})
    public ResponseWrapper<?> deleteList(Long listId) {
        ServiceResult<?> res = courseService.deleteList(listId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/list/add")
    @Operation(summary = "添加到课程集合")
    @Parameters({@Parameter(name = "listId", in = ParameterIn.QUERY, required = true, description = "课程集合ID"), @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> listAdd(Long listId, Long courseId) {
        ServiceResult<?> res = courseService.listAdd(listId, courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/list/rm")
    @Operation(summary = "从课程集合删除")
    @Parameters({@Parameter(name = "listId", in = ParameterIn.QUERY, required = true, description = "课程集合ID"), @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> listRemove(Long listId, Long courseId) {
        ServiceResult<?> res = courseService.listRemove(listId, courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/list/update")
    @Operation(summary = "修改课程集合信息")
    @Parameters({@Parameter(name = "id", in = ParameterIn.QUERY, required = true, description = "课程集合ID"), @Parameter(name = "title", in = ParameterIn.QUERY, required = true, description = "课程集合标题"), @Parameter(name = "description", in = ParameterIn.QUERY, required = true, description = "课程集合描述"), @Parameter(name = "coverUrl", in = ParameterIn.QUERY, required = true, description = "课程集合封面"), @Parameter(name = "open", in = ParameterIn.QUERY, required = true, description = "是否公开")})
    public ResponseWrapper<?> listUpdate(Long id, String title, String description, String coverUrl, Boolean open) {
        ServiceResult<?> res = courseService.listUpdate(id, title, description, coverUrl, open);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/list/fav/list")
    @Operation(summary = "查看收藏课程列表")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<List<Long>> courseListFavList(Long userId) {
        ServiceResult<List<Long>> res = courseFavService.courseListFavList(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/list/fav/list/info")
    @Operation(summary = "查看收藏课程列表详情")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<List<CourseList>> courseListFavListInfo(Long userId) {
        ServiceResult<List<CourseList>> res = courseFavService.courseListFavListInfo(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/list/fav/add")
    @Operation(summary = "添加收藏课程列表")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseListId", in = ParameterIn.QUERY, required = true, description = "课程列表ID")})
    public ResponseWrapper<Void> courseListFavAdd(Long userId, Long courseListId) {
        ServiceResult<Void> res = courseFavService.courseListFavAdd(userId, courseListId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/list/fav/cancel")
    @Operation(summary = "取消收藏课程列表")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseListId", in = ParameterIn.QUERY, required = true, description = "课程列表ID")})
    public ResponseWrapper<Void> courseListFavDel(Long userId, Long courseListId) {
        ServiceResult<Void> res = courseFavService.courseListFavDel(userId, courseListId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }
}
