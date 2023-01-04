package com.amur.home.sba;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class HomeSbaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeSbaApplication.class, args);
    }

}
