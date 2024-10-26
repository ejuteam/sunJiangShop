package com.qiguliuxing.dts.db.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Data
public class DtsGoodsSpecification {
    private String id;

    /**
     * 商品ID
     */
    private String goodsId;
    /**
     * 商品规格名称
     */
    private String specification;
    /**
     * 商品重量
     */
    private String weight;
    /**
     * 售价
     */
    private BigDecimal price;
    /**
     * 库存
     */
    private String repertory;
    /**
     * 添加时间
     */
    private LocalDateTime addTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}