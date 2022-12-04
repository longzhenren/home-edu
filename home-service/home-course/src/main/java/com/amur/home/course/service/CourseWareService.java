package com.amur.home.course.service;

import com.amur.home.course.entity.CourseWare;
import com.amur.home.util.ServiceResult;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CourseWareService {
    ServiceResult<String> upload(MultipartFile file) throws Exception;

    Resource download(String fileName) throws Exception;

    Resource preview(String fileName) throws Exception;

    ServiceResult<List<CourseWare>> courseWareList(Long courseId);

    ServiceResult<Void> courseWareAdd(Long courseId, String courseWareName, String courseWareUrl, String description);

    ServiceResult<Void> courseWareRename(String courseWareId, String courseWareName);

    ServiceResult<Void> courseWareReDesc(String courseWareId, String description);

    ServiceResult<Void> courseWareDel(String courseWareId);
}
