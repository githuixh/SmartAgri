package com.ruoyi.farmer.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * @author huixh
 */
public class FarmerProducts extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String productsName;

    /** 分类id */
    private Long categoryId;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String description;

    /** 0 下架 1 上架 2 审核 */
    @Excel(name = "0 下架 1 上架 2 审核")
    private String status;

    /** 农产品的价格， */
    @Excel(name = "农产品的价格，")
    private BigDecimal price;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String unit;

    /** 农产品的库存数量，必填 */
    @Excel(name = "农产品的库存数量，必填")
    private Long stock;

    /** 主图片 */
    @Excel(name = "主图片")
    private String mainImage;

    /** 储藏条件 */
    @Excel(name = "储藏条件")
    private String storageCondition;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 保质期/月 */
    @Excel(name = "保质期/月")
    private Long shelfLife;

    /** 产地 */
    @Excel(name = "产地")
    private String origin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Long getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Long shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "FarmerProducts{" +
                "id=" + id +
                ", productsName='" + productsName + '\'' +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", stock=" + stock +
                ", mainImage='" + mainImage + '\'' +
                ", storageCondition='" + storageCondition + '\'' +
                ", specification='" + specification + '\'' +
                ", shelfLife=" + shelfLife +
                ", origin='" + origin + '\'' +
                "} " + super.toString();
    }
}
