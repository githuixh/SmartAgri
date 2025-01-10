package com.ruoyi.farmer.service;

import com.ruoyi.farmer.domain.FarmerProductsTags;

import java.util.List;

/**
 * 商品标签关联Service接口
 *
 * @author ruoyi
 * @date 2025-01-07
 */
public interface IFarmerProductsTagsService
{
    /**
     * 查询商品标签关联
     *
     * @param id 商品标签关联主键
     * @return 商品标签关联
     */
    public FarmerProductsTags selectFarmerProductsTagsById(Long id);

    /**
     * 查询商品标签关联列表
     *
     * @param farmerProductsTags 商品标签关联
     * @return 商品标签关联集合
     */
    public List<FarmerProductsTags> selectFarmerProductsTagsList(FarmerProductsTags farmerProductsTags);

    /**
     * 新增商品标签关联
     *
     * @param farmerProductsTags 商品标签关联
     * @return 结果
     */
    public int insertFarmerProductsTags(FarmerProductsTags farmerProductsTags);

    /**
     * 修改商品标签关联
     *
     * @param farmerProductsTags 商品标签关联
     * @return 结果
     */
    public int updateFarmerProductsTags(FarmerProductsTags farmerProductsTags);

    /**
     * 批量删除商品标签关联
     *
     * @param ids 需要删除的商品标签关联主键集合
     * @return 结果
     */
    public int deleteFarmerProductsTagsByIds(Long[] ids);

    /**
     * 删除商品标签关联信息
     *
     * @param id 商品标签关联主键
     * @return 结果
     */
    public int deleteFarmerProductsTagsById(Long id);
}