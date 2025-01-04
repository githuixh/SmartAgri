package com.ruoyi.farmer.service;

import com.ruoyi.farmer.domain.FarmerCategories;

import java.util.List;

/**
 * farmerService接口
 * 
 * @author ruoyi
 * @date 2025-01-04
 */
public interface IFarmerCategoriesService 
{
    /**
     * 查询farmer
     * 
     * @param id farmer主键
     * @return farmer
     */
    public FarmerCategories selectFarmerCategoriesById(Long id);

    /**
     * 查询farmer列表
     * 
     * @param farmerCategories farmer
     * @return farmer集合
     */
    public List<FarmerCategories> selectFarmerCategoriesList(FarmerCategories farmerCategories);

    /**
     * 新增farmer
     * 
     * @param farmerCategories farmer
     * @return 结果
     */
    public int insertFarmerCategories(FarmerCategories farmerCategories);

    /**
     * 修改farmer
     * 
     * @param farmerCategories farmer
     * @return 结果
     */
    public int updateFarmerCategories(FarmerCategories farmerCategories);

    /**
     * 批量删除farmer
     * 
     * @param ids 需要删除的farmer主键集合
     * @return 结果
     */
    public int deleteFarmerCategoriesByIds(Long[] ids);

    /**
     * 删除farmer信息
     * 
     * @param id farmer主键
     * @return 结果
     */
    public int deleteFarmerCategoriesById(Long id);
}
