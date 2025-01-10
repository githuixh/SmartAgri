package com.ruoyi.farmer.mapper;

import com.ruoyi.farmer.domain.FarmerProductsTags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品标签关联Mapper接口增强
 *
 * @author ruoyi
 * @date 2025-01-07
 */
public interface FarmerProductsTagsMapperExt {
    public void insertProductsTags(@Param("productsId") Long productsId, @Param("tagsIds") List<Long> tagsIds);

    public List<FarmerProductsTags> selectProductsTagsListByProductsId(@Param("productsId") Long productsId);

    public List<FarmerProductsTags> selectProductsTagsListByTagsIds(@Param("tagsIds") List<Long> tagsIds);

    public List<FarmerProductsTags> selectProductsTagsListByProductsIds(@Param("productIds") List<Long> productIds);

    public void deleteProductsTagsByPid(@Param("ids") Long[] ids);
}
