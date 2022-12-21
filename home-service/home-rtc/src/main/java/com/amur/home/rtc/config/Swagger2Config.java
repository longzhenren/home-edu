package com.amur.home.rtc.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger API相关配置
 */
@Configuration
@EnableSwagger2WebMvc
@EnableKnife4j
public class Swagger2Config {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("实时音视频")
                        .description("远程家教系统实时音视频微服务")
                        .version("1.0")
                        .contact(new Contact("longzhenren", "", "hljzhangzhibo@126.com")
                        ).build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.amur.home.rtc.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}