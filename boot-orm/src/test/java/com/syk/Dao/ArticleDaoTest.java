package com.syk.Dao;

import com.syk.Application;
import com.syk.service.ArticleService;
import com.syk.ulity.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @Author 沈永康
 * @Date 2022/3/18 10:08
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleDaoTest {
    @Resource
    private ArticleDao articleDao;

    @Test
     public  void saveArticle(){
        Article article  = Article.builder()

                .author("syk")
                .title("Vue")
                .content("Cvfjkdka")
                .createTime(new Date())
                .build();
       int saveArticle = articleDao.save(article);
        assertEquals(1,saveArticle);

    }
}