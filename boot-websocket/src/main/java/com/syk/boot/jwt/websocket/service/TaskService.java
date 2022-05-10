package com.syk.boot.jwt.websocket.service;


import boot.syk.boot.restful.common.AjaxResponse;
import com.syk.boot.jwt.websocket.model.WebSocketServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/4/18 14:46
 * @Version 1.0
 */

@Service
public class TaskService {
    @Resource
    private WebSocketServer webSocketServer;

//    @Scheduled(cron = "0/10 * * * * ?")
    private void realTimeAlarm() {
        webSocketServer.sendToMessageById(1,"下午好！");
        AjaxResponse.success();
    }

//    @Scheduled(cron = "0/5 * * * * ? ")
    private void realTimeAlarm2() {
        webSocketServer.sendToMessageById(1,"下午一点啦！");
    }
//    @Scheduled(cron = "0 0 18 ? ? ? ")
//    private void sendNotice() {
//        webSocketServer.sendToMessageById(1,"下午18点啦，该吃饭了，这是定时推送消息");
//        AjaxResponse.success();
//    }
//    @Scheduled(cron = "0 0 14 ? ? ? ")
//    private void sendNames() {
//        webSocketServer.sendToMessageById(1,"这是排行数据");
//        AjaxResponse.success();
//    }
}
