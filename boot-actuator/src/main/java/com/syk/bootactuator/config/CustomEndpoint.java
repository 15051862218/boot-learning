package com.syk.bootactuator.config;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/4/15 9:20
 * @Version 1.0
 */
@Configuration
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {
  @ReadOperation
    public  ShopData getData(){
      return new ShopData("zhangsan ","江苏南极");
  }

      @Data
      @AllArgsConstructor
    public static class ShopData{
      private String name;
      private String address;
  }
}
