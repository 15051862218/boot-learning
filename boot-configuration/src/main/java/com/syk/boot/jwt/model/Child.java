package com.syk.boot.jwt.model;

import lombok.Data;

import java.util.List;

/**
 * @program: boot-learning
 * @description: 孩子有名字和年龄还有朋友们
 * @author: ShenTF
 * @create: 2022-03-14 11:06:35
 **/

@Data
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}
