package com.syk.bootactuator.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 沈永康
 * @Date 2022/4/15 9:59
 * @Version 1.0
 */

@RestController
public class HelloController {
    @GetMapping("hello")
    public  String getHello(){
        return  "hello word";
    }
}
