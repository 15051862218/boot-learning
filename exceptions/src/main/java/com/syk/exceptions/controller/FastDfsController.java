package com.syk.exceptions.controller;


import com.syk.exceptions.enums.CustomExceptionType;
import com.syk.exceptions.exception.CustomException;
import com.syk.exceptions.utils.AjaxResponse;
import com.syk.fastdfsspringbootstarter.FastDFSClientUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author 沈永康
 * @Date 2022/4/14 22:12
 * @Version 1.0
 */


@RestController
@RequestMapping(value = "fastdfs")
public class FastDfsController {
    @Resource
    private FastDFSClientUtil fastDFSClientUtil;

    @PostMapping("/upload")
    public AjaxResponse upload(@RequestParam("file") MultipartFile file) {
        String fileId;
        try {
            String originalFileName = file.getOriginalFilename();
            assert originalFileName != null;
            fileId = fastDFSClientUtil.uploadFile(file.getBytes(),originalFileName.substring(originalFileName.lastIndexOf(".")));
            return AjaxResponse.success(fastDFSClientUtil.getSourceUrl(fileId));
        } catch (Exception e) {
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR,"文件上传图片服务器失败");
        }
    }

}