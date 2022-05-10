package com.syk.boot.jwt.websocket.controller;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 沈永康
 * @Date 2022/4/18 17:09
 * @Version 1.0
 */

@Controller
@Slf4j
public class DemoController {
   @RequestMapping(value = "/server/info",method = {RequestMethod.GET} ,produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter pushMsg() {
       final  SseEmitter emitter = new SseEmitter(0L);
       log.info("emitter push message .....");
       List<String> list =new ArrayList<>();
       list.add("aaa");
       list.add("bbb");
       list.add("ccc");
       try {
           emitter.send( JSONObject.toJSONString(list), MediaType.TEXT_EVENT_STREAM);
           System.out.println(JSONObject.toJSONString(list));
       }catch (IOException e ) {
           e.printStackTrace();
       }
       return emitter;
   }
}
