package com.syk.boot.jwt.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @program: boot-learning
 * @description: 无比注意 成员变量名 一一对应
 * @author: ShenTF
 * @create: 2022-03-14 11:09:16
 **/

@Data
@Component
/**
 * 配置整体前缀
 */
@ConfigurationProperties( prefix = "family")
@Validated
public class Family {
    private Father father;
    private Child child;
    private Mother mother;
    private String familyName;
}
