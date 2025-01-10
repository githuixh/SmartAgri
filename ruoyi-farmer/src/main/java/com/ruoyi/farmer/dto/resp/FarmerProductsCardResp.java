package com.ruoyi.farmer.dto.resp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 页面卡片展示 resp
 * @author huixh
 */
public class FarmerProductsCardResp {
    private Long id;

    // 商品名称
    private String productsName;

    // 首图
    private String mainImage;

    // 状态
    private String status;

    // 价格
    private BigDecimal price;

    // 库存
    private Long stock;

    // 计量单位
    private String unit;

    // 商品描述
    private String description;

    List<String> features = new ArrayList<>();

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

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
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

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "FarmerProductsCardResp{" +
                "id=" + id +
                ", productsName='" + productsName + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                ", features=" + features +
                '}';
    }
}
