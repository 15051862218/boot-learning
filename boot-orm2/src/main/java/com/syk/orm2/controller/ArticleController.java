package com.syk.orm2.controller;


import boot.syk.boot.restful.common.AjaxResponse;
import com.syk.orm2.Impl.ArticleJpaServiceImpl;
import com.syk.orm2.entity.Article;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/3/18 15:53
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/articles")
public class ArticleController {
    @Resource
    private ArticleJpaServiceImpl articleJpaService;

    @GetMapping(value = "/all")
    public AjaxResponse selectAll(){
        return AjaxResponse.success(articleJpaService.selectAll());
    }
    @PostMapping()
    public AjaxResponse addArticle(@RequestBody Article article){
        return  AjaxResponse.success(articleJpaService.saveArticle(article));
    }
    @PutMapping()
    public AjaxResponse addAarticle(@RequestBody Article article){
        if (articleJpaService.saveArticle(article)!= null){
            return AjaxResponse.success("修改成功");
        }else {
            return AjaxResponse.failure();
        }
    }
    @GetMapping("{id}")
    public  AjaxResponse findById(@PathVariable int id ){
        return AjaxResponse.success(articleJpaService.finfById(id));
    }
}
