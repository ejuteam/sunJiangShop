package com.qiguliuxing.dts.db.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class DtsAd {
    private int id;                       // 广告ID
    private String name;                  // 广告标题
    private String link;                  // 商品或活动页面链接地址
    private String url;                   // 广告宣传图片
    private Integer position;                // 广告位置（1为首页）
    private String content;               // 活动内容
    private LocalDateTime startTime;               // 广告开始时间
    private LocalDateTime endTime;                 // 广告结束时间
    private Integer enabled;                 // 是否启用
    private LocalDateTime addTime;                 // 创建时间
    private LocalDateTime updateTime;              // 更新时间
    private Integer deleted;                 // 逻辑删除标志
    private String goodsId;               // 关联商品ID
    private String goodsName;
}