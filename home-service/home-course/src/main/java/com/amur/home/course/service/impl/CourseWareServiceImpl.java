package com.amur.home.course.service.impl;

import com.amur.home.course.entity.CourseWare;
import com.amur.home.course.mapper.CourseWareMapper;
import com.amur.home.course.service.CourseWareService;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.StatObjectArgs;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

@Service
public class CourseWareServiceImpl implements CourseWareService {
    @Autowired
    private MinioClient minioClient;

    @Autowired
    private CourseWareMapper courseWareMapper;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Override
    public String upload(MultipartFile file) throws Exception {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + fileExtension;

        InputStream inputStream = file.getInputStream();
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(newFileName).stream(inputStream, inputStream.available(), -1).build());
        String fileUrl = endpoint + "/" + bucketName + "/" + newFileName;

        CourseWare courseWare = new CourseWare();
        courseWare.setId(uuid);
        courseWare.setFileName(originalFileName);
        courseWare.setFileUrl(fileUrl);
        courseWareMapper.insert(courseWare);
        return fileUrl;
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
}
