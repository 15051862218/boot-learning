package com.syk.orm2.Impl;


import com.syk.orm2.entity.Article;

import java.util.List;

/**
 * @Author 沈永康
 * @Date 2022/3/18 15:23
 * @Version 1.0
 */


public interface ArticleService {
    Article saveArticle(Article article);

    void deleteById(int id);

    void updateArticle(Article article);

    List<Article> selectAll();

    Article finfById(int id);

    List<Article> finfByAuthor(String author);

}
