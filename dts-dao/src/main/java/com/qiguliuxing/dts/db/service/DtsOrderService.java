package com.qiguliuxing.dts.db.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.qiguliuxing.dts.db.bean.CategorySellAmts;
import com.qiguliuxing.dts.db.bean.DayStatis;
import com.qiguliuxing.dts.db.dao.DtsOrderMapper;
import com.qiguliuxing.dts.db.dao.ex.OrderMapper;
import com.qiguliuxing.dts.db.dao.ex.StatMapper;
import com.qiguliuxing.dts.db.domain.DtsOrder;
import com.qiguliuxing.dts.db.domain.DtsOrderExample;
import com.qiguliuxing.dts.db.util.OrderUtil;

@Service
public class DtsOrderService {
	@Resource
	private DtsOrderMapper dtsOrderMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private StatMapper statMapper;
	

	public int add(DtsOrder order) {/*
		order.setAddTime(LocalDateTime.now());
		order.setUpdateTime(LocalDateTime.now());
		return dtsOrderMapper.insertSelective(order);*/
		return 1;
	}

	public void updateOrderStatusById (DtsOrder order){
		dtsOrderMapper.updateOrderStatusById(order);
	}

	public int count(Integer userId) {/*
		DtsOrderExample example = new DtsOrderExample();
		example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
		return (int) dtsOrderMapper.countByExample(example);*/
		return 1;
	}

	public List<DtsOrder> findById(Integer orderId) {
		DtsOrder dtsOrder = new DtsOrder();
		dtsOrder.setId(orderId);
		return dtsOrderMapper.queryOrderList(dtsOrder,null);
	}

	private String getRandomNum(Integer num) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public int countByOrderSn(Integer userId, String orderSn) {/*
		DtsOrderExample example = new DtsOrderExample();
		example.or().andUserIdEqualTo(userId).andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
		return (int) dtsOrderMapper.countByExample(example);*/
		return 1;
	}

	// TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
	public String generateOrderSn(Integer userId) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
		String now = df.format(LocalDate.now());
		String orderSn = now + getRandomNum(6);
		while (countByOrderSn(userId, orderSn) != 0) {
			orderSn = getRandomNum(6);
		}
		return orderSn;
	}

	public List<DtsOrder> queryByOrderStatus(Integer userId, List<Short> orderStatus, Integer page, Integer size) {
		/*DtsOrderExample example = new DtsOrderExample();
		example.setOrderByClause(DtsOrder.Column.addTime.desc());
		DtsOrderExample.Criteria criteria = example.or();
		criteria.andUserIdEqualTo(userId);
		if (orderStatus != null) {
			criteria.andOrderStatusIn(orderStatus);
		}
		criteria.andDeletedEqualTo(false);
		PageHelper.startPage(page, size);
		return dtsOrderMapper.selectByExample(example);*/
		return null;
	}

	public List<DtsOrder> querySelective(Integer userId, String orderSn, String payStartDate, String payEndDate, List<Short> orderStatusArray, Integer page,
			Integer size, String sort, String order) {
		DtsOrder dtsOrder = new DtsOrder();

		if (userId != null) {
			dtsOrder.setUserId(userId);
		}
		if (!StringUtils.isEmpty(orderSn)) {
			dtsOrder.setOrderSn(orderSn);
		}
		if (!StringUtils.isEmpty(payStartDate)) {
			dtsOrder.setPayStartDate(payStartDate);
		}
		if (!StringUtils.isEmpty(payEndDate)) {
			dtsOrder.setPayEndDate(payEndDate);
		}

		dtsOrder.setDeleted(false);

		PageHelper.startPage(page, size);
		return dtsOrderMapper.queryOrderList(dtsOrder,orderStatusArray);
	}

	public int updateWithOptimisticLocker(DtsOrder order) {
		LocalDateTime preUpdateTime = order.getUpdateTime();
		order.setUpdateTime(LocalDateTime.now());
		return orderMapper.updateWithOptimisticLocker(preUpdateTime, order);
	}

	public void deleteById(Integer id) {
		//dtsOrderMapper.logicalDeleteByPrimaryKey(id);
	}

	public int count() {/*
		DtsOrderExample example = new DtsOrderExample();
		example.or().andDeletedEqualTo(false);
		return (int) dtsOrderMapper.countByExample(example);*/
		return 1;
	}

	public List<DtsOrder> queryOrderList() {
		DtsOrder dtsOrder = new DtsOrder();
		dtsOrder.setOrderStatus(OrderUtil.STATUS_CREATE);
		dtsOrder.setDeleted(false);
		return dtsOrderMapper.queryOrderList(dtsOrder,null);
	}

	public List<DtsOrder> queryUnconfirm() {/*
		DtsOrderExample example = new DtsOrderExample();
		example.or().andOrderStatusEqualTo(OrderUtil.STATUS_SHIP).andShipTimeIsNotNull().andDeletedEqualTo(false);
		return dtsOrderMapper.selectByExample(example);*/
		return null;
	}

	public DtsOrder findBySn(String orderSn) {/*
		DtsOrderExample example = new DtsOrderExample();
		example.or().andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
		return dtsOrderMapper.selectOneByExample(example);*/
		return null;
	}

	public Map<Object, Object> orderInfo(Integer userId) {/*
		DtsOrderExample example = new DtsOrderExample();
		example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
		List<DtsOrder> orders = dtsOrderMapper.selectByExampleSelective(example, DtsOrder.Column.orderStatus,
				DtsOrder.Column.comments);

		int unpaid = 0;
		int unship = 0;
		int unrecv = 0;
		int uncomment = 0;
		for (DtsOrder order : orders) {
			if (OrderUtil.isCreateStatus(order)) {
				unpaid++;
			} else if (OrderUtil.isPayStatus(order)) {
				unship++;
			} else if (OrderUtil.isShipStatus(order)) {
				unrecv++;
			} else if (OrderUtil.isConfirmStatus(order) || OrderUtil.isAutoConfirmStatus(order)) {
				uncomment += order.getComments();
			} else {
				// do nothing
			}
		}

		Map<Object, Object> orderInfo = new HashMap<Object, Object>();
		orderInfo.put("unpaid", unpaid);
		orderInfo.put("unship", unship);
		orderInfo.put("unrecv", unrecv);
		orderInfo.put("uncomment", uncomment);
		return orderInfo;*/
		return null;
	}

	public List<DtsOrder> queryComment() {/*
		DtsOrderExample example = new DtsOrderExample();
		example.or().andCommentsGreaterThan((short) 0).andDeletedEqualTo(false);
		return dtsOrderMapper.selectByExample(example);*/
		return null;
	}

	public List<DayStatis> recentCount(int statisDaysRang) {
		return statMapper.statisIncreaseOrderCnt(statisDaysRang);
	}

	public List<CategorySellAmts> categorySell() {
		return statMapper.categorySellStatis();
	}

	/**
	 * 获取指定店铺的订单
	 * @param brandIds
	 * @param userId
	 * @param orderSn
	 * @param orderStatusArray
	 * @param page
	 * @param
	 * @param sort
	 * @param order
	 * @return
	 */
	public List<DtsOrder> queryBrandSelective(List<Integer> brandIds, Integer userId, String orderSn,
			List<Short> orderStatusArray, Integer page, Integer size, String sort, String order) {
		
		String orderStatusSql = null;
		if (orderStatusArray != null) {
			orderStatusSql = "";
			for (Short orderStatus : orderStatusArray) {
				orderStatusSql += "," + orderStatus;
			}
			orderStatusSql = "and o.order_status in (" + orderStatusSql.substring(1) + ") ";
		}
		
		String orderBySql = null;
		if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
			orderBySql = "o."+sort + " " + order;
		}
		
		String brandIdsSql = null;
		if (brandIds != null) {
			brandIdsSql = "";
			for (Integer brandId : brandIds) {
				brandIdsSql += "," + brandId;
			}
			brandIdsSql = " and g.brand_id in (" + brandIdsSql.substring(1) + ") ";
		}

		PageHelper.startPage(page, size);
		return orderMapper.selectBrandOrdersByExample(userId, orderSn,orderStatusSql,orderBySql,brandIdsSql);
	}

}
