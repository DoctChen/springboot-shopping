package com.chenxin.shop.common.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.chenxin.shop.modules.test.entity.Users;
import com.chenxin.shop.modules.test.service.UserCacheService;

import javax.annotation.PostConstruct;

/**
 * @Description: Redis初始化数据demo，测试redis连通性
 * @title: RedisInitializingBean
 * @Author Star_Chen
 * @Date: 2022/4/9 21:55
 * @Version 1.0
 */
@Component
public class RedisInitializingBean {

    @Autowired
    private UserCacheService userCacheService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * @Date: 2022/5/2 15:17
     * @Description: 布隆过滤器初始化
     * @Return:  * @return : void
     */
    @PostConstruct
    public void init() {
        userCacheService.setUsers(new Users().setName("Michael").setAddress("China").setOrderId(001));
//        redisTemplate.executePipelined(new RedisCallback<Long>() {
//            @Nullable
//            @Override
//            public Long doInRedis(RedisConnection connection) throws DataAccessException {
//                connection.openPipeline();
//                for (int offset = 10000000; offset >= 0; offset--) {
//                    boolean value = offset % 2 == 0 ? true : false;
//                    connection.setBit("bloom-filter-data-1".getBytes(), offset, value);
//                }
//                connection.closePipeline();
//                return null;
//            }
//        });
//        System.out.println("数据预热完成");
    }
}
