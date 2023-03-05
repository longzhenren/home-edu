package com.amur.home.msg.config;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableWebSocket
@Slf4j
public class WebSocketConfig implements WebSocketConfigurer {

    private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebSocketHandler(), "/my-websocket").addInterceptors(new WebSocketHandshakeInterceptor());
    }

    private class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
        @Override
        public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//            if (StpUtil.isLogin()) {
//                log.info("用户{}请求建立ws链接", StpUtil.getLoginIdDefaultNull());
//                return true;
//            } else {
//                log.info("未登录用户,禁止建立ws链接");
//                return false;
//            }
            return true;
        }

        @Override
        public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

        }
    }

    private class MyWebSocketHandler extends TextWebSocketHandler {

        @Override
        public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            // 处理来自客户端的WebSocket消息
        }

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            session.sendMessage(new TextMessage("欢迎连接WebSocket服务！"));
            // 将WebSocketSession与对应的用户关联起来
            String username = extractUsername(session);
            userSessions.put(username, session);
        }

        private String extractUsername(WebSocketSession session) {
            // 从WebSocketSession中提取用户名，可以根据实际情况进行实现
            return session.getId();
        }
    }
}
