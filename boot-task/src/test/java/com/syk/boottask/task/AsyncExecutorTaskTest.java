package com.syk.boottask.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import static  java.lang.Thread.sleep;


/**
 * @Author 沈永康
 * @Date 2022/4/13 12:55
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AsyncExecutorTaskTest {
    @Resource
    private AsyncExecutorTask asyncExecutorTask;
    @Test
    public void testAsyncExecutorTask() throws Exception {
        asyncExecutorTask.doTaskOneCallback();
        asyncExecutorTask.doTaskTwoCallback();
        asyncExecutorTask.doTaskThreeCallback();
        sleep(30 * 1000L);
    }
}