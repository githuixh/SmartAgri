package com.ruoyi.system.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 地区实体类
 * @author huixh
 */
public class SysArea {
    private short areaId;

    private short parentId;

    private String areaName;

    private List<SysArea> children = new ArrayList<>();

    public short getAreaId() {
        return areaId;
    }

    public void setAreaId(short areaId) {
        this.areaId = areaId;
    }

    public short getParentId() {
        return parentId;
    }

    public void setParentId(short parentId) {
        this.parentId = parentId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<SysArea> getChildren() {
        return children;
    }

    public void setChildren(List<SysArea> children) {
        this.children = children;
    }
}
