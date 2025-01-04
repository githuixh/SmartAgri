package com.ruoyi.web.controller.farmer;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.farmer.domain.FarmerCategories;
import com.ruoyi.farmer.service.IFarmerCategoriesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * farmerController
 * 
 * @author ruoyi
 * @date 2025-01-04
 */
@Api
@RestController
@RequestMapping("/farmer/products")
public class FarmerCategoriesController extends BaseController
{
    @Resource
    private IFarmerCategoriesService farmerCategoriesService;

    /**
     * 查询产品分裂列表
     */
    @ApiOperation(value = "查询产品分类列表")
    @PreAuthorize("@ss.hasPermi('farmer:products:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmerCategories farmerCategories)
    {
        // startPage();
        List<FarmerCategories> list = farmerCategoriesService.selectFarmerCategoriesList(farmerCategories);
        return getDataTable(list);
    }

    @ApiOperation(value = "查询产品分页面详情数据")
    @PreAuthorize("@ss.hasPermi('farmer:products:query')")
    @GetMapping("/info")
    public AjaxResult getFarmerCategoriesInfo(){
        // 查询本月新增
        // 已关联产品
        // todo 后期在做
        return success();
    }
    /**
     * 导出farmer列表
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:export')")
    @Log(title = "farmer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmerCategories farmerCategories)
    {
        List<FarmerCategories> list = farmerCategoriesService.selectFarmerCategoriesList(farmerCategories);
        ExcelUtil<FarmerCategories> util = new ExcelUtil<FarmerCategories>(FarmerCategories.class);
        util.exportExcel(response, list, "farmer数据");
    }

    /**
     * 获取farmer详细信息
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmerCategoriesService.selectFarmerCategoriesById(id));
    }

    /**
     * 新增farmer
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:add')")
    @Log(title = "farmer", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmerCategories farmerCategories)
    {
        return toAjax(farmerCategoriesService.insertFarmerCategories(farmerCategories));
    }

    /**
     * 修改farmer
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:edit')")
    @Log(title = "farmer", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmerCategories farmerCategories)
    {
        return toAjax(farmerCategoriesService.updateFarmerCategories(farmerCategories));
    }

    /**
     * 删除farmer
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:remove')")
    @Log(title = "farmer", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmerCategoriesService.deleteFarmerCategoriesByIds(ids));
    }
}
