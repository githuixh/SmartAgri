package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysArea;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huixh
 */
public interface ISysAreaService {
    /**
     * 获取所有地区
     * @return areas
     */
    List<SysArea> selectAreaList();
}
