package com.ruoyi.farmer.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.farmer.domain.FarmerProducts;
import com.ruoyi.farmer.mapper.FarmerProductsMapper;
import com.ruoyi.farmer.service.IFarmerProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huixh
 */
@Service
public class FarmerProductsServiceImpl implements IFarmerProductsService {

    @Resource
    private FarmerProductsMapper farmerProductsMapper;

    /**
     * 查询products
     *
     * @param id products主键
     * @return products
     */
    @Override
    public FarmerProducts selectFarmerProductsById(Long id)
    {
        return farmerProductsMapper.selectFarmerProductsById(id);
    }

    /**
     * 查询products列表
     *
     * @param farmerProducts products
     * @return products
     */
    @Override
    public List<FarmerProducts> selectFarmerProductsList(FarmerProducts farmerProducts)
    {
        return farmerProductsMapper.selectFarmerProductsList(farmerProducts);
    }

    /**
     * 新增products
     *
     * @param farmerProducts products
     * @return 结果
     */
    @Override
    public int insertFarmerProducts(FarmerProducts farmerProducts)
    {
        farmerProducts.setCreateTime(DateUtils.getNowDate());
        return farmerProductsMapper.insertFarmerProducts(farmerProducts);
    }

    /**
     * 修改products
     *
     * @param farmerProducts products
     * @return 结果
     */
    @Override
    public int updateFarmerProducts(FarmerProducts farmerProducts)
    {
        farmerProducts.setUpdateTime(DateUtils.getNowDate());
        return farmerProductsMapper.updateFarmerProducts(farmerProducts);
    }

    /**
     * 批量删除products
     *
     * @param ids 需要删除的products主键
     * @return 结果
     */
    @Override
    public int deleteFarmerProductsByIds(Long[] ids)
    {
        return farmerProductsMapper.deleteFarmerProductsByIds(ids);
    }

    /**
     * 删除products信息
     *
     * @param id products主键
     * @return 结果
     */
    @Override
    public int deleteFarmerProductsById(Long id)
    {
        return farmerProductsMapper.deleteFarmerProductsById(id);
    }
}
