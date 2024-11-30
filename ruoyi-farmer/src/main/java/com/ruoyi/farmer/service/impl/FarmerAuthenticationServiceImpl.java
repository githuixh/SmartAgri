package com.ruoyi.farmer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.farmer.constant.FarmerAuthStatus;
import org.springframework.stereotype.Service;
import com.ruoyi.farmer.mapper.FarmerAuthenticationMapper;
import com.ruoyi.farmer.domain.FarmerAuthentication;
import com.ruoyi.farmer.service.IFarmerAuthenticationService;

import javax.annotation.Resource;

/**
 * 农商用户认证Service业务层处理
 *
 * @author ruoyi
 * @date 2024-11-30
 */
@Service
public class FarmerAuthenticationServiceImpl implements IFarmerAuthenticationService
{
    @Resource
    private FarmerAuthenticationMapper farmerAuthenticationMapper;

    /**
     * 查询农商用户认证
     *
     * @param id 农商用户认证主键
     * @return 农商用户认证
     */
    @Override
    public FarmerAuthentication selectFarmerAuthenticationById(Long id)
    {
        return farmerAuthenticationMapper.selectFarmerAuthenticationById(id);
    }

    /**
     * 查询农商用户认证列表
     *
     * @param farmerAuthentication 农商用户认证
     * @return 农商用户认证
     */
    @Override
    public List<FarmerAuthentication> selectFarmerAuthenticationList(FarmerAuthentication farmerAuthentication)
    {
        return farmerAuthenticationMapper.selectFarmerAuthenticationList(farmerAuthentication);
    }

    /**
     * 新增农商用户认证
     *
     * @param farmerAuthentication 农商用户认证
     * @return 结果
     */
    @Override
    public int insertFarmerAuthentication(FarmerAuthentication farmerAuthentication)
    {
        farmerAuthentication.setCreateTime(DateUtils.getNowDate());
        Long userId = SecurityUtils.getUserId();
        farmerAuthentication.setUserId(userId);
        farmerAuthentication.setAuthStatus(FarmerAuthStatus.PENDING);
        return farmerAuthenticationMapper.insertFarmerAuthentication(farmerAuthentication);
    }

    /**
     * 修改农商用户认证
     *
     * @param farmerAuthentication 农商用户认证
     * @return 结果
     */
    @Override
    public int updateFarmerAuthentication(FarmerAuthentication farmerAuthentication)
    {
        farmerAuthentication.setUpdateTime(DateUtils.getNowDate());
        return farmerAuthenticationMapper.updateFarmerAuthentication(farmerAuthentication);
    }

    /**
     * 批量删除农商用户认证
     *
     * @param ids 需要删除的农商用户认证主键
     * @return 结果
     */
    @Override
    public int deleteFarmerAuthenticationByIds(Long[] ids)
    {
        return farmerAuthenticationMapper.deleteFarmerAuthenticationByIds(ids);
    }

    /**
     * 删除农商用户认证信息
     *
     * @param id 农商用户认证主键
     * @return 结果
     */
    @Override
    public int deleteFarmerAuthenticationById(Long id)
    {
        return farmerAuthenticationMapper.deleteFarmerAuthenticationById(id);
    }
}
