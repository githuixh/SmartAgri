package com.ruoyi.farmer.dto.req;

/**
 * 审核请求参数
 * @author huixh
 */
public class AuditReq {
    private Long id;

    private String auditStatus;
    private String auditReason;

    public AuditReq() {
    }

    public AuditReq(Long id, String auditStatus, String auditReason) {
        this.id = id;
        this.auditStatus = auditStatus;
        this.auditReason = auditReason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason;
    }

    @Override
    public String toString() {
        return "AuditReq{" +
                "id=" + id +
                ", auditStatus='" + auditStatus + '\'' +
                ", auditReason='" + auditReason + '\'' +
                '}';
    }
}
