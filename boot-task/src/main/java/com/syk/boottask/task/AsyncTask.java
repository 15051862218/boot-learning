package com.syk.boottask.task;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author 沈永康
 * @Date 2022/4/12 15:48
 * @Version 1.0
 */

@Component
public class AsyncTask extends AbstractTask{
    @Override
    @Async
    public  void doTaskOne() throws Exception {
            super.doTaskOne();
        }
    @Override
    @Async
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }
    @Override
    @Async
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}
