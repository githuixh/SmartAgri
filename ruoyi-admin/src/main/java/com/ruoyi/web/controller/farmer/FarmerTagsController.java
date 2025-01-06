package com.ruoyi.web.controller.farmer;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.farmer.domain.FarmerTags;
import com.ruoyi.farmer.service.IFarmerTagsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author huixh
 */
@Api
@RestController
@RequestMapping("/farmer/tags")
public class FarmerTagsController extends BaseController
{
    @Resource
    private IFarmerTagsService farmerTagsService;

    /**
     * 查询商品标签列表
     */
    // @PreAuthorize("@ss.hasPermi('farmer:farmer:list')")
    @ApiOperation(value = "商品标签列表")
    @GetMapping("/list")
    public AjaxResult list(FarmerTags farmerTags)
    {
        List<FarmerTags> list = farmerTagsService.selectFarmerTagsList(farmerTags);
        return success(list);
    }

    /**
     * 导出商品标签列表
     */
    // @PreAuthorize("@ss.hasPermi('farmer:farmer:export')")
    @ApiOperation(value = "商品标签导出")
    @Log(title = "商品标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmerTags farmerTags)
    {
        List<FarmerTags> list = farmerTagsService.selectFarmerTagsList(farmerTags);
        ExcelUtil<FarmerTags> util = new ExcelUtil<FarmerTags>(FarmerTags.class);
        util.exportExcel(response, list, "商品标签数据");
    }

    /**
     * 获取商品标签详细信息
     */
    // @PreAuthorize("@ss.hasPermi('farmer:farmer:query')")
    @ApiOperation(value = "商品标签详情")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmerTagsService.selectFarmerTagsById(id));
    }

    /**
     * 新增商品标签
     */
    // @PreAuthorize("@ss.hasPermi('farmer:farmer:add')")
    @ApiOperation(value = "商品标签新增")
    @Log(title = "商品标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmerTags farmerTags)
    {
        return toAjax(farmerTagsService.insertFarmerTags(farmerTags));
    }

    /**
     * 修改商品标签
     */
    // @PreAuthorize("@ss.hasPermi('farmer:farmer:edit')")
    @Log(title = "商品标签", businessType = BusinessType.UPDATE)
    @ApiOperation(value = "商品标签修改")
    @PutMapping
    public AjaxResult edit(@RequestBody FarmerTags farmerTags)
    {
        return toAjax(farmerTagsService.updateFarmerTags(farmerTags));
    }

    /**
     * 删除商品标签
     */
    // @PreAuthorize("@ss.hasPermi('farmer:farmer:remove')")
    @ApiOperation(value = "商品标签删除")
    @Log(title = "商品标签", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmerTagsService.deleteFarmerTagsByIds(ids));
    }
}