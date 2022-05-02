package com.chenxin.shop.modules.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chenxin.shop.modules.entity.Users;

import java.util.List;

/**
 * @Description:
 * @title: TestService
 * @Author Star_Chen
 * @Date: 2021/12/24 8:57
 * @Version 1.0
 */
public interface TestService extends IService<Users> {

    /**
     * @Date: 2021/12/24 9:01
     * @Author: Star_Chen
     * @Param:  * @param null
     * @Description: 获取所有用户接口
     * @Return: List<User>
     */
    List<Users> getUserList();

    Page<Users> getUserPageList(String keyword, Integer pageNum, Integer pageSize);

    Page<Users> getXmlUserPageList(String keyword, Integer pageNum, Integer pageSize);
}
