package com.qiguliuxing.dts.db.service;

import org.springframework.stereotype.Service;

import com.qiguliuxing.dts.db.dao.DtsOrderGoodsMapper;
import com.qiguliuxing.dts.db.domain.DtsOrderGoods;
import com.qiguliuxing.dts.db.domain.DtsOrderGoodsExample;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DtsOrderGoodsService {
	@Resource
	private DtsOrderGoodsMapper orderGoodsMapper;

	public List<DtsOrderGoods> queryByOid(Integer orderId) {
		DtsOrderGoods dtsOrderGoods = new DtsOrderGoods();
		dtsOrderGoods.setOrderId(orderId);
		return orderGoodsMapper.selectDtsOrderGoodsList(dtsOrderGoods);
	}

	public boolean checkExist(String goodsId) {
		DtsOrderGoods dtsOrderGoods = new DtsOrderGoods();
		dtsOrderGoods.setGoodsId(Integer.valueOf(goodsId));
		return orderGoodsMapper.countByGid(dtsOrderGoods) != 0;
	}

	public void updateById(DtsOrderGoods orderGoods) {
		orderGoods.setUpdateTime(LocalDateTime.now());
		orderGoodsMapper.updateOrderGoodsById(orderGoods);
	}
	/*public int add(DtsOrderGoods orderGoods) {
		orderGoods.setAddTime(LocalDateTime.now());
		orderGoods.setUpdateTime(LocalDateTime.now());
		return orderGoodsMapper.insertSelective(orderGoods);
	}

	public List<DtsOrderGoods> findByOidAndGid(Integer orderId, String goodsId) {
		DtsOrderGoodsExample example = new DtsOrderGoodsExample();
		example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
		return orderGoodsMapper.selectByExample(example);
	}

	public DtsOrderGoods findById(Integer id) {
		return orderGoodsMapper.selectByPrimaryKey(id);
	}

	public Short getComments(Integer orderId) {
		DtsOrderGoodsExample example = new DtsOrderGoodsExample();
		example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
		long count = orderGoodsMapper.countByExample(example);
		return (short) count;
	}
	}*/
}
