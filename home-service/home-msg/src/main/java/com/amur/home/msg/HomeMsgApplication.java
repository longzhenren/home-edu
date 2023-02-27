package com.amur.home.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
@EnableAsync
@EnableScheduling
public class HomeMsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeMsgApplication.class, args);
    }

}
