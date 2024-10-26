package com.qiguliuxing.dts.admin.dao;

import com.qiguliuxing.dts.db.domain.DtsGoods;
import com.qiguliuxing.dts.db.domain.DtsGoodsAttribute;
import com.qiguliuxing.dts.db.domain.DtsGoodsProduct;
import com.qiguliuxing.dts.db.domain.DtsGoodsSpecification;
import lombok.Data;

@Data
public class GoodsAllinone {
	DtsGoods goods;
	DtsGoodsSpecification[] specifications;
	/*DtsGoodsAttribute[] attributes;
	// 这里采用 Product 再转换到 DtsGoodsProduct
	DtsGoodsProduct[] products;*/

}
