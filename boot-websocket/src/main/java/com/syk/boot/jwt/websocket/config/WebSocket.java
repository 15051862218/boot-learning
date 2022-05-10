package com.syk.boot.jwt.websocket.config;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author 沈永康
 * @Date 2022/4/18 10:28
 * @Version 1.0
 */

@ServerEndpoint(value = "/websocket")
@Component
@Slf4j
@Data
public class WebSocket {
    /**
     * 静态变量
     */
    private static int onlineCount = 0;
    /**
     *concurrent包中的线程安全的SET，用来
     */
    private static CopyOnWriteArraySet<WebSocket> websocket = new CopyOnWriteArraySet<>();
    /**
     *
     */
    private Session session;
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        websocket.add(this);
        addOnlineCount();
        // TODO: 2022.4.18
        log.info("新链接加入，当前人数：" + getOnlineCount());
        try{
            sendMessage("成功");
        }catch (IOException e){
            log.error(e.getMessage());
        }
    }
    @OnClose
    public void onClose(){
        websocket.remove(this);
        subOnlineCount();
        log.info("连接关闭" + getOnlineCount());
    }
    @OnMessage
    public void onMessage(String message ,Session session) throws  IOException {
        String queryString = session.getQueryString();
        log.info(queryString);
        String nickname = queryString.split("=")[1];
        log.info(message);
        broadcastInfo(nickname + "说：" + message);
    }
    @OnError
    public void onError(Throwable error) {
        log.error("发送粗我，{}",error.getMessage());
        error.printStackTrace();
    }
    public static void broadcastInfo(String message) throws IOException{
        for (WebSocket item : websocket) {
            try {
                item.sendMessage(message);
            }catch (IOException e){
                log.error(e.getMessage());
            }

        }
    }

     public void sendMessage(String message ) throws IOException {
        this.session.getBasicRemote().sendText(message);
     }
    public static  synchronized void addOnlineCount(){
      WebSocket.onlineCount++;
    }

    public static  synchronized void subOnlineCount(){
       WebSocket.onlineCount--;
    }
    public static  synchronized int getOnlineCount(){
        return onlineCount;
    }

}
