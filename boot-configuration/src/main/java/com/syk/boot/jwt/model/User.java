package com.syk.boot.jwt.model;


import com.syk.boot.jwt.util.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * @Author 沈永康
 * @Date 2022/3/14 14:27
 * @Version 1.0
 */

@Data
@Component
@ConfigurationProperties(prefix = "user")
@PropertySource(value = {"classpath:user.yml"},factory = MixPropertySourceFactory.class)
public class User {
    private String name;
    private Integer age;
    @Valid
    private Book book;
}
