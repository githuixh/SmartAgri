package com.ruoyi.web.controller.farmer;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.farmer.domain.FarmerProducts;
import com.ruoyi.farmer.dto.req.FarmerProductsReq;
import com.ruoyi.farmer.service.IFarmerProductsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * productsController
 *
 * @author huixh
 * @date 2025-01-05
 */
@Api
@RestController
@RequestMapping("/farmer/products")
public class FarmerProductsController extends BaseController {

    @Resource
    private IFarmerProductsService farmerProductsService;

    /**
     * 查询商品列表
     */
    @ApiOperation(value = "商品列表")
    @PreAuthorize("@ss.hasPermi('farmer:products:list')")
    @GetMapping("/list")
    public TableDataInfo list(FarmerProducts farmerProducts)
    {
        //startPage();
        List<FarmerProducts> list = farmerProductsService.selectFarmerProductsList(farmerProducts);
        return getDataTable(list);
    }

    /**
     * 导出products列表
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:export')")
    @Log(title = "products", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmerProducts farmerProducts)
    {
        List<FarmerProducts> list = farmerProductsService.selectFarmerProductsList(farmerProducts);
        ExcelUtil<FarmerProducts> util = new ExcelUtil<FarmerProducts>(FarmerProducts.class);
        util.exportExcel(response, list, "products数据");
    }

    /**
     * 获取products详细信息
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(farmerProductsService.selectFarmerProductsById(id));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:add')")
    @Log(title = "products", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmerProductsReq farmerProducts)
    {
        farmerProductsService.insertFarmerProductsInfo(farmerProducts);
        return toAjax(true);
    }

    /**
     * 修改products
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:edit')")
    @Log(title = "products", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmerProducts farmerProducts)
    {
        return toAjax(farmerProductsService.updateFarmerProducts(farmerProducts));
    }

    /**
     * 删除products
     */
    @PreAuthorize("@ss.hasPermi('farmer:products:remove')")
    @Log(title = "products", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(farmerProductsService.deleteFarmerProductsByIds(ids));
    }
}
