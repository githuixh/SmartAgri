package com.ruoyi.farmer.service.impl;

/**
 * @author huixh
 */

import com.ruoyi.farmer.domain.FarmerProductsTags;
import com.ruoyi.farmer.mapper.FarmerProductsTagsMapper;
import com.ruoyi.farmer.service.IFarmerProductsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品标签关联Service业务层处理
 *
 * @author ruoyi
 * @date 2025-01-07
 */
@Service
public class FarmerProductsTagsServiceImpl implements IFarmerProductsTagsService
{
    @Resource
    private FarmerProductsTagsMapper farmerProductsTagsMapper;

    /**
     * 查询商品标签关联
     *
     * @param id 商品标签关联主键
     * @return 商品标签关联
     */
    @Override
    public FarmerProductsTags selectFarmerProductsTagsById(Long id)
    {
        return farmerProductsTagsMapper.selectFarmerProductsTagsById(id);
    }

    /**
     * 查询商品标签关联列表
     *
     * @param farmerProductsTags 商品标签关联
     * @return 商品标签关联
     */
    @Override
    public List<FarmerProductsTags> selectFarmerProductsTagsList(FarmerProductsTags farmerProductsTags)
    {
        return farmerProductsTagsMapper.selectFarmerProductsTagsList(farmerProductsTags);
    }

    /**
     * 新增商品标签关联
     *
     * @param farmerProductsTags 商品标签关联
     * @return 结果
     */
    @Override
    public int insertFarmerProductsTags(FarmerProductsTags farmerProductsTags)
    {
        return farmerProductsTagsMapper.insertFarmerProductsTags(farmerProductsTags);
    }

    /**
     * 修改商品标签关联
     *
     * @param farmerProductsTags 商品标签关联
     * @return 结果
     */
    @Override
    public int updateFarmerProductsTags(FarmerProductsTags farmerProductsTags)
    {
        return farmerProductsTagsMapper.updateFarmerProductsTags(farmerProductsTags);
    }

    /**
     * 批量删除商品标签关联
     *
     * @param ids 需要删除的商品标签关联主键
     * @return 结果
     */
    @Override
    public int deleteFarmerProductsTagsByIds(Long[] ids)
    {
        return farmerProductsTagsMapper.deleteFarmerProductsTagsByIds(ids);
    }

    /**
     * 删除商品标签关联信息
     *
     * @param id 商品标签关联主键
     * @return 结果
     */
    @Override
    public int deleteFarmerProductsTagsById(Long id)
    {
        return farmerProductsTagsMapper.deleteFarmerProductsTagsById(id);
    }
}