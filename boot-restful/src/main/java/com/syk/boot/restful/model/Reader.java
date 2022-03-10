package com.syk.boot.restful.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 沈永康
 * @Date 2022/3/10 19:03
 * @Version 1.0
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private String name;
    private Integer age;
}
