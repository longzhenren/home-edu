package com.amur.home.course.service;

import org.springframework.stereotype.Service;

@Service
public interface CourseWareService {
    public boolean createCourseWare();

    public boolean deleteCourseWare();

    public boolean updateCourseWare();
}
