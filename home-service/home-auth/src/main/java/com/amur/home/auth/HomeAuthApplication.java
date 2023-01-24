package com.amur.home.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
public class HomeAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeAuthApplication.class, args);
    }

}
