package com.ruoyi.farmer.dto.resp;

/**
 * 审核状态
 * @author huixh
 */
public class FarmerAuthStatusResp {
    // 状态
    private String authStatus;
    // 描述
    private String rejectionReason;
    // 申请时间
    private String createTime;

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
