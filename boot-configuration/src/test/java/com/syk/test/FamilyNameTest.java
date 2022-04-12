package com.syk.test;

import com.syk.boot.BootConfigApplication;
import com.syk.boot.model.Family;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

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