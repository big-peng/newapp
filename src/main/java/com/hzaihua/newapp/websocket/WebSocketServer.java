package com.hzaihua.newapp.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
@Component
public class WebSocketServer {
    private static Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        System.out.println(session);
        this.session = session;
        System.out.println("连接成功");
        sendMessage("连接成功111");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("接收到消息："+message);
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) {
        try {
            System.out.println(this.session);
            System.out.println(message);
            this.session.getBasicRemote().sendText(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
