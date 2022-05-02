package com.chenxin.shop.modules.pms.service.impl;

import com.chenxin.shop.modules.pms.entity.PmsProductCategoryAttributeRelation;
import com.chenxin.shop.modules.pms.mapper.PmsProductCategoryAttributeRelationMapper;
import com.chenxin.shop.modules.pms.service.PmsProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author Star_Chen
 * @since 2022-05-02
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements PmsProductCategoryAttributeRelationService {

}
