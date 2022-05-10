package com.syk.boottask.service;

import com.syk.boottask.task.ScheduledJobs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @Author 沈永康
 * @Date 2022/4/12 18:15
 * @Version 1.0
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ExtendWith(SpringExtension.class)
class MailServiceTest {
    @Resource
    private ScheduledJobs mailService;
    @Test
//    @Scheduled(cron =  "0 07 19 12 4 2 ")
    void sendSimpleMail() {
        mailService.sendSimpleMail();
    }
}