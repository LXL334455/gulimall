package com.atguigu.gulimall.thirdparty.utils;

import com.atguigu.gulimall.thirdparty.properties.QiNiuCloudProperties;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;

/**
 * @author lirulong
 * @version V1.0
 * @program: gulimall
 * @Package com.atguigu.gulimall.thirdparty.utils
 * @Description: TODO
 * @date 2023/3/23 20:50
 */
@Component
public class FileUploadUtil {

    @Autowired
    private QiNiuCloudProperties properties;

    public String uploadByFile(byte[]bytes,String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());;
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = properties.getAccessKey();
        String secretKey = properties.getSecretKey();
        String bucket = properties.getBucket();

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //获取当前日期作为文件夹名
        String dirTimeName = LocalDate.now().toString();
        String key = dirTimeName+"/"+fileName;

        try {
//            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
//            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(uploadBytes);

            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(bytes, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//                System.out.println(putRet.key);
//                System.out.println(putRet.hash);
                return properties.getHostName()+putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
    return null;
    }
}
