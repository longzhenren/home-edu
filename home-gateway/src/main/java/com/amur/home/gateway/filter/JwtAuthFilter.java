package com.amur.home.gateway.filter;

import com.amur.home.auth.entity.AuthEntity;
import com.amur.home.util.JsonUtils;
import com.amur.home.util.RedisUtils;
import com.amur.home.util.ResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.CachedBodyOutputMessage;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest.Builder;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class JwtAuthFilter implements GlobalFilter, Ordered {
    @Resource
    private RedisUtils redisUtils;

    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        String url = uri.getPath();

        //忽略以下url请求
        if (url.contains("/home-auth/")) {
            return chain.filter(exchange);
        }

        //从请求头中取得token
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (!StringUtils.hasLength(token)) {
            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            ResponseWrapper<?> responseWrapper = ResponseWrapper.fail(401, "UnAuthorized");
            byte[] responseByte = Objects.requireNonNull(JsonUtils.toJsonString(responseWrapper)).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(responseByte);
            return response.writeWith(Flux.just(buffer));
        }

        //请求中的token是否在redis中存在
//        boolean verifyResult = jwtUtils.verify(token);
        AuthEntity authEntity = (AuthEntity) redisUtils.get("token:" + token);
        if (authEntity == null) {
            ServerHttpResponse httpResponse = exchange.getResponse();
//            httpResponse.setStatusCode(HttpStatus.FORBIDDEN);
            httpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            ResponseWrapper<?> response = ResponseWrapper.fail(1004, "Token Invalid");
            byte[] responseByte = Objects.requireNonNull(JsonUtils.toJsonString(response)).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = httpResponse.bufferFactory().wrap(responseByte);
            return httpResponse.writeWith(Flux.just(buffer));
        }

        Builder builder = request.mutate();
        if (request.getMethod() == HttpMethod.GET) {
            // get请求 处理参数
            return addParameterForGetMethod(exchange, chain, uri, authEntity, builder);
        }

        if (request.getMethod() == HttpMethod.POST) {
            // post请求 处理参数
            MediaType contentType = request.getHeaders().getContentType();
            if (MediaType.APPLICATION_JSON.equals(contentType)) {
                // 请求内容为 application json
                return addParameterForPostMethod(exchange, chain, authEntity);
            }

            if (MediaType.MULTIPART_FORM_DATA.isCompatibleWith(contentType)) {
                // 请求内容为 form data
                return addParameterForFormData(exchange, chain, authEntity, builder);
            }

        }

        if (request.getMethod() == HttpMethod.PUT) {
            // put请求 处理参数
            // 走 post 请求流程
            return addParameterForPostMethod(exchange, chain, authEntity);
        }

        if (request.getMethod() == HttpMethod.DELETE) {
            // delete请求 处理参数
            // 走 get 请求流程
            return addParameterForGetMethod(exchange, chain, uri, authEntity, builder);
        }

        return chain.filter(exchange);
    }

    /**
     * get请求，添加参数
     *
     * @param exchange
     * @param chain
     * @param uri
     * @param authEntity
     * @param builder
     * @return
     */
    private Mono<Void> addParameterForGetMethod(ServerWebExchange exchange, GatewayFilterChain chain, URI uri, AuthEntity authEntity, ServerHttpRequest.Builder builder) {
        StringBuilder query = new StringBuilder();

        String originalQuery = uri.getQuery();
        if (StringUtils.hasText(originalQuery)) {
            query.append(originalQuery);
            if (originalQuery.charAt(originalQuery.length() - 1) != '&') {
                query.append('&');
            }
        }

        query.append("userId").append("=").append(authEntity.getUserId()).append("&").append("userName").append("=").append(authEntity.getUserName());

        try {
            URI newUri = UriComponentsBuilder.fromUri(uri).replaceQuery(query.toString()).build().encode().toUri();
            ServerHttpRequest request = exchange.getRequest().mutate().uri(newUri).build();
            return chain.filter(exchange.mutate().request(request).build());
        } catch (Exception e) {
            log.error("Invalid URI query: " + query, e);
            // 当前过滤器filter执行结束
            return chain.filter(exchange.mutate().request(builder.build()).build());
        }
    }

    /**
     * post请求，添加参数
     *
     * @param exchange
     * @param chain
     * @param authEntity
     * @return
     */
    private Mono<Void> addParameterForPostMethod(ServerWebExchange exchange, GatewayFilterChain chain, AuthEntity authEntity) {
        ServerRequest serverRequest = ServerRequest.create(exchange, Collections.emptyList());
        Mono<String> modifiedBody = serverRequest.bodyToMono(String.class).flatMap((o) -> {
            if (o.startsWith("[")) {
                // body内容为数组，直接返回
                return Mono.just(o);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map map = objectMapper.readValue(o, Map.class);

                map.put("user", authEntity);
//                map.put("userName", authEntity.getUserName());

                String json = objectMapper.writeValueAsString(map);
                log.info("addParameterForPostMethod -> json = {}", json);
                return Mono.just(json);
            } catch (Exception e) {
                e.printStackTrace();
                return Mono.just(o);
            }
        });

        BodyInserter<Mono<String>, ReactiveHttpOutputMessage> bodyInserter = BodyInserters.fromPublisher(modifiedBody, String.class);
        CachedBodyOutputMessage outputMessage = new CachedBodyOutputMessage(exchange, exchange.getRequest().getHeaders());
        return bodyInserter.insert(outputMessage, new BodyInserterContext()).then(Mono.defer(() -> {
            ServerHttpRequestDecorator decorator = new ServerHttpRequestDecorator(exchange.getRequest()) {
                public HttpHeaders getHeaders() {
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.putAll(super.getHeaders());
                    httpHeaders.set("Transfer-Encoding", "chunked");
                    return httpHeaders;
                }

                public Flux<DataBuffer> getBody() {
                    return outputMessage.getBody();
                }
            };
            return chain.filter(exchange.mutate().request(decorator).build());
        }));
    }

    /**
     * post请求，form data 添加参数
     *
     * @param exchange
     * @param chain
     * @param authEntity
     * @param builder
     * @return
     */
    private Mono<Void> addParameterForFormData(ServerWebExchange exchange, GatewayFilterChain chain, AuthEntity authEntity, ServerHttpRequest.Builder builder) {
        builder.header("user", JsonUtils.toJsonString(authEntity));
        ServerHttpRequest serverHttpRequest = builder.build();
        return chain.filter(exchange.mutate().request(serverHttpRequest).build());
    }

    /**
     * 返回消息
     *
     * @param exchange
     * @param data
     * @return
     */
    private Mono<Void> illegalResponse(ServerWebExchange exchange, String data) {
        ServerHttpResponse originalResponse = exchange.getResponse();
        originalResponse.setStatusCode(HttpStatus.OK);
        originalResponse.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        byte[] response = data.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = originalResponse.bufferFactory().wrap(response);
        return originalResponse.writeWith(Flux.just(buffer));
    }
}