package com.ruoyi.farmer.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author huixh
 */
public class FarmerProductsTags {
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 产品id */
    private Long productsId;

    /** 标签id */
    private Long tagsId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProductsId(Long productsId)
    {
        this.productsId = productsId;
    }

    public Long getProductsId()
    {
        return productsId;
    }
    public void setTagsId(Long tagsId)
    {
        this.tagsId = tagsId;
    }

    public Long getTagsId()
    {
        return tagsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("productsId", getProductsId())
                .append("tagsId", getTagsId())
                .toString();
    }
}
