package com.ruoyi.web.controller.farmer;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.farmer.dto.req.AuditReq;
import com.ruoyi.farmer.dto.req.FarmerAuthReq;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.farmer.domain.FarmerAuthentication;
import com.ruoyi.farmer.service.IFarmerAuthenticationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 农商用户认证Controller
 *
 * @author ruoyi
 * @date 2024-11-30
 */
@Api(tags = "农商用户认证")
@RestController
@RequestMapping("/farmer/auth")
public class FarmerAuthenticationController extends BaseController
{
    @Autowired
    private IFarmerAuthenticationService farmerAuthenticationService;

    /**
     * 查询农商用户认证列表
     */
    @PreAuthorize("@ss.hasPermi('farmer:auth:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmerAuthentication farmerAuthentication)
    {
        startPage();
        List<FarmerAuthentication> list = farmerAuthenticationService.selectFarmerAuthenticationList(farmerAuthentication);
        return getDataTable(list);
    }

    /**
     * 导出农商用户认证列表
     */
    @PreAuthorize("@ss.hasPermi('farmer:auth:export')")
    @Log(title = "农商用户认证", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmerAuthentication farmerAuthentication)
    {
        List<FarmerAuthentication> list = farmerAuthenticationService.selectFarmerAuthenticationList(farmerAuthentication);
        ExcelUtil<FarmerAuthentication> util = new ExcelUtil<FarmerAuthentication>(FarmerAuthentication.class);
        util.exportExcel(response, list, "农商用户认证数据");
    }

    /**
     * 获取农商用户认证详细信息
     */
    @PreAuthorize("@ss.hasPermi('farmer:auth:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmerAuthenticationService.selectFarmerAuthenticationById(id));
    }

    /**
     * 新增农商用户认证
     */
    @PreAuthorize("@ss.hasPermi('farmer:auth:add')")
    @Log(title = "农商用户认证", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmerAuthReq farmerAuthentication)
    {
        return toAjax(farmerAuthenticationService.insertFarmerAuthentication(farmerAuthentication));
    }

    /**
     * 修改农商用户认证
     */
    @PreAuthorize("@ss.hasPermi('farmer:auth:edit')")
    @Log(title = "农商用户认证", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmerAuthentication farmerAuthentication)
    {
        return toAjax(farmerAuthenticationService.updateFarmerAuthentication(farmerAuthentication));
    }

    /**
     * 删除农商用户认证
     */
    @PreAuthorize("@ss.hasPermi('farmer:auth:remove')")
    @Log(title = "农商用户认证", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmerAuthenticationService.deleteFarmerAuthenticationByIds(ids));
    }

    /**
     * 更改审核状态
     * @param auditReq  auditReq
     */
    @PostMapping("/audit")
    @PreAuthorize("@ss.hasPermi('farmer:auth:list')")
    @Log(title = "农商用户认证审核", businessType = BusinessType.UPDATE)
    public AjaxResult updateStatus(@RequestBody AuditReq auditReq){
        farmerAuthenticationService.updateStatus(auditReq);
        return success();
    }

    /**
     * 获得当前审核状态
     */
    @PreAuthorize("@ss.hasPermi('farmer:auth:reportInfo')")
    @GetMapping("/getAuthStatus")
    public AjaxResult isAwaitAuth(){
        return AjaxResult.success(farmerAuthenticationService.getAuthStatus());
    }
}