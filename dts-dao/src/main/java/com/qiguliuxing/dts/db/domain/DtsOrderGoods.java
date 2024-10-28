package com.qiguliuxing.dts.db.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DtsOrderGoods {
    // Fields
    private Integer id;
    private Integer orderId;               // 订单表的订单ID
    private Integer goodsId;               // 商品表的商品ID
    private String goodsName;              // 商品名称
    private String goodsSn;                // 商品编号
    private Integer productId;             // 商品货品表的货品ID
    private Short number;                  // 商品货品的购买数量
    private BigDecimal price;              // 商品货品的售价
    private String[] specifications;         // 商品货品的规格列表
    private String picUrl;                 // 商品货品图片或者商品图片
    private Integer comment;               // 订单商品评论（-1：超期不能评价；0：可以评价；其他值为评论ID）
    private LocalDateTime addTime;         // 创建时间
    private LocalDateTime updateTime;      // 更新时间
    private Boolean deleted;               // 逻辑删除
    private Integer refundId;              // 退款跟踪ID
}