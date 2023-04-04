package com.amur.home.course.service.impl;

import com.amur.home.course.entity.CourseInfo;
import com.amur.home.course.entity.CourseWare;
import com.amur.home.course.mapper.CourseInfoMapper;
import com.amur.home.course.mapper.CourseWareMapper;
import com.amur.home.course.service.CourseWareService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.minio.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class CourseWareServiceImpl implements CourseWareService {
    private final String bucketName = "courseware";
    @Autowired
    private MinioClient minioClient;
    @Autowired
    private CourseWareMapper courseWareMapper;

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Override
    public ServiceResult<String> upload(MultipartFile file) throws Exception {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileExtension;

        try {
            InputStream inputStream = file.getInputStream();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!isExist) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(newFileName).stream(inputStream, inputStream.available(), -1).contentType(file.getContentType()).build());
        } catch (Exception e) {
            return ServiceResult.ex("保存失败");
        }
        String fileUrl = "/" + bucketName + "/" + newFileName;
        return ServiceResult.success(fileUrl);
    }

    @Override
    public Resource download(String fileName) throws Exception {
        InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(fileName).build());
        return new InputStreamResource(inputStream);
    }

    @Override
    public Resource preview(String fileName) throws Exception {
        String contentType = minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(fileName).build()).contentType();
        InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(fileName).build());
        return new ByteArrayResource(IOUtils.toByteArray(inputStream));
    }

    @Override
    public ServiceResult<List<CourseWare>> courseWareList(Long courseId) {
        QueryWrapper<CourseWare> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", courseId);
        List<CourseWare> courseWares = courseWareMapper.selectList(queryWrapper);
        if (courseWares.size() < 1) {
            return ServiceResult.success("没有课件");
        }
        return ServiceResult.success(courseWares);
    }

    @Override
    public ServiceResult<Void> courseWareAdd(Long courseId, String fileName, String courseWareUrl, String description) {
        CourseInfo courseInfo = courseInfoMapper.selectById(courseId);
        if (courseInfo == null) {
            return ServiceResult.ex("课程不存在");
        }
        CourseWare courseWare = new CourseWare(courseId, fileName, description, courseWareUrl);
        if (courseWareMapper.insert(courseWare) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("添加课件失败");
        }
    }

    /**
     * @param courseWareId
     * @param courseWareName
     * @return
     */
    @Override
    public ServiceResult<Void> courseWareRename(String courseWareId, String courseWareName) {
        CourseWare courseWare = courseWareMapper.selectById(courseWareId);
        if (courseWare == null) {
            return ServiceResult.ex("课件不存在");
        }
        courseWare.setFileName(courseWareName);
        if (courseWareMapper.updateById(courseWare) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("课件信息更新失败");
        }
    }

    /**
     * @param courseWareId
     * @param description
     * @return
     */
    @Override
    public ServiceResult<Void> courseWareReDesc(String courseWareId, String description) {
        CourseWare courseWare = courseWareMapper.selectById(courseWareId);
        if (courseWare == null) {
            return ServiceResult.ex("课件不存在");
        }
        courseWare.setDescription(description);
        if (courseWareMapper.updateById(courseWare) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("课件信息更新失败");
        }
    }

    /**
     * @param courseWareId
     * @return
     */
    @Override
    public ServiceResult<Void> courseWareDel(String courseWareId) {
        CourseWare courseWare = courseWareMapper.selectById(courseWareId);
        if (courseWare == null) {
            return ServiceResult.ex("课件不存在");
        }
        if (courseWareMapper.deleteById(courseWare) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.ex("课件删除失败");
        }
    }
}
