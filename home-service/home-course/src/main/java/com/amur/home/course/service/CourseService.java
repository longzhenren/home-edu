package com.amur.home.course.service;

import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseList;
import com.amur.home.course.entity.CourseShare;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface CourseService {
    public Long createCourse(CourseInfo courseInfo);

    public boolean deleteCourse(Long courseId);

    public CourseInfo updateCourse(CourseInfo courseInfo);

    public Long createCourseList(CourseList courseList);

    public boolean deleteCourseList(Long listId);

    public CourseInfo updateCourseList(CourseList courseList);

    public boolean updateCourseAccess(Long courseId, Long userId, String access);

    public CourseInfo getCourseInfo(Long courseId);

    public boolean rankCourse(Long courseId, Long userId, Double score);

    public boolean updateComment(Long courseId, Long userId, String comment);

    public boolean createComment(Long courseId, Long userId, Double score, String comment);

    public boolean likeCourse(Long courseId, Long userId);

    public boolean favCourse(Long courseId, Long userId);

    public boolean joinCourseByShareToken(Long userId, String token);

    public String generateShareToken(Long courseId, Long userId, Date expireAt, String inviteAs);

    public CourseShare getShareInfo(String token);

    public boolean deleteShareToken(String token);

    public boolean hasJoined(Long courseId, Long userId);
}
