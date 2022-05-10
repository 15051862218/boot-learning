package com.syk.boot.jwt.cache;


import com.syk.boot.jwt.cache.model.Address;
import com.syk.boot.jwt.cache.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author 沈永康
 * @Date 2022/4/17 22:48
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class RedisTest1 {
    @Resource
    private  StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String,Person> redisTemplate;
    @Test
    public void  testString() {
        ValueOperations<String,String> stringValueOperations = stringRedisTemplate.opsForValue();
        stringValueOperations.set("person:name","张三",20, TimeUnit.SECONDS);
        String name = stringValueOperations.get("person:name");
        log.info(name);
    }

    @Test
    public void  testObject() {
        Address address = new Address("中国","北京");
        Person person = Person.builder()
                .id(1)
                .firstName("李")
                .lastName("明")
                .address(address)
                .build();
        ValueOperations<String, Person> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("person:object",person,20,TimeUnit.SECONDS);
        Person savedPerson = valueOperations.get("person:object");
        log.info(String.valueOf(savedPerson));
    }
}
