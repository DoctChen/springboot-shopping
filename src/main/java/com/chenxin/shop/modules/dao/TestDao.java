package com.chenxin.shop.modules.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxin.shop.modules.entity.Users;

import java.util.List;

/**
 * @Description:
 * @title: TestDao
 * @Author Star_Chen
 * @Date: 2021/12/24 9:04
 * @Version 1.0
 */
public interface TestDao extends BaseMapper<Users> {

    /**
     * @Date: 2022/4/28 23:40
     * @Description: 获取文档列表
     * @Return:  * @return : java.util.List<com.chenxin.shop.modules.entity.Users>
     */
    List<Users> getUserList();

    Page<Users> getXmlUserPageList(IPage page);
}
