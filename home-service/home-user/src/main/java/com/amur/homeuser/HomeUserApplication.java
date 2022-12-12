package com.amur.homeuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.amur.homeuser.mapper")
public class HomeUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeUserApplication.class, args);
    }

}
