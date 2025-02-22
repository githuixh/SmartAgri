package com.ruoyi.farmer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 农商用户认证对象 farmer_authentication
 *
 * @author ruoyi
 * @date 2024-03-21
 */
public class FarmerAuthentication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键，唯一标识 */
    private Long id;

    /** 关联当前用户登录信息 */
    @Excel(name = "关联用户ID")
    private Long userId;

    /** 存储姓名 */
    @Excel(name = "姓名")
    private String realName;

    /** 联系方式 */
    @Excel(name = "联系电话")
    private String phone;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCardNumber;

    /** 身份证正面照片路径 */
    @Excel(name = "身份证正面照片")
    private String idCardImageFront;

    /** 身份证反面照片路径 */
    @Excel(name = "身份证反面照片")
    private String idCardImageBack;

    /** 农场名称 */
    @Excel(name = "农场名称")
    private String farmName;

    /** 农场面积(亩) */
    @Excel(name = "农场面积(亩)")
    private BigDecimal farmArea;

    /** 农场执照编号 */
    @Excel(name = "农场执照编号")
    private String farmLicense;

    /** 种植年限 */
    @Excel(name = "种植年限")
    private Integer farmingYears;

    /** 所在地区 */
    @Excel(name = "所在地区")
    private String farmRegion;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String farmAddress;

    /** 主要种植作物 */
    @Excel(name = "主要种植作物")
    private String mainCrops;

    /** 农场实景照片 */
    private String farmPhotos;

    /** 其他证明材料 */
    private String otherDocs;

    /** 认证状态：0 待审核、1已通过、2已拒绝 */
    @Excel(name = "认证状态", readConverterExp = "0=待审核,1=已通过,2=已拒绝")
    private String authStatus;

    /** 拒绝原因 */
    @Excel(name = "拒绝原因")
    private String rejectionReason;

    // getter和setter方法
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardImageFront(String idCardImageFront) {
        this.idCardImageFront = idCardImageFront;
    }

    public String getIdCardImageFront() {
        return idCardImageFront;
    }

    public void setIdCardImageBack(String idCardImageBack) {
        this.idCardImageBack = idCardImageBack;
    }

    public String getIdCardImageBack() {
        return idCardImageBack;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmArea(BigDecimal farmArea) {
        this.farmArea = farmArea;
    }

    public BigDecimal getFarmArea() {
        return farmArea;
    }

    public void setFarmLicense(String farmLicense) {
        this.farmLicense = farmLicense;
    }

    public String getFarmLicense() {
        return farmLicense;
    }

    public void setFarmingYears(Integer farmingYears) {
        this.farmingYears = farmingYears;
    }

    public Integer getFarmingYears() {
        return farmingYears;
    }

    public void setFarmRegion(String farmRegion) {
        this.farmRegion = farmRegion;
    }

    public String getFarmRegion() {
        return farmRegion;
    }

    public void setFarmAddress(String farmAddress) {
        this.farmAddress = farmAddress;
    }

    public String getFarmAddress() {
        return farmAddress;
    }

    public void setMainCrops(String mainCrops) {
        this.mainCrops = mainCrops;
    }

    public String getMainCrops() {
        return mainCrops;
    }

    public void setFarmPhotos(String farmPhotos) {
        this.farmPhotos = farmPhotos;
    }

    public String getFarmPhotos() {
        return farmPhotos;
    }

    public void setOtherDocs(String otherDocs) {
        this.otherDocs = otherDocs;
    }

    public String getOtherDocs() {
        return otherDocs;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("realName", getRealName())
                .append("phone", getPhone())
                .append("idCardNumber", getIdCardNumber())
                .append("idCardImageFront", getIdCardImageFront())
                .append("idCardImageBack", getIdCardImageBack())
                .append("farmName", getFarmName())
                .append("farmArea", getFarmArea())
                .append("farmLicense", getFarmLicense())
                .append("farmingYears", getFarmingYears())
                .append("farmRegion", getFarmRegion())
                .append("farmAddress", getFarmAddress())
                .append("mainCrops", getMainCrops())
                .append("farmPhotos", getFarmPhotos())
                .append("otherDocs", getOtherDocs())
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