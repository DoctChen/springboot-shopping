package com.chenxin.shop.modules.controller;

import com.chenxin.shop.common.bean.OSSClientBean;
import com.chenxin.shop.common.util.OSSUtil;
import com.chenxin.shop.dto.FileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @title: DownloadController
 * @Author Star_Chen
 * @Date: 2022/5/1 20:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/kms")
public class DownloadController {

    @Autowired
    private OSSUtil ossUtil;

    @Autowired
    private OSSClientBean ossClientBean;

    /**
     * @Date: 2022/5/1 19:08
     * @Description: 返回下载地址
     * @Return: * @return : java.lang.String
     */
    @GetMapping("/download")
    public FileDto download(String fileKey) {
        FileDto fileDto = new FileDto();
        fileDto.setUrl(ossUtil.getDownloadUrl(ossClientBean.getBucket(), fileKey));
        return fileDto;
    }
}
