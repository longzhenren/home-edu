package com.amur.home.course;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = {"com.amur.home"})
@MapperScan("com.amur.home.course.mapper")
@EnableAutoDataSourceProxy
@EnableAsync
@Slf4j
public class HomeCourseApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(HomeCourseApplication.class, args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" + "Local: \t\thttp://localhost:{}\n\t" + "Remote: \thttp://{}:{}\n" + "----------------------------------------------------------", env.getProperty("server.port"), InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));
    }

}
