package com.syk.service.impl;


import com.syk.Dao.ArticleDao;
import com.syk.service.ArticleService;
import com.syk.ulity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Author 沈永康
 * @Date 2022/3/18 9:54
 * @Version 1.0
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Override
    public Article saveArticle(Article article){
        int n = articleDao.save(article);
        if (n != 0){
            return article;
        }else {
            return null;

        }
    }
}
