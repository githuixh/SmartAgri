package com.ruoyi.farmer.service;

import java.util.List;
import com.ruoyi.farmer.domain.FarmerAuthentication;
import com.ruoyi.farmer.dto.req.FarmerAuditReq;
import com.ruoyi.farmer.dto.req.FarmerAuthReq;
import com.ruoyi.farmer.dto.resp.FarmerAuthStatusResp;

/**
 * 农商用户认证Service接口
 *
 * @author ruoyi
 * @date 2024-11-30
 */
public interface IFarmerAuthenticationService
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
    public int insertFarmerAuthentication(FarmerAuthReq farmerAuthentication);

    /**
     * 修改农商用户认证
     *
     * @param farmerAuthentication 农商用户认证
     * @return 结果
     */
    public int updateFarmerAuthentication(FarmerAuthentication farmerAuthentication);

    /**
     * 批量删除农商用户认证
     *
     * @param ids 需要删除的农商用户认证主键集合
     * @return 结果
     */
    public int deleteFarmerAuthenticationByIds(Long[] ids);

    /**
     * 删除农商用户认证信息
     *
     * @param id 农商用户认证主键
     * @return 结果
     */
    public int deleteFarmerAuthenticationById(Long id);

    /**
     * 更改当前审核状态
     *
     * @param farmerAuditReq
     */
    public void updateStatus(FarmerAuditReq farmerAuditReq);

    public FarmerAuthStatusResp getAuthStatus();
}
