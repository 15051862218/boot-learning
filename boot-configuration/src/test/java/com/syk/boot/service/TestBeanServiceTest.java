package com.syk.boot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @Author 沈永康
 * @Date 2022/3/14 15:23
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TestBeanServiceTest {
    @Resource
    private ConfigurableApplicationContext ico;

    @Test
    void aaa(){
        TestBeanService testBeanService = (TestBeanService) ico.getBean("testBeanService");
        System.out.println(testBeanService.getName());
        System.out.println(testBeanService.getAge());
    }

}