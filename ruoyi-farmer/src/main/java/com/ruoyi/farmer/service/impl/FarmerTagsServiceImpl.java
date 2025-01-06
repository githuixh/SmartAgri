package com.ruoyi.farmer.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.farmer.domain.FarmerTags;
import com.ruoyi.farmer.mapper.FarmerTagsMapper;
import com.ruoyi.farmer.service.IFarmerTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huixh
 */
@Service
public class FarmerTagsServiceImpl implements IFarmerTagsService {
    @Resource
    private FarmerTagsMapper farmerTagsMapper;

    /**
     * 查询商品标签
     *
     * @param id 商品标签主键
     * @return 商品标签
     */
    @Override
    public FarmerTags selectFarmerTagsById(Long id)
    {
        return farmerTagsMapper.selectFarmerTagsById(id);
    }

    /**
     * 查询商品标签列表
     *
     * @param farmerTags 商品标签
     * @return 商品标签
     */
    @Override
    public List<FarmerTags> selectFarmerTagsList(FarmerTags farmerTags)
    {
        return farmerTagsMapper.selectFarmerTagsList(farmerTags);
    }

    /**
     * 新增商品标签
     *
     * @param farmerTags 商品标签
     * @return 结果
     */
    @Override
    public int insertFarmerTags(FarmerTags farmerTags)
    {
        farmerTags.setCreateTime(DateUtils.getNowDate());
        return farmerTagsMapper.insertFarmerTags(farmerTags);
    }

    /**
     * 修改商品标签
     *
     * @param farmerTags 商品标签
     * @return 结果
     */
    @Override
    public int updateFarmerTags(FarmerTags farmerTags)
    {
        farmerTags.setUpdateTime(DateUtils.getNowDate());
        return farmerTagsMapper.updateFarmerTags(farmerTags);
    }

    /**
     * 批量删除商品标签
     *
     * @param ids 需要删除的商品标签主键
     * @return 结果
     */
    @Override
    public int deleteFarmerTagsByIds(Long[] ids)
    {
        return farmerTagsMapper.deleteFarmerTagsByIds(ids);
    }

    /**
     * 删除商品标签信息
     *
     * @param id 商品标签主键
     * @return 结果
     */
    @Override
    public int deleteFarmerTagsById(Long id)
    {
        return farmerTagsMapper.deleteFarmerTagsById(id);
    }
}