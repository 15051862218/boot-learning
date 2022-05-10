package com.syk.boot.jwt.model;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @program: boot-learning
 * @description: 爸爸有名字和年龄
 * @author: ShenTF
 * @create: 2022-03-14 11:08:25
 **/

@Data
public class Father {
    private String name;
    @Min(value= 22, message= "爸爸年龄不能小于22岁")
    private Integer age;
}
