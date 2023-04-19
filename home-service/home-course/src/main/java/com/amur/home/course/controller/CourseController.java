package com.amur.home.course.controller;

import com.amur.home.course.dto.UserCourseInterDTO;
import com.amur.home.course.entity.CourseInfo;
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
public class CourseController {
    @Resource
    private CourseService courseService;

    @Resource
    private CourseFavService courseFavService;

    @PostMapping("/add")
    @Operation(summary = "添加课程")
    @Parameters({@Parameter(name = "homeId", in = ParameterIn.QUERY, required = true, description = "家庭ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "name", in = ParameterIn.QUERY, required = true, description = "课程名称"), @Parameter(name = "description", in = ParameterIn.QUERY, required = true, description = "课程描述"), @Parameter(name = "startTime", in = ParameterIn.QUERY, required = true, description = "课程开始时间"), @Parameter(name = "endTime", in = ParameterIn.QUERY, required = true, description = "课程结束时间"), @Parameter(name = "coverUrl", in = ParameterIn.QUERY, required = true, description = "课程封面"), @Parameter(name = "open", in = ParameterIn.QUERY, required = true, description = "是否对外开放")})
    public ResponseWrapper<Long> courseAdd(Long homeId, Long userId, String name, String description, Date startTime, Date endTime, String coverUrl, Boolean open) {
        ServiceResult<Long> res = courseService.courseAdd(homeId, userId, name, description, startTime, endTime, coverUrl, open);
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
    @Parameters({
            @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"),
            @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")
    })
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
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "name", in = ParameterIn.QUERY, required = false, description = "课程名称"), @Parameter(name = "description", in = ParameterIn.QUERY, required = false, description = "课程描述"), @Parameter(name = "startTime", in = ParameterIn.QUERY, required = false, description = "课程开始时间"), @Parameter(name = "endTime", in = ParameterIn.QUERY, required = false, description = "课程结束时间"), @Parameter(name = "coverUrl", in = ParameterIn.QUERY, required = false, description = "封面链接"), @Parameter(name = "status", in = ParameterIn.QUERY, required = false, description = "课程状态(没想好 暂时存啥都行)"), @Parameter(name = "open", in = ParameterIn.QUERY, required = false, description = "是否对外开放")})
    public ResponseWrapper<Void> courseUpdate(Long courseId, String name, String description, String coverUrl, String status, Date startTime, Date endTime, Boolean open) {
        ServiceResult<Void> res = courseService.courseUpdate(courseId, name, description, coverUrl, status, startTime, endTime, open);
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
    public ResponseWrapper<Set<Long>> listStudent(Long courseId) {
        ServiceResult<Set<Long>> res = courseService.listStudent(courseId);
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

    @GetMapping("/user/int")
    @Operation(summary = "查看用户课程关系")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<UserCourseInterDTO> userCourseRelation(Long userId, Long courseId) {
        ServiceResult<UserCourseInterDTO> res = courseService.userCourseRelation(userId, courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/score/add")
    @Operation(summary = "添加或更新课程评分")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "score", in = ParameterIn.QUERY, required = true, description = "评分")})
    public ResponseWrapper<?> scoreAdd(Long userId, Long courseId, Double score) {
        ServiceResult<?> res = courseService.addCourseScore(userId, courseId, score);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/score/del")
    @Operation(summary = "删除课程评分")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> scoreAdd(Long userId, Long courseId) {
        ServiceResult<?> res = courseService.delCourseScore(userId, courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/now")
    @Operation(summary = "获取当前课程")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<List<CourseInfo>> getNowCourse(Long userId) {
        ServiceResult<List<CourseInfo>> res = courseService.getNowCourse(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

}
