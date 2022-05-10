package com.syk.test;

import com.syk.boot.jwt.BootConfigApplication;
import com.syk.boot.jwt.model.Family;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@SpringBootTest(classes = BootConfigApplication.class)
@ExtendWith(SpringExtension.class)
class FamilyNameTest {
    @Resource
    private Family family;

    @Test
    void printFamily() {
        System.out.println(family);
    }
}