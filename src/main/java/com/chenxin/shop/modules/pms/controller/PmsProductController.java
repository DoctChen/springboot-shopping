package com.chenxin.shop.modules.pms.controller;


import com.chenxin.shop.modules.pms.entity.PmsProduct;
import com.chenxin.shop.modules.pms.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author Star_Chen
 * @since 2022-05-02
 */
@RestController
@RequestMapping("/pms/pmsProduct")
public class PmsProductController {


    @Autowired
    private PmsProductService pmsProductService;

    /**
     * @Date: 2022/5/2 15:49
     * @Description: 获取商品列表
     * @Return:  * @return : java.util.List<com.chenxin.shop.modules.pms.entity.PmsProduct>
     */
    @GetMapping("/list")
    public List<PmsProduct> list(){
        return pmsProductService.list();
    }
}

