package com.ruoyi.farmer.dto.req;

import java.util.Arrays;
import java.util.List;

/**
 * @author huixh
 */
public class ProductsReq {
    private static final long serialVersionUID = 1L;

    private String productsName;
    private String categoryId;
    private long price;
    private String unit;
    private long stock;
    private long status;
    private String mainImage;
    private List<String> images;
    private long[] origin;
    private long shelfLife;
    private String specification;
    private String storageCondition;
    private String description;
    private long[] features;

    public String getProductsName() {
        return productsName;
    }

    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public long[] getOrigin() {
        return origin;
    }

    public void setOrigin(long[] origin) {
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

    public long[] getFeatures() {
        return features;
    }

    public void setFeatures(long[] features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "ProductsReq{" +
                "productsName='" + productsName + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", stock=" + stock +
                ", status=" + status +
                ", mainImage='" + mainImage + '\'' +
                ", images=" + images +
                ", origin=" + Arrays.toString(origin) +
                ", shelfLife=" + shelfLife +
                ", specification='" + specification + '\'' +
                ", storageCondition='" + storageCondition + '\'' +
                ", description='" + description + '\'' +
                ", features=" + Arrays.toString(features) +
                '}';
    }
}
