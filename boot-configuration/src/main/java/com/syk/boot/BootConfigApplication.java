package com.syk.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author 沈永康
 * @Date 2022/3/14 12:51
 * @Version 1.0
 */

@SpringBootApplication
//@ImportResource(locations = {"classpath:bean.xml"})
public class BootConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootConfigApplication.class);
    }
}
