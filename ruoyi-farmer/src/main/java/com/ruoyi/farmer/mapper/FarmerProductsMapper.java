package com.ruoyi.farmer.mapper;

import com.ruoyi.farmer.domain.FarmerProducts;

import java.util.List;

/**
 * @author huixh
 */
public interface FarmerProductsMapper {
    /**
     * 查询products
     *
     * @param id products主键
     * @return products
     */
    public FarmerProducts selectFarmerProductsById(Long id);

    /**
     * 查询products列表
     *
     * @param farmerProducts products
     * @return products集合
     */
    public List<FarmerProducts> selectFarmerProductsList(FarmerProducts farmerProducts);

    /**
     * 新增products
     *
     * @param farmerProducts products
     * @return 结果
     */
    public int insertFarmerProducts(FarmerProducts farmerProducts);

    /**
     * 修改products
     *
     * @param farmerProducts products
     * @return 结果
     */
    public int updateFarmerProducts(FarmerProducts farmerProducts);

    /**
     * 删除products
     *
     * @param id products主键
     * @return 结果
     */
    public int deleteFarmerProductsById(Long id);

    /**
     * 批量删除products
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmerProductsByIds(Long[] ids);
}
