package com.syk.boot.jwt.model;


import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/3/15 16:01
 * @Version 1.0
 */

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class EncryptorTest {
    @Resource
    private StringEncryptor encryptor;

    @Test
    void getEncryptor(){
        String happy_family = encryptor.encrypt("happy family");
        log.info(happy_family);

    }
}
