package com.amur.home.rtc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
public class HomeRtcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeRtcApplication.class, args);
    }

}
