package com.chenxin.shop.common.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description: 文件常用工具类
 * @title: FileUtil
 * @Author Star_Chen
 * @Date: 2022/5/1 19:04
 * @Version 1.0
 */
@Component
public class FileUtil {

    /**
     * @param fileName :
     * @Date: 2022/5/1 19:06
     * @Description: 根据上传时间拼接文件名称，生成oss存储的文件名称
     * @Return: * @return : java.lang.String
     */
    public String generateFileKey(String fileName) {
        return TimeConvertUtil.getCurrentDay() + "/" + UUID.randomUUID().toString() + "." + fileName;
    }
}
