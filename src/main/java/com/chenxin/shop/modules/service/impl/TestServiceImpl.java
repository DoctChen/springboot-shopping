package com.chenxin.shop.modules.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chenxin.shop.modules.dao.TestDao;
import com.chenxin.shop.modules.entity.Users;
import com.chenxin.shop.modules.service.TestService;

import java.util.List;

/**
 * @Description:
 * @title: TestServiceImpl
 * @Author Star_Chen
 * @Date: 2021/12/24 8:57
 * @Version 1.0
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestDao, Users> implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Users> getUserList() {
        return testDao.getUserList();
    }


    /**
     * @Date: 2022/4/18 9:50
     * @Author: Star_Chen
     * @Param:  * @param Page<Users>
     * @Description: 分页获取用户列表测试
     */
    @Override
    public Page<Users> getUserPageList(String keyword, Integer pageNum, Integer pageSize) {
        Page<Users> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Users> lambda = wrapper.lambda();
        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(Users::getName, keyword);
//            lambda.or().like(Users::getNickName, keyword);
        }
        return page(page, wrapper);
    }

    @Override
    public Page<Users> getXmlUserPageList(String keyword, Integer pageNum, Integer pageSize) {
        Page<Users> page = new Page<>(pageNum, pageSize);
        return testDao.getXmlUserPageList(page);
    }
}
