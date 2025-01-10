package com.ruoyi.farmer.service;

import com.ruoyi.farmer.domain.FarmerProducts;
import com.ruoyi.farmer.dto.req.FarmerProductsReq;
import com.ruoyi.farmer.dto.resp.FarmerProductsResp;

import java.util.List;

/**
 * @author huixh
 */
public interface IFarmerProductsService {
    /**
     * 查询products
     *
     * @param id products主键
     * @return products
     */
    public FarmerProductsResp selectFarmerProductsById(Long id);

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
     * 批量删除products
     *
     * @param ids 需要删除的products主键集合
     * @return 结果
     */
    public int deleteFarmerProductsByIds(Long[] ids);

    /**
     * 删除products信息
     *
     * @param id products主键
     * @return 结果
     */
    public int deleteFarmerProductsById(Long id);

    /**
     * 插入products 详细信息
     *
     * @param farmerProducts 商品对象
     * @return 结果
     */
    void insertFarmerProductsInfo(FarmerProductsReq farmerProducts);
}
