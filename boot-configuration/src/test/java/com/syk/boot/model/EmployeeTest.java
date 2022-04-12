package com.syk.boot.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @Author 沈永康
 * @Date 2022/3/14 15:47
 * @Version 1.0
 */
@Slf4j
@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
    @SpringBootTest
class EmployeeTest {
    @Resource
    private Employee employee;

    @Test
    void valueBind() throws  Exception{
        log.info(String.valueOf(employee));
        Map <String, Integer> map =employee.getEmployeeAge();
        map.forEach((key,value)-> System.out.println(key + "->" +value));
    }

}