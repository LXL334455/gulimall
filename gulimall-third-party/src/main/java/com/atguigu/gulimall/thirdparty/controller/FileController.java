package com.atguigu.gulimall.thirdparty.controller;

import com.atguigu.common.utils.R;
import com.atguigu.gulimall.thirdparty.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lirulong
 * @version V1.0
 * @program: gulimall
 * @Package com.atguigu.gulimall.thirdparty.controller
 * @Description: TODO
 * @date 2023/3/23 20:56
 */
@RestController
public class FileController {
    @Autowired
    private FileUploadUtil fileUploadUtil;
    @RequestMapping("/oss/policy")
    public R upload(@RequestParam("file")MultipartFile file){
        //获取后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //创建新的文件名
        String newFileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String data =null;
        try {
            data = fileUploadUtil.uploadByFile(file.getBytes(), newFileName + suffix);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok().put("data",data);
    }
}
