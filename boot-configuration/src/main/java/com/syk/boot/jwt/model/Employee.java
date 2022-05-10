package com.syk.boot.jwt.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @Author 沈永康
 * @Date 2022/3/14 15:41
 * @Version 1.0
 */

@Data
@Configuration
@PropertySource(name="employeeProperties",value = "classpath:employee.properties")
public class Employee {
   @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;
    @Value("#{'${employee.names}'.split(',')[0]}")
    private List<String> firstName;


    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

    @Value("#{${employee.age}['three'] != null ? ${employee.age}['three']:80 }")
    private Integer ageWithDefaultValue;

    @Value("#{systemProperties['java.home']}")
    private String javaName;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;
}
