package com.qiguliuxing.dts.db.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class DtsGoods {
    private Integer id;

    /**
     * 商品编号
     */
    private String goodsSn;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 是否生鲜 0是 1否
     */
    private Integer isFresh;
    /**
     * 商品简介
     */
    private String brief;
    /**
     * 商品详细介绍 富文本格式
     */
    private String detail;
    /**
     * 商品所属分类ID
     */
    private Integer categoryId;
    /**
     * 商品所属分类名称
     */
    private String categoryName;
    /**
     * 商品规格 JSON数组
     */
    private String goodsType;
    /**
     * 是否包邮 0是 1否
     */
    private Integer isPostage;
    /**
     * 包邮下限
     */
    private Integer minPostage;
    /**
     * 首重
     */
    private Integer firstWeight;
    /**
     * 首重邮费
     */
    private BigDecimal postageFir ;
    /**
     * 续重邮费
     */
    private BigDecimal postageSec;
    /**
     * 是否上架 0是 1否
     */
    private Integer isOnSale;
    /**
     *
     */
    private Integer brandId;
    /**
     * 商品宣传图片列表 JSON数组格式
     */
    private String[] gallery;
    /**
     * 商品页面商品图片
     */
    private String picUrl;
    /**
     * 商品单位 件、盒
     */
    private String unit;
    /**
     * 价格
     */
    private BigDecimal retailPrice;
    /**
     * 创建时间
     */
    private Date addTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 浏览量
     */
    private Integer browse;
    /**
     * 已销售总量
     */
    private Integer sales;
}