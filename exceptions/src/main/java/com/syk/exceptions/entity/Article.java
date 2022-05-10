package com.syk.exceptions.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

import javax.validation.constraints.NotNull;


/**
 * @Author 沈永康
 * @Date 2022/4/11 13:07
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class Article {
    @Min(7)
    private Integer id;
    @NotNull(message = "文章标题不能为空")
    private  String title;
}
