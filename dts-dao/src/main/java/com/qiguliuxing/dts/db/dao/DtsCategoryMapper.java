package com.qiguliuxing.dts.db.dao;

import com.qiguliuxing.dts.db.domain.DtsCategory;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsCategoryMapper {
    List<DtsCategory> selectCategoryList(DtsCategory dtsCategory);

    void insertCategory(DtsCategory category);

    void deleteCategoryById(@Param("id") String id);

    int updateCategoryById(DtsCategory category);
}