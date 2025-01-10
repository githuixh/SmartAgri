package com.ruoyi.farmer.dto.resp;

import com.ruoyi.farmer.domain.FarmerProductsImages;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author huixh
 */
public class FarmerProductsResp {
    private static final long serialVersionUID = 1L;

    private String productsName;
    private Long categoryId;
    private BigDecimal price;
    private String unit;
    private long stock;
    private String status;
    private String mainImage;
    private List<FarmerProductsImages> images;
    private List<Long> origin;
    private long shelfLife;
    private String specification;
    private String storageCondition;
    private String description;
    private List<Long> features;

    public FarmerProductsResp() {
    }

    public FarmerProductsResp(String productsName, Long categoryId, BigDecimal price, String unit, long stock, String status, String mainImage, List<FarmerProductsImages> images, List<Long> origin, long shelfLife, String specification, String storageCondition, String description, List<Long> features) {
        this.productsName = productsName;
        this.categoryId = categoryId;
        this.price = price;
        this.unit = unit;
        this.stock = stock;
        this.status = status;
        this.mainImage = mainImage;
        this.images = images;
        this.origin = origin;
        this.shelfLife = shelfLife;
        this.specification = specification;
        this.storageCondition = storageCondition;
        this.description = description;
        this.features = features;
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

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<FarmerProductsImages> getImages() {
        return images;
    }

    public void setImages(List<FarmerProductsImages> images) {
        this.images = images;
    }

    public List<Long> getOrigin() {
        return origin;
    }

    public void setOrigin(List<Long> origin) {
        this.origin = origin;
    }

    public long getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(long shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getFeatures() {
        return features;
    }

    public void setFeatures(List<Long> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "FarmerProductsResp{" +
                "productsName='" + productsName + '\'' +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", stock=" + stock +
                ", status=" + status +
                ", mainImage='" + mainImage + '\'' +
                ", images=" + images +
                ", origin=" + origin +
                ", shelfLife=" + shelfLife +
                ", specification='" + specification + '\'' +
                ", storageCondition='" + storageCondition + '\'' +
                ", description='" + description + '\'' +
                ", features=" + features +
                '}';
    }
}
