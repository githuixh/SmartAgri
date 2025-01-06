package com.ruoyi.web.controller.common;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.ISysAreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统地址树请求
 * @author huixh
 */
@RestController
@RequestMapping("/system/common/area")
public class SysAreaController extends BaseController {

    @Resource
    private ISysAreaService areaService;
    @Anonymous
    @GetMapping("/list")
    public AjaxResult getAreaList() {
        return AjaxResult.success(areaService.selectAreaList());
    }

}
