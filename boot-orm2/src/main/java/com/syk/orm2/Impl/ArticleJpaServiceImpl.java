package com.syk.orm2.Impl;


import com.syk.orm2.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @Author 沈永康
 * @Date 2022/3/18 15:44
 * @Version 1.0
 */

@Service
public class ArticleJpaServiceImpl implements  ArticleService{
    @Resource
   private ArticleRepository articleRepository;

   @Override
   @Transactional(rollbackFor = {Exception.class})
   public  Article saveArticle(Article article){
       return  articleRepository.save(article);
   }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  void  deleteById(int id){
        articleRepository.deleteById(id);
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void  updateArticle(Article article){
         articleRepository.save(article);
    }

    @Override
    public List<Article> selectAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article finfById(int id) {
       Optional<Article> optional = articleRepository.findById(id);

        return optional.orElse(null);
    }

    @Override
    public List<Article> finfByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }
}
