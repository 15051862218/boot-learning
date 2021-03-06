package com.syk.bootuploadpath.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author 沈永康
 * @Date 2022/4/14 15:40
 * @Version 1.0
 */

@RestController
public class FileUploadController {
    @Value("${file.upload-path}")
    private  String uploadPath;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile , HttpServletRequest request) throws IOException {
        String format = sdf.format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        assert oldName != null;
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        uploadFile.transferTo(new File(folder,newName));

        return request.getScheme() + "://" + request.getServerName()+ ":"+request.getServerPort()+"/"+format+newName;
    }
}
