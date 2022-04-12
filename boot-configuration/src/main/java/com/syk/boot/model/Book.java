package com.syk.boot.model;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @Author 沈永康
 * @Date 2022/3/14 14:27
 * @Version 1.0
 */

@Data
public class Book {
    @Min(value = 2,message = "不能小于2")
    private Integer price;
    private String name;
    @Past
    private Date createTime;
}
