package com.syk.boottask.task;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;
import java.util.Random;

/**
 * @Author 沈永康
 * @Date 2022/4/12 15:35
 * @Version 1.0
 */


public abstract class AbstractTask {
    private static  final Random random = new Random();
    void doTaskOne() throws Exception{
        System.out.println("开始做任务一");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    void doTaskTwo() throws Exception{
        System.out.println("开始做任务二");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    void doTaskThree() throws Exception{
        System.out.println("开始做任务三");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }
}
