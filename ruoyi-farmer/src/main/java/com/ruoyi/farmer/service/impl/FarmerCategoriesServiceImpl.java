package com.ruoyi.farmer.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.exception.farmer.CategoryNodeException;
import com.ruoyi.common.exception.farmer.CategoryRemoveNodeException;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.farmer.domain.FarmerCategories;
import com.ruoyi.farmer.mapper.FarmerCategoriesMapper;
import com.ruoyi.farmer.mapper.FarmerCategoriesMapperExt;
import com.ruoyi.farmer.service.IFarmerCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * farmerService业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-04
 */
@Service
public class FarmerCategoriesServiceImpl implements IFarmerCategoriesService
{
    @Resource
    private FarmerCategoriesMapper farmerCategoriesMapper;

    @Resource
    private FarmerCategoriesMapperExt farmerCategoriesMapperExt;

    /**
     * 查询farmer
     * 
     * @param id farmer主键
     * @return farmer
     */
    @Override
    public FarmerCategories selectFarmerCategoriesById(Long id)
    {
        return farmerCategoriesMapper.selectFarmerCategoriesById(id);
    }

    /**
     * 查询farmer列表
     * 
     * @param farmerCategories farmer
     * @return farmer
     */
    @Override
    public List<FarmerCategories> selectFarmerCategoriesList(FarmerCategories farmerCategories)
    {
        PageUtils.startPage();
        List<FarmerCategories> fasterNodeList = farmerCategoriesMapperExt.selectFarmerCategoriesListByPid(farmerCategories);
        PageUtils.clearPage();
        if (fasterNodeList.size() != 0) {
            List<Long> idList = fasterNodeList.stream().map(FarmerCategories::getId).collect(Collectors.toList());

            List<FarmerCategories> childrenNodeList =farmerCategoriesMapperExt.getChildrenNodes(idList);
            fasterNodeList.forEach(node -> {
                node.setChildren(childrenNodeList.stream().filter(child -> child.getpId().equals(node.getId())).collect(Collectors.toList()));
            });
        }


        return fasterNodeList;
    }

    /**
     * 新增farmer
     * 
     * @param farmerCategories farmer
     * @return 结果
     */
    @Override
    public int insertFarmerCategories(FarmerCategories farmerCategories)
    {
        return farmerCategoriesMapper.insertFarmerCategories(farmerCategories);
    }

    /**
     * 修改farmer
     * 
     * @param farmerCategories farmer
     * @return 结果
     */
    @Override
    public int updateFarmerCategories(FarmerCategories farmerCategories)
    {
        return farmerCategoriesMapper.updateFarmerCategories(farmerCategories);
    }

    /**
     * 批量删除farmer
     * 
     * @param ids 需要删除的farmer主键
     * @return 结果
     */
    @Override
    public int deleteFarmerCategoriesByIds(Long[] ids)
    {

        return farmerCategoriesMapper.deleteFarmerCategoriesByIds(ids);
    }

    /**
     * 删除farmer信息
     * 
     * @param id farmer主键
     * @return 结果
     */
    @Override
    public int deleteFarmerCategoriesById(Long id)
    {

        Integer childrenCount = farmerCategoriesMapperExt.checkChildren(id);
        if (childrenCount > 0) {
            throw new CategoryRemoveNodeException();
        }
        // todo 删除的是子节点 要检查是否背外部引用
        return farmerCategoriesMapper.deleteFarmerCategoriesById(id);
    }
}
