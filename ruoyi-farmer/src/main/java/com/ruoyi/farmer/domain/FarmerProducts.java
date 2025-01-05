package com.ruoyi.farmer.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

    /** 农产品的价格， */
    @Excel(name = "农产品的价格，")
    private BigDecimal price;

    /** 农产品的库存数量，必填 */
    @Excel(name = "农产品的库存数量，必填")
    private Long stock;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProductsName(String productsName)
    {
        this.productsName = productsName;
    }

    public String getProductsName()
    {
        return productsName;
    }
    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setStock(Long stock)
    {
        this.stock = stock;
    }

    public Long getStock()
    {
        return stock;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("productsName", getProductsName())
                .append("categoryId", getCategoryId())
                .append("description", getDescription())
                .append("price", getPrice())
                .append("stock", getStock())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .toString();
    }
}
