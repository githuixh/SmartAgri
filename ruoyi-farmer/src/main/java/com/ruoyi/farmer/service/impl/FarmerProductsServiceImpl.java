package com.ruoyi.farmer.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.farmer.domain.FarmerProducts;
import com.ruoyi.farmer.domain.FarmerProductsImages;
import com.ruoyi.farmer.domain.FarmerProductsTags;
import com.ruoyi.farmer.domain.FarmerTags;
import com.ruoyi.farmer.dto.req.FarmerProductsReq;
import com.ruoyi.farmer.dto.resp.FarmerProductsCardResp;
import com.ruoyi.farmer.dto.resp.FarmerProductsResp;
import com.ruoyi.farmer.mapper.*;
import com.ruoyi.farmer.service.IFarmerProductsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author huixh
 */
@Service
public class FarmerProductsServiceImpl implements IFarmerProductsService {

    @Resource
    private FarmerProductsMapper farmerProductsMapper;

    @Resource
    private FarmerProductsTagsMapperExt farmerProductsTagsMapperExt;

    @Resource
    private FarmerTagsMapper farmerTagsMapper;

    @Resource
    private FarmerProductsImagesMapper farmerProductsImagesMapper;

    /**
     * 获取商品详细信息
     *
     * @param id products主键
     * @return products
     */
    @Override
    public FarmerProductsResp selectFarmerProductsById(Long id)
    {
        FarmerProducts products = farmerProductsMapper.selectFarmerProductsById(id);
        if (Objects.isNull(products)) {
            throw new ServiceException("商品不存在", 500);
        }
        List<FarmerProductsTags> productsTags = farmerProductsTagsMapperExt.selectProductsTagsListByProductsId(products.getId());
        List<Long> tagsList = productsTags.stream().map(FarmerProductsTags::getTagsId).collect(Collectors.toList());
        List<FarmerProductsImages> farmerProductsImages = farmerProductsImagesMapper.selectProductsImagesByPid(products.getId());
        FarmerProductsResp farmerProductsResp = new FarmerProductsResp();
        BeanUtils.copyBeanProp(farmerProductsResp, products);
        farmerProductsResp.setFeatures(tagsList);
        farmerProductsResp.setImages(farmerProductsImages);
        return farmerProductsResp;
    }

    /**
     * 查询商品列表
     *
     * @param farmerProducts products
     * @return products
     */
    @Override
    public List<FarmerProducts> selectFarmerProductsList(FarmerProducts farmerProducts)
    {
        PageUtils.startPage();
        List<FarmerProducts> farmerProductsList = farmerProductsMapper.selectFarmerProductsList(farmerProducts);
        PageUtils.clearPage();
        List<FarmerProductsCardResp> farmerProductsCardResps = BeanUtil.copyToList(farmerProductsList, FarmerProductsCardResp.class);

        // 获取所有产品对应的标签 IDs
        List<Long> productIds = farmerProductsCardResps.stream()
                .map(FarmerProductsCardResp::getId)
                .collect(Collectors.toList());

        // 批量查询所有标签关联信息
        List<FarmerProductsTags> allTags = farmerProductsTagsMapperExt.selectProductsTagsListByProductsIds(productIds);

        // 将标签数据按照产品 ID 进行分组
        Map<Long, List<FarmerProductsTags>> tagsMap = allTags.stream()
                .collect(Collectors.groupingBy(FarmerProductsTags::getProductsId));

        // 遍历产品，设置标签信息
        farmerProductsCardResps.forEach(item -> {
            Long pid = item.getId();
            List<FarmerProductsTags> tagsForProduct = tagsMap.get(pid);
            if (tagsForProduct != null) {
                List<String> tags = tagsForProduct.stream()
                        .map(tag -> {
                            Long tagsId = tag.getTagsId();
                            FarmerTags farmerTag = farmerTagsMapper.selectFarmerTagsById(tagsId);
                            return farmerTag != null ? farmerTag.getTagName() : null;
                        })
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                item.setFeatures(tags);
            }
        });

        return farmerProductsList;
    }

    /**
     * 新增products
     *
     * @param farmerProducts products
     * @return 结果
     */
    @Override
    public int insertFarmerProducts(FarmerProducts farmerProducts)
    {
        farmerProducts.setCreateTime(DateUtils.getNowDate());
        return farmerProductsMapper.insertFarmerProducts(farmerProducts);
    }

    /**
     * 修改products
     *
     * @param farmerProducts products
     * @return 结果
     */
    @Override
    public int updateFarmerProducts(FarmerProducts farmerProducts)
    {
        farmerProducts.setUpdateTime(DateUtils.getNowDate());
        return farmerProductsMapper.updateFarmerProducts(farmerProducts);
    }

    /**
     * 批量删除products
     *
     * @param ids 需要删除的products主键
     * @return 结果
     */
    @Override
    public int deleteFarmerProductsByIds(Long[] ids)
    {
        return farmerProductsMapper.deleteFarmerProductsByIds(ids);
    }

    /**
     * 删除products信息
     *
     * @param id products主键
     * @return 结果
     */
    @Override
    public int deleteFarmerProductsById(Long id)
    {
        return farmerProductsMapper.deleteFarmerProductsById(id);
    }

    /**
     * 插入products 详细信息
     *
     * @param farmerProducts@return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertFarmerProductsInfo(FarmerProductsReq farmerProducts) {

        FarmerProducts products = new FarmerProducts();
        BeanUtils.copyBeanProp(products, farmerProducts);
        products.setCreateTime(DateUtils.getNowDate());
        String username = SecurityUtils.getUsername();
        products.setCreateBy(username);
        farmerProductsMapper.insertFarmerProducts(products);
        Long productsId = products.getId();
        List<Long> features = farmerProducts.getFeatures();
        farmerProductsTagsMapperExt.insertProductsTags(productsId, features);
        List<FarmerProductsImages> images = farmerProducts.getImages();

        for (int i = 0; i < images.size(); i++) {
            FarmerProductsImages item = images.get(i);
            item.setProductId(productsId);
            item.setImageOrder((long) i);
            item.setIsPrimary("false");
        }
        farmerProductsImagesMapper.insterProductsImages(images);

    }
}
