package com.chenxin.shop.common.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.chenxin.shop.common.bean.OSSClientBean;
import com.chenxin.shop.common.util.ConstantUtil;

@Configuration
public class OSSBeanConfig {

    @Autowired
    private OSSClientBean ossClientBean;

    /**
     * @Date: 2022/5/1 20:46
     * @Description: 如果这里不用原型，则注入的永远是单例bean，一旦被close，就会出错
     * @Return: * @return : com.aliyun.oss.OSS
     */
    @Bean
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public OSS ossClient() {
        return new OSSClientBuilder().build(ConstantUtil.HTTPS + ossClientBean.getEndpoint(), ossClientBean.getAccessId(), ossClientBean.getAccessSecret());
    }
}
