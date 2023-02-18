package com.amur.home.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
@MapperScan("com.amur.home.course.mapper")
public class HomeCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeCourseApplication.class, args);
    }

}
