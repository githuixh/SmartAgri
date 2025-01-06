package com.ruoyi.farmer.mapper;

import com.ruoyi.farmer.domain.FarmerTags;

import java.util.List;

/**
 * 商品标签Mapper接口
 *
 * @author huixh
 * @date 2025-01-06
 */
public interface FarmerTagsMapper
{
    /**
     * 查询商品标签
     *
     * @param id 商品标签主键
     * @return 商品标签
     */
    public FarmerTags selectFarmerTagsById(Long id);

    /**
     * 查询商品标签列表
     *
     * @param farmerTags 商品标签
     * @return 商品标签集合
     */
    public List<FarmerTags> selectFarmerTagsList(FarmerTags farmerTags);

    /**
     * 新增商品标签
     *
     * @param farmerTags 商品标签
     * @return 结果
     */
    public int insertFarmerTags(FarmerTags farmerTags);

    /**
     * 修改商品标签
     *
     * @param farmerTags 商品标签
     * @return 结果
     */
    public int updateFarmerTags(FarmerTags farmerTags);

    /**
     * 删除商品标签
     *
     * @param id 商品标签主键
     * @return 结果
     */
    public int deleteFarmerTagsById(Long id);

    /**
     * 批量删除商品标签
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmerTagsByIds(Long[] ids);
}