package com.syk.boot.jwt.websocket.model;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 沈永康
 * @Date 2022/4/18 14:23
 * @Version 1.0
 */

@ServerEndpoint(value = "/socket/{id}")
@Component
@Slf4j
public class WebSocketServer {
    private static int onlineCount = 0;

    public static ConcurrentHashMap<Integer,WebSocketServer> webSocketSet = new ConcurrentHashMap<>();

    private Session session;
    private Integer id = 0;

    @OnOpen
    public void onOpen(@PathParam(value = "id") Integer param ,Session session){
        this.id = param;
        this.session = session;
        webSocketSet.put(param,this);
        addOnlineCount();
        log.info("有新连接加入！当前在线人数为"+ getOnlineCount());
        try{
            sendMessage("连接已建立--");
        }catch (IOException e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息：" + message);
        try {
            this.sendMessage(message);
        }catch (IOException e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
    @OnError
    public  void onError(Session session,Throwable error){
        log.info("发生错误");
        error.printStackTrace();
    }
    public void sendMessage(String message) throws  IOException{
        getSession().getBasicRemote().sendText(message);
    }
    @OnClose
    public void onClose() {
        if (id != null && id !=0){
            webSocketSet.remove(id);
            subOnlineCount();
            log.info("有一连接关闭，当前在线人数为" + getOnlineCount());
        }
    }
    public void sendToMessageById(Integer id, String message){
        try {
            if(webSocketSet.get(id) != null) {
                webSocketSet.get(id).sendMessage(message);
            }else {
                log.info("webSocketSet中没有此key,不推送消息");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void sendInfo(String message) throws  IOException {
        for (WebSocketServer item : webSocketSet.values()){
            try {
                item.sendMessage(message);
            }catch (IOException e){
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

   public Session getSession(){
        return session;
   }
    public static  synchronized void addOnlineCount(){
        WebSocketServer.onlineCount++;
    }

    public static  synchronized void subOnlineCount(){
        WebSocketServer.onlineCount--;
    }
    public static  synchronized int getOnlineCount(){
        return onlineCount;
    }

}
