package com.ruoyi.farmer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 农商用户认证对象 farmer_authentication
 *
 * @author ruoyi
 * @date 2024-11-30
 */
public class FarmerAuthentication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键，唯一标识	 */
    private Long id;

    /** 关联当前用户登录信息 */
    @Excel(name = "关联当前用户登录信息")
    private Long userId;

    /** 存储姓名 */
    @Excel(name = "存储姓名")
    private String realName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String idCardNumber;

    /** 身份证正面照片路径 */
    @Excel(name = "身份证正面照片路径")
    private String idCardImageFront;

    /** 身份证反面照片路径 */
    @Excel(name = "身份证反面照片路径")
    private String idCardImageBack;

    /** 农场名称 */
    @Excel(name = "农场名称")
    private String farmName;

    /** 农场执照编号（可选） */
    @Excel(name = "农场执照编号", readConverterExp = "可=选")
    private String farmLicense;

    /** 认证状态：0 待审核、1已通过、2已拒绝 */
    @Excel(name = "认证状态：0 待审核、1已通过、2已拒绝")
    private String authStatus;

    /** 如果认证失败，存储拒绝原因 */
    @Excel(name = "如果认证失败，存储拒绝原因")
    private String rejectionReason;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getRealName()
    {
        return realName;
    }
    public void setIdCardNumber(String idCardNumber)
    {
        this.idCardNumber = idCardNumber;
    }

    public String getIdCardNumber()
    {
        return idCardNumber;
    }
    public void setIdCardImageFront(String idCardImageFront)
    {
        this.idCardImageFront = idCardImageFront;
    }

    public String getIdCardImageFront()
    {
        return idCardImageFront;
    }
    public void setIdCardImageBack(String idCardImageBack)
    {
        this.idCardImageBack = idCardImageBack;
    }

    public String getIdCardImageBack()
    {
        return idCardImageBack;
    }
    public void setFarmName(String farmName)
    {
        this.farmName = farmName;
    }

    public String getFarmName()
    {
        return farmName;
    }
    public void setFarmLicense(String farmLicense)
    {
        this.farmLicense = farmLicense;
    }

    public String getFarmLicense()
    {
        return farmLicense;
    }
    public void setAuthStatus(String authStatus)
    {
        this.authStatus = authStatus;
    }

    public String getAuthStatus()
    {
        return authStatus;
    }
    public void setRejectionReason(String rejectionReason)
    {
        this.rejectionReason = rejectionReason;
    }

    public String getRejectionReason()
    {
        return rejectionReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("realName", getRealName())
                .append("idCardNumber", getIdCardNumber())
                .append("idCardImageFront", getIdCardImageFront())
                .append("idCardImageBack", getIdCardImageBack())
                .append("farmName", getFarmName())
                .append("farmLicense", getFarmLicense())
                .append("authStatus", getAuthStatus())
                .append("rejectionReason", getRejectionReason())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
