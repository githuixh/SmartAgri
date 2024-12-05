package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.system.domain.SysArea;
import com.ruoyi.system.mapper.SysAreaMapper;
import com.ruoyi.system.service.ISysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huixh
 */
@Service
public class SysAreaServiceImpl implements ISysAreaService {


    @Resource
    private SysAreaMapper sysAreaMapper;

    @Resource
    private RedisCache redisCache;

    /**
     * 获取所有地区
     *
     * @return areas
     */
    @Override
    public List<SysArea> selectAreaList() {
        List<SysArea> cacheList = redisCache.getCacheList(CacheConstants.SYS_AREA_KEY);
        if (cacheList != null && !cacheList.isEmpty()) {
            return cacheList;
        }
        List<SysArea> areas = buildAreaTree(sysAreaMapper.selectAreaList());
        redisCache.setCacheList(CacheConstants.SYS_AREA_KEY, areas);
        return buildAreaTree(areas);
    }

    public List<SysArea> buildAreaTree(List<SysArea> allAreas) {
        Map<Short, SysArea> areaMap = new HashMap<>();
        List<SysArea> rootAreas = new ArrayList<>();

        // 将所有区域按 areaId 存储到一个 map 中
        for (SysArea area : allAreas) {
            areaMap.put(area.getAreaId(), area);
        }

        // 根据 parentId 构建树形结构
        for (SysArea area : allAreas) {
            if (area.getParentId() == 0) {
                rootAreas.add(area); // 根节点（省级）
            } else {
                SysArea parent = areaMap.get(area.getParentId());
                if (parent != null) {
                    parent.getChildren().add(area); // 将区域添加到父节点的 children 列表
                }
            }
        }

        return rootAreas; // 返回构建好的树
    }

    public String buildFullAreaName(SysArea area) {
        StringBuilder fullName = new StringBuilder(area.getAreaName());
        if (area.getChildren() != null && !area.getChildren().isEmpty()) {
            for (SysArea child : area.getChildren()) {
                fullName.append("-").append(buildFullAreaName(child)); // 递归拼接子区域名称
            }
        }
        return fullName.toString();
    }

    public List<String> getFullAreaNames(List<SysArea> rootAreas) {
        List<String> fullAreaNames = new ArrayList<>();
        for (SysArea rootArea : rootAreas) {
            fullAreaNames.add(buildFullAreaName(rootArea)); // 获取完整区域名称
        }
        return fullAreaNames;
    }


}
