package com.syk.boot.jwt.cache;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author 沈永康
 * @Date 2022/4/17 22:45
 * @Version 1.0
 */

@SpringBootApplication
@EnableCaching
public class CacheApplication {
    public static void main(String[] args){
        SpringApplication.run(CacheApplication.class,args);
    }
}
