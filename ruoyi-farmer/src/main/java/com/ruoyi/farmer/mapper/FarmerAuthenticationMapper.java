package com.ruoyi.farmer.mapper;

import java.util.List;
import com.ruoyi.farmer.domain.FarmerAuthentication;

/**
 * 农商用户认证Mapper接口
 *
 * @author ruoyi
 * @date 2024-11-30
 */
public interface FarmerAuthenticationMapper
{
    /**
     * 查询农商用户认证
     *
     * @param id 农商用户认证主键
     * @return 农商用户认证
     */
    public FarmerAuthentication selectFarmerAuthenticationById(Long id);

    /**
     * 查询农商用户认证列表
     *
     * @param farmerAuthentication 农商用户认证
     * @return 农商用户认证集合
     */
    public List<FarmerAuthentication> selectFarmerAuthenticationList(FarmerAuthentication farmerAuthentication);

    /**
     * 新增农商用户认证
     *
     * @param farmerAuthentication 农商用户认证
     * @return 结果
     */
    public int insertFarmerAuthentication(FarmerAuthentication farmerAuthentication);

    /**
     * 修改农商用户认证
     *
     * @param farmerAuthentication 农商用户认证
     * @return 结果
     */
    public int updateFarmerAuthentication(FarmerAuthentication farmerAuthentication);

    /**
     * 删除农商用户认证
     *
     * @param id 农商用户认证主键
     * @return 结果
     */
    public int deleteFarmerAuthenticationById(Long id);

    /**
     * 批量删除农商用户认证
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmerAuthenticationByIds(Long[] ids);

}
