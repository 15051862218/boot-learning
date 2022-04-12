package boot.example.myappspringbootstartertest.controller;


import boot.example.myappspringbootautoconfigure.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 沈永康
 * @Date 2022/3/8 20:22
 * @Version 1.0
 */

@RestController
public class HelloController {
   @Autowired
   HelloService helloService;
    @GetMapping("/hello")
    public String sayHello(String name){

        return  helloService.sayHello(name);
    }
}
