package com.amur.home.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
public class HomeCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeCourseApplication.class, args);
    }

}
