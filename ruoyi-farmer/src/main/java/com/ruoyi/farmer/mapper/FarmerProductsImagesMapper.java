package com.ruoyi.farmer.mapper;

import com.ruoyi.farmer.domain.FarmerProductsImages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huixh
 */
public interface FarmerProductsImagesMapper {

    public void insterProductsImages(@Param("images") List<FarmerProductsImages> farmerProductsImages);

    public List<FarmerProductsImages> selectProductsImagesByPid(@Param("id") Long id);
}
