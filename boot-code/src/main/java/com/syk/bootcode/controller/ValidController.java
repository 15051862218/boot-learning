package com.syk.bootcode.controller;


import com.syk.bootcode.utils.MatchCodeUtil;
import com.syk.bootcode.utils.RandomCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 沈永康
 * @Date 2022/4/29 10:17
 * @Version 1.0
 */

@RestController
@Slf4j
public class ValidController {
    @Resource
    private RandomCodeUtil randomCodeUtil;
    @Resource
    private MatchCodeUtil matchCodeUtil;

@Resource
private HttpServletRequest request;
@Resource
private HttpServletResponse response;
    @GetMapping("/randomCode")
    private void randomCode(){
        try {
            randomCodeUtil.createCode(request,response);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @GetMapping("/checkRandomCode")
    private String checkRandomCode(String code) {
        String saveCode = (String) request.getSession().getAttribute("randomCode");
        log.info(saveCode);
        if (saveCode.equalsIgnoreCase(code)) {
            log.info("验证码正确");
            return "验证码正确";

        }else {
            log.info("验证码错误");
            return "验证码错误";
        }

    }
    @GetMapping("/matchCode")
    private void matchCode() {
        try {
            matchCodeUtil.createCode(request,response);

        }catch (IOException e){
            log.info("生成验证码出错");
        }

    }
    @GetMapping("/checkMatchCode")
    private String checkMatchCode(String code) {
        int saveCode = (int) request.getSession().getAttribute("matchCode");
        log.info(String.valueOf(saveCode));
        int sendCode = Integer.parseInt(code);
        if (saveCode == sendCode) {
            log.info("验证真确");
            return "验证码正确";
        }else {
            log.info("验证码错误");
            return  "验证码错误";
        }
    }

}
