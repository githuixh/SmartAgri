package com.ruoyi.farmer.mapper;

import com.ruoyi.farmer.domain.FarmerAuthentication;

/**
 * @author huixh
 */
public interface FarmerAuthenticationMapperExt {
    /**
     * 根据userId查询 认证信息
     * @param userId userId
     * @return FarmerAuthentication
     */
    public FarmerAuthentication selectFarmerAuthenticationByUserId(Long userId);
}
