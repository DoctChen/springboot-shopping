package com.chenxin.shop.common.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chenxin.shop.common.bean.OSSClientBean;
import com.chenxin.shop.common.config.OSSBeanConfig;

import java.io.InputStream;

/**
 * @Description: OSS常用上传下载工具类
 * @title: OSSUtil
 * @Author Star_Chen
 * @Date: 2022/5/1 16:08
 * @Version 1.0
 */
@Component
public class OSSUtil {
    @Autowired
    private OSS ossClient;

    @Autowired
    private OSSBeanConfig ossBeanConfig;

    public OSS getOssClient() {
        return ossBeanConfig.ossClient();
    }

    @Autowired
    private OSSClientBean ossClientBean;

    public void uploadFile(String bucketName, String key, InputStream input) {
        ossClient.putObject(bucketName, key, input);
        ossClient.shutdown();
    }

    public void uploadFile(String bucketName, String key, InputStream input, long contentLength) {
        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(contentLength);
        ossClient.putObject(bucketName, key, input, objectMeta);
        ossClient.shutdown();
    }

    /**
     * @param bucketName :
     * @param key        :
     * @Date: 2022/5/1 18:51
     * @Description: 以流的方式下载
     * @Return: * @return : java.io.InputStream
     */
    public InputStream downloadFile(String bucketName, String key) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        OSSObject object = ossClient.getObject(getObjectRequest);
        return object.getObjectContent();
    }
    /**
     * @Date: 2022/5/1 19:15
     * @Description: 返回下载地址
     * @param bucketName :
     * @param key :
     * @Return:  * @return : java.lang.String
     */
    public String getDownloadUrl(String bucketName, String key) {
        return "https://" + bucketName + "." + ossClientBean.getEndpoint() + "/" + key;
    }


}
