package com.qiguliuxing.dts.db.domain;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DtsOrder {
    private Integer id; // 主键
    private Integer userId; // 用户表的用户ID
    private String orderSn; // 订单编号
    private Short orderStatus; // 订单状态
    private String consignee; // 收货人名称
    private String mobile; // 收货人手机号
    private String address; // 收货具体地址
    private String message; // 用户订单留言
    private BigDecimal goodsPrice; // 商品总费用
    private BigDecimal freightPrice; // 配送费用
    private BigDecimal orderPrice; // 订单费用 = goods_price + freight_price - coupon_price
    private BigDecimal actualPrice; // 实付费用 = order_price - integral_price
    private String payId; // 微信付款编号
    private LocalDateTime payTime; // 微信付款时间
    private String shipSn; // 发货编号
    private String shipChannel; // 发货快递公司
    private LocalDateTime shipTime; // 发货开始时间
    private LocalDateTime confirmTime; // 用户确认收货时间
    private Short comments; // 待评价订单商品数量
    private LocalDateTime endTime; // 订单关闭时间
    private LocalDateTime addTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    private Boolean deleted; // 逻辑删除
    private BigDecimal settlementMoney; // 结算金额
    private Boolean settlementStatus; // 结算状态
    private Byte freightType; // 配送方式: 0 快递, 1 自提
    private String fetchCode; // 提货码
    private Integer createUserId; // 原始创建人
}
