package com.amur.home.auth.config;

import com.amur.home.secure.registry.SecureRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecureRegistry secureRegistry() {
        return new SecureRegistry().excludePathPatterns("/login", "/token", "/actuator/**", "/swagger-ui.html", "/swagger-resources/**", "/v3/api-docs", "/webjars/**", "/doc.html");
    }

}
