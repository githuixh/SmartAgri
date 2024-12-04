package com.ruoyi.farmer.dto.req;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.List;

/**
 * 农户认证请求对象
 * @author huixh
 */
public class FarmerAuthReq {
    private static final long serialVersionUID = 1L;

    /** 主键，唯一标识 */
    private Long id;

    /** 存储姓名 */
    private String realName;

    /** 联系方式 */
    private String phone;

    /** 身份证号 */
    private String idCardNumber;

    /** 身份证正面照片路径 */
    private String idCardImageFront;

    /** 身份证反面照片路径 */
    private String idCardImageBack;

    /** 农场名称 */
    private String farmName;

    /** 农场面积(亩) */
    private BigDecimal farmArea;

    /** 农场执照编号 */
    private String farmLicense;

    /** 种植年限 */
    private Integer farmingYears;

    /** 所在地区 */
    private List<String> farmRegion;

    /** 详细地址 */
    private String farmAddress;

    /** 主要种植作物 */
    private List<String> mainCrops;

    /** 农场实景照片 */
    private List<String> farmPhotos;

    /** 其他证明材料 */
    private List<String> otherDocs;

    /** 认证状态：0 待审核、1已通过、2已拒绝 */
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

    public void setFarmRegion(List<String> farmRegion) {
        this.farmRegion = farmRegion;
    }

    public List<String> getFarmRegion() {
        return farmRegion;
    }

    public void setFarmAddress(String farmAddress) {
        this.farmAddress = farmAddress;
    }

    public String getFarmAddress() {
        return farmAddress;
    }

    public void setMainCrops(List<String> mainCrops) {
        this.mainCrops = mainCrops;
    }

    public List<String> getMainCrops() {
        return mainCrops;
    }

    public void setFarmPhotos(List<String> farmPhotos) {
        this.farmPhotos = farmPhotos;
    }

    public List<String> getFarmPhotos() {
        return farmPhotos;
    }

    public void setOtherDocs(List<String> otherDocs) {
        this.otherDocs = otherDocs;
    }

    public List<String> getOtherDocs() {
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
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
                .toString();
    }
}