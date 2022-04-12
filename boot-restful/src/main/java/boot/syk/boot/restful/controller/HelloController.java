package boot.syk.boot.restful.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 沈永康
 * @Date 2022/3/12 23:48
 * @Version 1.0
 */

@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping("world")
    public String getHelloWorld(){
        return "hello world";
    }
}
