package com.syk.boottask.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import  static java.lang.Thread.sleep;


/**
 * @Author 沈永康
 * @Date 2022/4/13 12:19
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AsyncCallBackTaskTest {
    @Resource
    private  AsyncCallBackTask asyncCallBackTask;
    @Test
    public  void  testAsyncCallbackTask() throws  Exception {
        long start = currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallback();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallback();
        while ( !task1.isDone() || !task2.isDone() || !task3.isDone()) {
            sleep(1000);
        }

        long end = currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
       }

}