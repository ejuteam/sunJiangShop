package com.qiguliuxing.dts.db.dao;


import com.qiguliuxing.dts.db.domain.DtsGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsGoodsMapper {
    List<DtsGoods> queryGoodsList(DtsGoods dtsGoods);

    void deleteGoodsById(String id);

    void insertDtsGoods(DtsGoods dtsGoods);

    DtsGoods findById(@Param("id") String id);

    int updateByGid(DtsGoods dtsGoods);
}