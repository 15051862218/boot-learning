package com.syk.boottask.task;


import com.syk.boottask.service.MailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.io.InterruptedIOException;
import java.util.Date;

/**
 * @Author 沈永康
 * @Date 2022/4/12 18:53
 * @Version 1.0
 */

@Component
public class ScheduledJobs {
    @Resource
    private MailService mailService;

    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() throws InterruptedException {
        System.out.println("fixedDelay 开始 :" + new Date());
        Thread.sleep(10*1000);
        System.out.println("fixedDelay 结束 :" + new Date());
    }

    @Scheduled(fixedRate = 3000)
    public void fixedRateJob() throws InterruptedException {
        System.out.println("fixedRate 开始 :" + new Date());
        Thread.sleep(5*1000);
        System.out.println("fixedRate 结束 :" + new Date());
    }
    @Scheduled(cron =  "0 0 20 12 4 2 ")
   public   void sendSimpleMail() {
        mailService.sendSimpleMail("2531227817@qq.com","发邮件作业","沈永康来报到");
    }
}
