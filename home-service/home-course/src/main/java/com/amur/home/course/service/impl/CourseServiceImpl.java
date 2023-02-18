package com.amur.home.course.service.impl;

import com.amur.home.common.Constants;
import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.entity.CourseShare;
import com.amur.home.course.mapper.CourseCommentMapper;
import com.amur.home.course.mapper.CourseInfoMapper;
import com.amur.home.course.mapper.CourseListMapper;
import com.amur.home.course.mapper.CourseShareMapper;
import com.amur.home.course.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseInfoMapper courseInfoMapper;

    @Resource
    private CourseListMapper courseListMapper;

    @Resource
    private CourseCommentMapper courseCommentMapper;
    @Resource
    private CourseShareMapper courseShareMapper;

    /**
     * @param courseInfo
     * @return
     */
    @Override
    public Long createCourse(CourseInfo courseInfo) {
        courseInfoMapper.insert(courseInfo);
        return courseInfo.getId();
    }

    /**
     * @param courseId
     * @return
     */
    @Override
    public boolean deleteCourse(Long courseId) {
        return courseInfoMapper.deleteById(courseId) > 0;
    }

    /**
     * @param courseInfo
     * @return
     */
    @Override
    public CourseInfo updateCourse(CourseInfo courseInfo) {
        courseInfoMapper.updateById(courseInfo);
        return courseInfo;
    }

    /**
     * @param courseList
     * @return
     */
    @Override
    public Long createCourseList(CourseList courseList) {
        courseListMapper.insert(courseList);
        return courseList.getId();
    }

    /**
     * @param listId
     * @return
     */
    @Override
    public boolean deleteCourseList(Long listId) {
        return courseListMapper.deleteById(listId) > 0;
    }

    /**
     * @param courseList
     * @return
     */
    @Override
    public CourseInfo updateCourseList(CourseList courseList) {
        courseListMapper.updateById(courseList);
        return null;
    }

    /**
     * @param courseId
     * @param userId
     * @param access
     * @return
     */
    @Override
    public boolean updateCourseAccess(Long courseId, Long userId, String access) {
        return false;
    }

    /**
     * @param courseId
     * @return
     */
    @Override
    public CourseInfo getCourseInfo(Long courseId) {
        return courseInfoMapper.selectById(courseId);
    }

    /**
     * @param courseId
     * @param userId
     * @param score
     * @return
     */
    @Override
    public boolean rankCourse(Long courseId, Long userId, Double score) {
//        if (score < 0 || score > 5) {
//            return false;
//        }
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return false;
        }

        courseInfo.setScore((courseInfo.getScore() * courseInfo.getScore() + score) / (courseInfo.getScore() + 1));
        courseInfo.setScoreCount(courseInfo.getScoreCount() + 1);
        return courseInfoMapper.updateById(courseInfo) > 0;
    }

    /**
     * @param courseId
     * @param userId
     * @param score
     * @return
     */
    @Override
    public boolean createComment(Long courseId, Long userId, Double score, String comment) {
//        if (score < 0 || score > 5) {
//            return false;
//        }
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return false;
        }
        return false;
    }

    /**
     * @param courseId
     * @param userId
     * @param comment
     * @return
     */
    @Override
    public boolean updateComment(Long courseId, Long userId, String comment) {
        return false;
    }

    /**
     * @param courseId
     * @param userId
     * @return
     */
    @Override
    public boolean likeCourse(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return false;
        }
        courseInfo.setLikeCount(courseInfo.getLikeCount() + 1);
        return courseInfoMapper.updateById(courseInfo) > 0;
    }

    /**
     * @param courseId
     * @param userId
     * @return
     */
    @Override
    public boolean favCourse(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return false;
        }
        courseInfo.setFavCount(courseInfo.getFavCount() + 1);

        return courseInfoMapper.updateById(courseInfo) > 0;
    }

    /**
     * @param userId
     * @param token
     * @return
     */
    @Override
    public boolean joinCourseByShareToken(Long userId, String token) {
        CourseShare courseShare = courseShareMapper.selectById(token);
        if (courseShare == null) {
            return false;
        }
        if (courseShare.getExpireTime().getTime() < new Date().getTime()) {
            return false;
        }
        CourseInfo courseInfo = courseInfoMapper.selectById(courseShare.getCourseId());
        if (courseInfo == null) {
            return false;
        }
        if (courseShare.getInviteAs() == Constants.InviteAs.AS_TEACHER) courseInfo.getTeacherIds().add(userId);
        else if (courseShare.getInviteAs() == Constants.InviteAs.AS_STUDENT) courseInfo.getStudentIds().add(userId);
        return courseInfoMapper.updateById(courseInfo) > 0;
    }

    /**
     * @param courseId
     * @param userId
     * @return
     */
    @Override
    public String generateShareToken(Long courseId, Long userId, Date expireAt, Constants.InviteAs inviteAs) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return null;
        }
        CourseShare courseShare = new CourseShare();
        courseShare.setCourseId(courseId);
        if (expireAt == null) {
            expireAt = new Date();
            expireAt.setTime(expireAt.getTime() + 1000 * 60 * 60 * 24 * 7);
        }
        courseShare.setExpireTime(expireAt);
        courseShare.setInviterId(userId);
        courseShare.setInviteAs(inviteAs);
        courseShareMapper.insert(courseShare);
        return courseShare.getToken();
    }

    /**
     * @param token
     * @return
     */
    @Override
    public CourseShare getShareInfo(String token) {
        return courseShareMapper.selectById(token);
    }

    /**
     * @param token
     * @return
     */
    @Override
    public boolean deleteShareToken(String token) {
        return courseShareMapper.deleteById(token) > 0;
    }

    /**
     * @param courseId
     * @param userId
     * @return
     */
    @Override
    public boolean hasJoined(Long courseId, Long userId) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return false;
        }
        return courseInfoMapper.selectCount(new QueryWrapper<CourseInfo>().eq("course_id", courseId).eq("user_id", userId)) > 0;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<CourseShare> listShareInfoByUserId(Long userId) {
        return courseShareMapper.selectList(new QueryWrapper<CourseShare>().eq("inviter_id", userId));
    }

    /**
     * @param token
     * @param userId
     * @return
     */
    @Override
    public boolean cancelShareToken(String token, Long userId) {
        if (courseShareMapper.selectCount(new QueryWrapper<CourseShare>().eq("token", token).eq("inviter_id", userId)) > 0) {
            return false;
        }
        return courseShareMapper.deleteById(token) > 0;
    }
}
