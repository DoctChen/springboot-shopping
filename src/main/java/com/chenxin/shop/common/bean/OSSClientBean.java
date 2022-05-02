package com.chenxin.shop.common.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @title: OSSClientBean
 * @Author Star_Chen
 * @Date: 2022/5/1 15:36
 * @Version 1.0
 */
@Component
@Data
public class OSSClientBean {

    @Value("${aliyun.access-id}")
    private String accessId;

    @Value("${aliyun.access-secret}")
    private String accessSecret;

    @Value("${aliyun.bucket}")
    private String bucket;

    @Value("${aliyun.endpoint}")
    private String endpoint;
}
