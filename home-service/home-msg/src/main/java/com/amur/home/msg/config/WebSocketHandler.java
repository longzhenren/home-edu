package com.amur.home.msg.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    private static final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("连接成功：" + session.getId());
        sessions.put(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("收到消息：" + message.getPayload());
        // 解析消息并处理
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("连接关闭：" + session.getId());
        sessions.remove(session.getId());
    }

    public void sendMessage(String sessionId, String message) throws IOException {
        WebSocketSession session = sessions.get(sessionId);
        if (session != null) {
            session.sendMessage(new TextMessage(message));
        }
    }

    public void sendAllMessage(String message) throws IOException {
        for (WebSocketSession session : sessions.values()) {
            session.sendMessage(new TextMessage(message));
        }
    }
}
