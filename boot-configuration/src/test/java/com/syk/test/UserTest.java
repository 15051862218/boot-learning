package com.syk.test;


import com.syk.boot.BootConfigApplication;
import com.syk.boot.model.Book;
import com.syk.boot.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/3/15 10:23
 * @Version 1.0
 */

@SpringBootTest(classes = BootConfigApplication.class)
@ExtendWith(SpringExtension.class)
public class UserTest {
    @Resource
    private User user;
    @Test
    void printUser(){
        System.out.println(user);
    }
}
