package com.ruoyi.farmer.service;

import com.ruoyi.farmer.domain.FarmerTags;

import java.util.List;

/**
 * @author huixh
 */
public interface IFarmerTagsService {
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
     * 批量删除商品标签
     *
     * @param ids 需要删除的商品标签主键集合
     * @return 结果
     */
    public int deleteFarmerTagsByIds(Long[] ids);

    /**
     * 删除商品标签信息
     *
     * @param id 商品标签主键
     * @return 结果
     */
    public int deleteFarmerTagsById(Long id);
}