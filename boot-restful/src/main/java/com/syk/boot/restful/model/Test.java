package com.syk.boot.restful.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Reader;
import java.io.StringReader;

/**
 * @Author 沈永康
 * @Date 2022/3/10 19:47
 * @Version 1.0
 */


public class Test {
    public static void main(String[] args) throws JsonProcessingException {
      Article a =new Article();
        ObjectMapper m=new ObjectMapper();
        String js=m.writeValueAsString(a);
        System.out.println(js);
        Article a2=m.readValue(js,Article.class);
        System.out.println(a2);
    }
}
