package com.amur.home.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
public class HomeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeUserApplication.class, args);
    }

}
