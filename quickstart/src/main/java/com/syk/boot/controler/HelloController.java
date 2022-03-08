package com.syk.boot.controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 沈永康
 * @Date 2022/3/7 15:16
 * @Version 1.0
 */

@RestController
@RequestMapping("")
public class HelloController {

    @GetMapping("/hello")
    public  String  hello(){
        return "hello world";
    }
}
