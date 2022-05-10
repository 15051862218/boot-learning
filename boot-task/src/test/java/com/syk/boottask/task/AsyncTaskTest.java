package com.syk.boottask.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @Author 沈永康
 * @Date 2022/4/13 13:24
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AsyncTaskTest {
    @Resource
    private  AsyncTask asyncTask;
    @Test
    public void testSyncTasks() throws Exception {
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
        asyncTask.doTaskThree();
    }

}