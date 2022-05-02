package com.chenxin.shop.modules.controller;

import com.aliyun.oss.OSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.chenxin.shop.common.bean.OSSClientBean;
import com.chenxin.shop.common.util.FileUtil;
import com.chenxin.shop.common.util.OSSUtil;
import com.chenxin.shop.enums.BusinessExceptionEnum;
import com.chenxin.shop.exception.GlobalException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description:
 * @title: UploadController
 * @Author Star_Chen
 * @Date: 2022/5/1 16:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/kms")
public class UploadController {

    @Autowired
    private OSSUtil ossUtil;

    @Autowired
    private OSSClientBean ossClientBean;

    @Autowired
    private OSS ossClient;

    @Autowired
    private FileUtil fileUtil;

    @PostMapping("/upload")
    public void upload(HttpServletRequest request) {
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String key = fileUtil.generateFileKey(suffix);
        long contentLength = file.getSize();
        try {
            ossUtil.uploadFile(ossClientBean.getBucket(), key, file.getInputStream(), contentLength);
        } catch (IOException e) {
            throw new GlobalException(BusinessExceptionEnum.UPLOAD_FAILED);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }


}
