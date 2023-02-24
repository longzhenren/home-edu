package com.amur.home.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
public class HomeScheduleApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomeScheduleApplication.class, args);
    }
}
