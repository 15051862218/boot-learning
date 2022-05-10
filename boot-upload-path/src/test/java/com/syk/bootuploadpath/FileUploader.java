package com.syk.bootuploadpath;


import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.syk.bootuploadpath.utils.MinioTemplate;
import io.minio.ObjectWriteResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/4/14 19:24
 * @Version 1.0
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class FileUploader {
    @Resource
    private MinioTemplate minioTemplate;
    @Test
    void  testCreateBucket() throws Exception {
        minioTemplate.makeBucket("hello");
    }
    @Test
    void testPutObject() throws Exception {
        ObjectWriteResponse res = minioTemplate.putObject("hello","img/banner1.jpg" ,"D:/upload/my.jpg");
        System.out.println(res.object());
    }
    @Test
    void  testDeleteObject() throws  Exception {
        minioTemplate.removeObject("hello","img/banner1.jpg");
    }
}
