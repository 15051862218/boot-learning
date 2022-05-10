package com.syk.boottask.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;




/**
 * @Author 沈永康
 * @Date 2022/4/13 13:18
 * @Version 1.0
 */


@SpringBootTest
@ExtendWith(SpringExtension.class)
class SyncTaskTest {
  @Resource
    private  SyncTask syncTask;
  @Test
    public void testSyncTasks() throws Exception {
      syncTask.doTaskOne();
      syncTask.doTaskTwo();
      syncTask.doTaskThree();
  }
}