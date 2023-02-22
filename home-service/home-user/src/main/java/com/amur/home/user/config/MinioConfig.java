package com.amur.home.user.config;

import io.minio.MinioClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(MinioPropertiesConfig.class)
public class MinioConfig {

    @Resource
    private MinioPropertiesConfig minioPropertiesConfig;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(minioPropertiesConfig.getEndpoint()).credentials(minioPropertiesConfig.getAccessKey(), minioPropertiesConfig.getSecretKey()).build();
    }
}