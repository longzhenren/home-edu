package com.amur.homeclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
public class HomeClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeClassApplication.class, args);
    }

}
