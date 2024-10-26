package com.qiguliuxing.dts.db.dao;


import com.qiguliuxing.dts.db.domain.DtsGoods;

import java.util.List;

public interface DtsGoodsMapper {
    List<DtsGoods> queryGoodsList(DtsGoods dtsGoods);

    void deleteGoodsById(Integer id);

    void insertDtsGoods(DtsGoods dtsGoods);
}