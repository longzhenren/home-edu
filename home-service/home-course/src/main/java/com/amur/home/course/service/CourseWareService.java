package com.amur.home.course.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface CourseWareService {
    String upload(MultipartFile file) throws Exception;

    Resource download(String fileName) throws Exception;

    Resource preview(String fileName) throws Exception;
}
