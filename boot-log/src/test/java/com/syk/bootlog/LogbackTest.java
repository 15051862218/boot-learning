package com.syk.bootlog;


import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.extension.ExtendWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @Author 沈永康
 * @Date 2022/4/11 17:31
 * @Version 1.0
 */




    @SpringBootTest

    @ExtendWith(SpringExtension.class)
    public class LogbackTest {

        private final Logger logger= LoggerFactory.getLogger(LogbackTest.class);

        @Test
        public void LogToSql(){
            logger.info("info");
            logger.error("error");

        }
    }


