package com.example.myappspringbootautoconfigure;


/**
 * @Author 沈永康
 * @Date 2022/3/8 19:59
 * @Version 1.0
 */


public class HelloService {
    HelloProperties helloProperties;
    public String sayHello(String name){
        return "Hello" + name+","+helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties(){
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
