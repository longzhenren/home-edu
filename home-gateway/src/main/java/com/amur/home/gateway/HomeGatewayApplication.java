package com.amur.home.gateway;

import com.amur.home.gateway.filter.RemoteAddressKeyResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(scanBasePackages = {"com.amur.home"}, exclude = DataSourceAutoConfiguration.class)
@Slf4j
public class HomeGatewayApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(HomeGatewayApplication.class, args);
        Environment env = application.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "Remote: \thttp://{}:{}\n" +
                        "----------------------------------------------------------",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    @Bean
    public RemoteAddressKeyResolver remoteAddressKeyResolver() {
        return new RemoteAddressKeyResolver();
    }
}
