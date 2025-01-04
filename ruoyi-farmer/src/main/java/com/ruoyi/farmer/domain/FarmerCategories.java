package com.ruoyi.farmer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * farmer对象 farmer_categories
 * 
 * @author ruoyi
 * @date 2025-01-04
 */
public class FarmerCategories extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 分类名称 */
    private String name;

    /** 上层id */
    private Long pId;

    /** 状态 0 启用 1 为启用 */
    private String status;

    /**  */
    private String description;

    /** 排序顺序 */
    private Long orderNum;

    private List<FarmerCategories> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public List<FarmerCategories> getChildren() {
        return children;
    }

    public void setChildren(List<FarmerCategories> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("pId", getpId())
                .append("status", getStatus())
                .append("children", getChildren())
                .append("description", getDescription())
                .append("orderNum", getOrderNum())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("remark", getRemark())
                .toString();
    }
}
