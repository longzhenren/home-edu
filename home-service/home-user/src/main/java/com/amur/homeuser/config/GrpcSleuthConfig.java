package com.amur.homeuser.config;

import brave.Tracing;
import brave.grpc.GrpcTracing;
import io.grpc.ClientInterceptor;
import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GlobalServerInterceptorConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

@Configuration
public class GrpcSleuthConfig {

    private static final Logger logger = LoggerFactory.getLogger(GrpcSleuthConfig.class);

    @Bean
    public GrpcTracing grpcTracing(Tracing tracing) {
        return GrpcTracing.create(tracing);
    }

    //grpc-spring-boot-starter provides @GrpcGlobalInterceptor to allow server-side interceptors to be registered with all
    //server stubs, we are just taking advantage of that to install the server-side gRPC tracer.
    @Bean
    ServerInterceptor grpcServerSleuthInterceptor(GrpcTracing grpcTracing) {
        return grpcTracing.newServerInterceptor();
    }

    //We also create a client-side interceptor and put that in the context, this interceptor can then be injected into gRPC clients and
    //then applied to the managed channel.
    @Bean
    ClientInterceptor grpcClientSleuthInterceptor(GrpcTracing grpcTracing) {
        return grpcTracing.newClientInterceptor();
    }

    // Use this for debugging (or if there is no Zipkin server running on port 9411)
    @Bean
    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
    public Reporter<Span> spanReporter() {
        return span -> logger.info("{}", span);
    }

    @Bean
    public GlobalServerInterceptorConfigurer globalInterceptorConfigurerAdapter(ServerInterceptor grpcServerSleuthInterceptor) {
        return registry -> registry.add(grpcServerSleuthInterceptor);
    }
}

