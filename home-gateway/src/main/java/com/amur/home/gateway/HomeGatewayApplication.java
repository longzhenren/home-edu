package com.amur.home.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.amur.home"}, exclude = DataSourceAutoConfiguration.class)
//@SpringBootApplication
public class HomeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeGatewayApplication.class, args);
    }

}
