package com.syk.orm2.Impl;


import com.syk.orm2.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author 沈永康
 * @Date 2022/3/18 15:20
 * @Version 1.0
 */


public interface ArticleRepository extends JpaRepository<Article ,Integer> {

    List<Article> findByAuthor(String author);
}
