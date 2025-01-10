package com.ruoyi.farmer.service.impl;

import java.util.List;
import java.util.Objects;

import com.alibaba.druid.support.json.JSONUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.farmer.constant.FarmerAuthStatus;
import com.ruoyi.farmer.dto.req.FarmerAuditReq;
import com.ruoyi.farmer.dto.req.FarmerAuthReq;
import com.ruoyi.farmer.dto.resp.FarmerAuthStatusResp;
import com.ruoyi.farmer.mapper.FarmerAuthenticationMapperExt;
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

    @Resource
    private FarmerAuthenticationMapperExt farmerAuthenticationMapperExt;

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
    public int insertFarmerAuthentication(FarmerAuthReq farmerAuthentication)
    {
        FarmerAuthentication authentication = new FarmerAuthentication();
        BeanUtils.copyBeanProp(authentication, farmerAuthentication);
        authentication.setCreateTime(DateUtils.getNowDate());
        authentication.setUserId(SecurityUtils.getUserId());
        // 将地址转为 字符串
        String farmRegionJsonStr = JSONUtils.toJSONString(farmerAuthentication.getFarmRegion());
        authentication.setFarmRegion(farmRegionJsonStr);
        authentication.setAuthStatus(FarmerAuthStatus.PENDING);
        // 将环境照片文件转为 json 字符串
        String farmPhotosJsonStr = JSONUtils.toJSONString(farmerAuthentication.getFarmPhotos());
        authentication.setFarmPhotos(farmPhotosJsonStr);
        // 主要作物 转为 json
        String mainCropsJsonStr = JSONUtils.toJSONString(farmerAuthentication.getMainCrops());
        authentication.setMainCrops(mainCropsJsonStr);
        // 其他文件 转为 json
        String otherDocsJsonStr = JSONUtils.toJSONString(farmerAuthentication.getOtherDocs());
        authentication.setOtherDocs(otherDocsJsonStr);

        return farmerAuthenticationMapper.insertFarmerAuthentication(authentication);
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

    /**
     * 更改当前审核状态
     *
     * @param farmerAuditReq
     */
    @Override
    public void updateStatus(FarmerAuditReq farmerAuditReq) {
        Long auditReqId = farmerAuditReq.getId();
        FarmerAuthentication farmerAuthentication = farmerAuthenticationMapper.selectFarmerAuthenticationById(auditReqId);
        farmerAuthentication.setAuthStatus(farmerAuditReq.getAuditStatus());
        if (! "".equals(farmerAuditReq.getAuditReason())) {
            farmerAuthentication.setRejectionReason(farmerAuditReq.getAuditReason());
        }

        farmerAuthenticationMapper.updateFarmerAuthentication(farmerAuthentication);
    }

    @Override
    public FarmerAuthStatusResp getAuthStatus() {
        FarmerAuthStatusResp farmerAuthStatusResp = new FarmerAuthStatusResp();
        // 获取当前 登录用户 id
        Long userId = SecurityUtils.getUserId();
        FarmerAuthentication farmerAuthentication = farmerAuthenticationMapperExt.selectFarmerAuthenticationByUserId(userId);
        if (Objects.isNull(farmerAuthentication)) {
            farmerAuthStatusResp.setAuthStatus(FarmerAuthStatus.NOT_APPLY);
            return farmerAuthStatusResp;
        }
        farmerAuthStatusResp.setAuthStatus(farmerAuthentication.getAuthStatus());
        farmerAuthStatusResp.setCreateTime(DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", farmerAuthentication.getCreateTime()));
        farmerAuthStatusResp.setRejectionReason(farmerAuthentication.getRejectionReason());
        return farmerAuthStatusResp;
    }
}
