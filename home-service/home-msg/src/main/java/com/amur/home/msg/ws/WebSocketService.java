package com.amur.home.msg.ws;

import com.amur.home.msg.mq.RabbitMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import static com.amur.home.msg.config.RabbitMQConfig.DIRECT_QUEUE;

@Slf4j
@ServerEndpoint("/ws/{sid}")
@RabbitListener(queues = DIRECT_QUEUE)
public class WebSocketService {
    public static CopyOnWriteArraySet<WebSocketService> webSockets = new CopyOnWriteArraySet<WebSocketService>();

    @Resource
    private RabbitMQService rabbitMQService;

    @OnOpen
    public void onOpen() throws InterruptedException, IOException {
        webSockets.add(this);
        System.out.println("有新用户加入");
    }

    @OnClose
    public void onClose() throws IOException {
        webSockets.remove(this);
        System.out.println("有用户离开");
    }

    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String msg) throws InterruptedException {
        System.out.println("从客户端接受的消息： " + msg);
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

}
