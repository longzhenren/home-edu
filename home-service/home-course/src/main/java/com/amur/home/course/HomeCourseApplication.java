package com.amur.home.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
@MapperScan("com.amur.home.course.mapper")
@EnableAsync
public class HomeCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeCourseApplication.class, args);
    }

}
