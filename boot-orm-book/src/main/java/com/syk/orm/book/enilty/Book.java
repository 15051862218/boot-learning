package com.syk.orm.book.enilty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author 沈永康
 * @Date 2022/3/19 10:27
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "t_book")
public class Book {
    @Id
    private Integer id;
    private  String name;
    private String cover;
}
