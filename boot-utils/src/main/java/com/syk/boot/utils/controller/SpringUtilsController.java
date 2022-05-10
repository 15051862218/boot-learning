package com.syk.boot.utils.controller;


import com.syk.boot.utils.commom.AjaxResponse;
import com.syk.boot.utils.commom.Constants;
import com.syk.boot.utils.entity.PageEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 沈永康
 * @Date 2022/5/6 10:44
 * @Version 1.0
 */


@RestController
@RequestMapping("/api/utils")
public class SpringUtilsController {

    @GetMapping("/assert")
    public AjaxResponse assertDemo(@RequestBody PageEntity pageEntity) {
        Assert.isTrue(pageEntity.getPageNumber() > 0, Constants.PAGE_NUMBER_ERROR);
        Assert.isTrue(pageEntity.getLimit() <= Constants.PAGE_LIMIT, Constants.PAGE_LIMIT_ERROR);
        return AjaxResponse.success(pageEntity);
    }
}