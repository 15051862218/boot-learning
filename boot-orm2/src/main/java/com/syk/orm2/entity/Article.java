package com.syk.orm2.entity;


import com.syk.orm2.listener.DataBaseAuditListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author 沈永康
 * @Date 2022/3/18 14:58
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(DataBaseAuditListener.class)
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String title;
    private  String thumbnail;
    private String content;
    @Column(name = "create_time", updatable = false)
    private Date createTime;
    private Date updateTime;

}
