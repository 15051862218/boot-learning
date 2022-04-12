package com.syk.exceptions.controller;


import com.syk.exceptions.entity.Article;
import com.syk.exceptions.service.ExceptionService;
import com.syk.exceptions.utils.AjaxResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author 沈永康
 * @Date 2022/4/11 13:10
 * @Version 1.0
 */

@RestController
public class ArticleController {
    @Resource
    private ExceptionService exceptionService;

    @GetMapping("/test/{id}")
    public AjaxResponse test(@PathVariable("id") int id){
        exceptionService.userBizError(id);
        Article article =Article.builder().id(3).title("Java").build();
        return  AjaxResponse.success(article);
    }
    @PostMapping("/articles")
    public Article saveArticle(@Valid @RequestBody Article article){
        return  article;
    }
}
