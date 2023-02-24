package com.amur.home.course.controller;

import com.amur.home.course.dto.PageResult;
import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.service.CourseFavService;
import com.amur.home.course.service.CourseService;
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

@Tag(name = "课程信息接口")
@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    @Resource
    private CourseFavService courseFavService;

    @PostMapping("/add")
    @Operation(summary = "添加课程")
    @Parameters({@Parameter(name = "homeId", in = ParameterIn.QUERY, required = true, description = "家庭ID"), @Parameter(name = "name", in = ParameterIn.QUERY, required = true, description = "课程名称"), @Parameter(name = "description", in = ParameterIn.QUERY, required = true, description = "课程描述"), @Parameter(name = "startTime", in = ParameterIn.QUERY, required = true, description = "课程开始时间"), @Parameter(name = "endTime", in = ParameterIn.QUERY, required = true, description = "课程结束时间"), @Parameter(name = "cover", in = ParameterIn.QUERY, required = false, description = "封面图")})
    public ResponseWrapper<Long> courseAdd(Long homeId, Long userId, String name, String description, Date startTime, Date endTime, String coverUrl) {
        ServiceResult<Long> res = courseService.courseAdd(homeId, userId, name, description, startTime, endTime, coverUrl);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/add/cover")
    @Operation(summary = "添加课程封面")
    @Parameters({@Parameter(name = "cover", in = ParameterIn.QUERY, required = true, description = "封面图")})
    public ResponseWrapper<String> courseAddCover(MultipartFile cover) {
        ServiceResult<String> res = courseService.courseAddCover(cover);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/del")
    @Operation(summary = "删除课程")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<Void> courseDel(Long courseId) {
        ServiceResult<Void> res = courseService.courseDel(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/fav/list")
    @Operation(summary = "查看收藏课程")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<List<Long>> courseFavList(Long userId) {
        ServiceResult<List<Long>> res = courseFavService.courseFavList(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/fav/list/info")
    @Operation(summary = "查看收藏课程详情")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<List<CourseInfo>> courseFavListInfo(Long userId) {
        ServiceResult<List<CourseInfo>> res = courseFavService.courseFavListInfo(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/fav/add")
    @Operation(summary = "添加收藏课程")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<Void> courseFavAdd(Long userId, Long courseId) {
        ServiceResult<Void> res = courseFavService.courseFavAdd(userId, courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }


    @PostMapping("/fav/cancel")
    @Operation(summary = "取消收藏课程")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<Void> courseFavDel(Long userId, Long courseId) {
        ServiceResult<Void> res = courseFavService.courseFavDel(userId, courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/search")
    @Operation(summary = "搜索课程")
    @Parameters({@Parameter(name = "homeId", in = ParameterIn.QUERY, required = true, description = "家庭ID"), @Parameter(name = "keyword", in = ParameterIn.QUERY, required = true, description = "关键字")})
    public ResponseWrapper<PageResult<CourseInfo>> courseSearch(Long homeId, String keyword, Integer pageNum, Integer pageSize) {
        ServiceResult<PageResult<CourseInfo>> res = courseService.courseSearch(homeId, keyword, pageNum, pageSize);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/update")
    @Operation(summary = "修改课程")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "name", in = ParameterIn.QUERY, required = true, description = "课程名称"), @Parameter(name = "description", in = ParameterIn.QUERY, required = true, description = "课程描述"), @Parameter(name = "startTime", in = ParameterIn.QUERY, required = true, description = "课程开始时间"), @Parameter(name = "endTime", in = ParameterIn.QUERY, required = true, description = "课程结束时间")})
    public ResponseWrapper<Void> courseUpdate(CourseInfo courseInfo) {
        ServiceResult<Void> res = courseService.courseUpdate(courseInfo);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/info/id")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    @Operation(summary = "查看课程信息")
    public ResponseWrapper<CourseInfo> courseInfo(Long courseId) {
        ServiceResult<CourseInfo> res = courseService.courseInfo(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/info/user")
    @Operation(summary = "查询用户课程信息")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> courseInfoByUserId(Long userId) {
        ServiceResult<?> res = courseService.courseInfoByUserId(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/info/home")
    @Operation(summary = "查询家庭课程信息")
    @Parameters({@Parameter(name = "homeId", in = ParameterIn.QUERY, required = true, description = "家庭ID")})
    public ResponseWrapper<?> courseInfoByHomeId(Long homeId) {
        ServiceResult<?> res = courseService.courseInfoByHomeId(homeId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/rank")
    @Operation(summary = "课程评分")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "rank", in = ParameterIn.QUERY, required = true, description = "评分")})
    public ResponseWrapper<?> rank(Long courseId, Double rank) {
        ServiceResult<?> res = courseService.rank(courseId, rank);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/add")
    @Operation(summary = "添加课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "comment", in = ParameterIn.QUERY, required = true, description = "评价")})
    public ResponseWrapper<?> commentAdd(Long courseId, Long userId, String comment) {
        ServiceResult<?> res = courseService.commentAdd(courseId, userId, comment);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/del")
    @Operation(summary = "删除课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> commentDel(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.commentDel(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/list")
    @Operation(summary = "列出课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> commentInfoList(Long courseId) {
        ServiceResult<?> res = courseService.commentInfoList(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/search")
    @Operation(summary = "搜索课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "keyword", in = ParameterIn.QUERY, required = true, description = "关键字")})
    public ResponseWrapper<?> commentInfoList(Long courseId, String keyword) {
        ServiceResult<?> res = courseService.commentInfoList(courseId, keyword);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/user")
    @Operation(summary = "查看用户给出的课程评价")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> commentInfoByUserId(Long userId) {
        ServiceResult<?> res = courseService.commentInfoByUserId(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

//    @PostMapping("/access/mod")
//    @Operation(summary = "课程权限修改")
//    public ResponseWrapper<?> modAccess() {
//                if (res.isSuccess()) {
//        return ResponseWrapper.data(res.getData());
//}else{
//        return ResponseWrapper.fail(res.getMessage());
//        }
//    }

    @PostMapping("/stu/add")
    @Operation(summary = "添加学生")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> addStudent(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.addStudent(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/stu/del")
    @Operation(summary = "删除学生")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> delStudent(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.delStudent(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/stu/list")
    @Operation(summary = "学生列表")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> listStudent(Long courseId) {
        ServiceResult<?> res = courseService.listStudent(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/teacher/add")
    @Operation(summary = "添加教师")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> addTeacher(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.addTeacher(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/teacher/del")
    @Operation(summary = "删除教师")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> delTeacher(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.delTeacher(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/teacher/list")
    @Operation(summary = "教师列表")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> listTeacher(Long courseId) {
        ServiceResult<?> res = courseService.listTeacher(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/list/create")
    @Parameters({@Parameter(name = "homeId", in = ParameterIn.QUERY, required = true, description = "家庭ID"), @Parameter(name = "title", in = ParameterIn.QUERY, required = true, description = "课程集合标题"), @Parameter(name = "description", in = ParameterIn.QUERY, required = true, description = "课程集合描述"), @Parameter(name = "open", in = ParameterIn.QUERY, required = true, description = "是否公开"), @Parameter(name = "courseIdList", in = ParameterIn.QUERY, required = true, description = "课程ID列表")})
    @Operation(summary = "创建课程集合")
    public ResponseWrapper<?> createList(Long homeId, String title, String description, boolean open, List<Long> courseIdList) {
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
    @Parameters({@Parameter(name = "courseList", in = ParameterIn.QUERY, required = true, description = "课程集合")})
    public ResponseWrapper<?> listUpdate(CourseList courseList) {
        ServiceResult<?> res = courseService.listUpdate(courseList);
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

    @PostMapping("/like/add")
    @Operation(summary = "点赞课程")
    public ResponseWrapper<?> likeAdd(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.addLikeCourse(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/like/del")
    @Operation(summary = "取消点赞课程")
    public ResponseWrapper<?> likeDel(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.delLikeCourse(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

}
