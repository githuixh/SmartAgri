package com.ruoyi.farmer.domain;


/**
 * @author huixh
 */
public class FarmerProductsImages
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long productId;

    private String imageUrl;

    private Long imageOrder;

    private String isPrimary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(Long imageOrder) {
        this.imageOrder = imageOrder;
    }

    public String getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    @Override
    public String toString() {
        return "FarmerProductsImages{" +
                "id=" + id +
                ", productId=" + productId +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageOrder=" + imageOrder +
                ", isPrimary='" + isPrimary + '\'' +
                "} " + super.toString();
    }
}