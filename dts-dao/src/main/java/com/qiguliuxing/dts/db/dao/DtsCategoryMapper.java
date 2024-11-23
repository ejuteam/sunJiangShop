package com.qiguliuxing.dts.db.dao;

import com.qiguliuxing.dts.db.domain.DtsCategory;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsCategoryMapper {
    List<DtsCategory> selectCategoryList(DtsCategory dtsCategory);

    //只查询有商品关联的分类列表
    List<DtsCategory> selectCategoryExsitsGoods();

    DtsCategory findById(@Param("id") String id);

    void insertCategory(DtsCategory category);

    void deleteCategoryById(@Param("id") String id);

    int updateCategoryById(DtsCategory category);

    DtsCategory findCategoryByGoodsId(@Param("goodsId") String goodsId);
}