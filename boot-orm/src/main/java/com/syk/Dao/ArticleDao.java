package com.syk.Dao;


import com.syk.ulity.Article;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.lang.annotation.Retention;

/**
 * @Author 沈永康
 * @Date 2022/3/18 9:17
 * @Version 1.0
 */

@Repository
public class ArticleDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public int save(Article article){
        String sql = "INSERT INTO article (author,title,content) VALUES(?,?,?) ";
        return jdbcTemplate.update(sql, article.getAuthor(), article.getTitle(), article.getContent());

    }
}
