package com.ruoyi.farmer.mapper;

import com.ruoyi.farmer.domain.FarmerCategories;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * farmerMapper接口
 * 
 * @author ruoyi
 * @date 2025-01-04
 */
public interface FarmerCategoriesMapperExt
{
    public List<FarmerCategories> selectFarmerCategoriesListByPid(FarmerCategories farmerCategories);

    public List<FarmerCategories> getChildrenNodes(@Param("idList") List<Long> idList);
}
