package com.syk.boot.utils.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 沈永康
 * @Date 2022/5/6 10:44
 * @Version 1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageEntity {
    private Integer pageNumber;
    private Integer limit;
}
