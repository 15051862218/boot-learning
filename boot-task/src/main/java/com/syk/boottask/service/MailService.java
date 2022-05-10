package com.syk.boottask.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @Author 沈永康
 * @Date 2022/4/12 18:08
 * @Version 1.0
 */

@Service
public class MailService {
    @Resource
    private  JavaMailSender mailSender;

    @Value("2531227817@qq.com")
    private String fromEmail;

    public  void sendSimpleMail(String to, String subject ,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
