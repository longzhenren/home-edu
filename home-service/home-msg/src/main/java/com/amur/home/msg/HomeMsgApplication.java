package com.amur.home.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
public class HomeMsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeMsgApplication.class, args);
    }

}
