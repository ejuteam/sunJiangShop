package com.qiguliuxing.dts.db.service;

import com.github.pagehelper.PageHelper;
import com.qiguliuxing.dts.db.dao.DtsGoodsMapper;
import com.qiguliuxing.dts.db.domain.DtsGoods;
import com.qiguliuxing.dts.db.domain.DtsGoodsExample;

import com.qiguliuxing.dts.db.util.IdGenerator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DtsGoodsService {
	/*Column[] columns = new Column[] { Column.id, Column.name, Column.brief, Column.picUrl, Column.isHot, Column.isNew,
			Column.counterPrice, Column.retailPrice };*/
	@Resource
	private DtsGoodsMapper goodsMapper;

	/**
	 * 获取热卖商品
	 *
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<DtsGoods> queryByHot(int offset, int limit) {
		/*DtsGoodsExample example = new DtsGoodsExample();
		example.or().andIsHotEqualTo(true).andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		example.setOrderByClause("browse desc");
		PageHelper.startPage(offset, limit);

		return goodsMapper.selectByExampleSelective(example, columns);*/
		return null;
	}

	/**
	 * 获取新品上市
	 *
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<DtsGoods> queryByNew(int offset, int limit) {
		/*DtsGoodsExample example = new DtsGoodsExample();
		example.or().andIsNewEqualTo(true).andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		example.setOrderByClause("add_time desc");
		PageHelper.startPage(offset, limit);

		return goodsMapper.selectByExampleSelective(example, columns);*/
		return null;
	}

	/**
	 * 获取分类下的商品
	 *
	 * @param catList
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<DtsGoods> queryByCategory(List<Integer> catList, int offset, int limit) {
		/*DtsGoodsExample example = new DtsGoodsExample();
		example.or().andCategoryIdIn(catList).andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		example.setOrderByClause("sort_order  asc");
		PageHelper.startPage(offset, limit);

		return goodsMapper.selectByExampleSelective(example, columns);*/
		return null;
	}

	/**
	 * 获取分类下的商品
	 *
	 * @param catId
	 * @return
	 */
	public List<DtsGoods> queryByCategory(String  catId) {
		return goodsMapper.queryByCategory(catId);
	}

	public List<DtsGoods> querySelective(Integer catId, Integer brandId, String keywords, Boolean isHot, Boolean isNew,
			Integer offset, Integer limit, String sort, String order) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		DtsGoodsExample.Criteria criteria1 = example.or();
		DtsGoodsExample.Criteria criteria2 = example.or();

		if (!StringUtils.isEmpty(catId) && catId != 0) {
			criteria1.andCategoryIdEqualTo(catId);
			criteria2.andCategoryIdEqualTo(catId);
		}
		if (!StringUtils.isEmpty(brandId)) {
			criteria1.andBrandIdEqualTo(brandId);
			criteria2.andBrandIdEqualTo(brandId);
		}
		if (!StringUtils.isEmpty(isNew)) {
			criteria1.andIsNewEqualTo(isNew);
			criteria2.andIsNewEqualTo(isNew);
		}
		if (!StringUtils.isEmpty(isHot)) {
			criteria1.andIsHotEqualTo(isHot);
			criteria2.andIsHotEqualTo(isHot);
		}
		if (!StringUtils.isEmpty(keywords)) {
			criteria1.andKeywordsLike("%" + keywords + "%");
			criteria2.andNameLike("%" + keywords + "%");
		}
		criteria1.andIsOnSaleEqualTo(true);
		criteria2.andIsOnSaleEqualTo(true);
		criteria1.andDeletedEqualTo(false);
		criteria2.andDeletedEqualTo(false);

		if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
			example.setOrderByClause(sort + " " + order);
		}

		PageHelper.startPage(offset, limit);

		return goodsMapper.selectByExampleSelective(example, columns);*/
		return null;
	}

	public List<DtsGoods> queryGoodsList(String goodsSn, String name, String categoryId,Integer page, Integer size) {
		DtsGoods dtsGoods = new DtsGoods();
		if (goodsSn != null && !goodsSn.isEmpty()) {
			dtsGoods.setGoodsSn(goodsSn);
		}
		if (name != null && !name.isEmpty()) {
			dtsGoods.setName(name);
		}
		if (categoryId != null && !categoryId.isEmpty()) {
			dtsGoods.setCategoryId(categoryId);
		}

		PageHelper.startPage(page, size);
		return goodsMapper.queryGoodsList(dtsGoods);
	}

	/**
	 * 获取某个商品信息,包含完整信息
	 *
	 * @param id
	 * @return
	 */
	public DtsGoods findById(String id) {
		return goodsMapper.findById(id);
	}
	
	/**
	 * 根据序列码找到商品
	 * @param goodsSn
	 * @return
	 */
	public DtsGoods findByGoodsSn(String goodsSn) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andGoodsSnEqualTo(goodsSn).andDeletedEqualTo(false);
		return goodsMapper.selectOneByExampleWithBLOBs(example);*/
		return null;
	}

	/**
	 * 获取某个商品信息，仅展示相关内容
	 *
	 * @param id
	 * @return
	 */
	public DtsGoods findByIdVO(Integer id) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andIdEqualTo(id).andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		return goodsMapper.selectOneByExampleSelective(example, columns);*/
		return null;
	}
	
	public DtsGoods findBySnVO(String sn) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andGoodsSnEqualTo(sn).andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		return goodsMapper.selectOneByExampleSelective(example, columns);*/
		return null;
	}

	/**
	 * 获取所有在售物品总数
	 *
	 * @return
	 */
	public Integer queryOnSale() {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		return (int) goodsMapper.countByExample(example);*/
		return null;
	}

	public int updateById(DtsGoods goods) {
		goods.setUpdateTime(LocalDateTime.now());
		return goodsMapper.updateByGid(goods);
	}

	public void deleteGoodsById(String id) {
		goodsMapper.deleteGoodsById(id);
	}

	public void add(DtsGoods goods) {
		goods.setAddTime(LocalDateTime.now());
		goods.setUpdateTime(LocalDateTime.now());
		goodsMapper.insertDtsGoods(goods);
	}

	/**
	 * 获取所有物品总数，包括在售的和下架的，但是不包括已删除的商品
	 *
	 * @return
	 */
	public int count() {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andDeletedEqualTo(false);
		return (int) goodsMapper.countByExample(example);*/
		return 0;

	}

	public List<Integer> getCatIds(Integer brandId, String keywords, Boolean isHot, Boolean isNew) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		DtsGoodsExample.Criteria criteria1 = example.or();
		DtsGoodsExample.Criteria criteria2 = example.or();

		if (!StringUtils.isEmpty(brandId)) {
			criteria1.andBrandIdEqualTo(brandId);
			criteria2.andBrandIdEqualTo(brandId);
		}
		if (!StringUtils.isEmpty(isNew)) {
			criteria1.andIsNewEqualTo(isNew);
			criteria2.andIsNewEqualTo(isNew);
		}
		if (!StringUtils.isEmpty(isHot)) {
			criteria1.andIsHotEqualTo(isHot);
			criteria2.andIsHotEqualTo(isHot);
		}
		if (!StringUtils.isEmpty(keywords)) {
			criteria1.andKeywordsLike("%" + keywords + "%");
			criteria2.andNameLike("%" + keywords + "%");
		}
		criteria1.andIsOnSaleEqualTo(true);
		criteria2.andIsOnSaleEqualTo(true);
		criteria1.andDeletedEqualTo(false);
		criteria2.andDeletedEqualTo(false);

		List<DtsGoods> goodsList = goodsMapper.selectByExampleSelective(example, Column.categoryId);
		List<Integer> cats = new ArrayList<Integer>();
		for (DtsGoods goods : goodsList) {
			cats.add(goods.getCategoryId());
		}
		return cats;*/
		return null;

	}

	public boolean checkExistByName(String name) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andNameEqualTo(name).andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		return goodsMapper.countByExample(example) != 0;*/
		return false;

	}

	/**
	 * 根据店铺，获取店铺对应类别的商品
	 *
	 * @return
	 */
	public List<DtsGoods> queryByBrandId(int bid, int cid, int offset, int limit) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andBrandIdEqualTo(bid).andCategoryIdEqualTo(cid).andIsOnSaleEqualTo(true).andDeletedEqualTo(false);
		example.setOrderByClause("browse desc");
		PageHelper.startPage(offset, limit);

		return goodsMapper.selectByExampleSelective(example, columns);*/
		return null;

	}

	/**
	 * 同类商品，且不同店铺
	 *
	 * @return
	 */
	public List<DtsGoods> queryByCategoryAndNotSameBrandId(int bid, int cid, int offset, int limit) {/*
		DtsGoodsExample example = new DtsGoodsExample();
		example.or().andBrandIdNotEqualTo(bid).andCategoryIdEqualTo(cid).andIsOnSaleEqualTo(true)
				.andDeletedEqualTo(false);
		example.setOrderByClause("browse desc");
		PageHelper.startPage(offset, limit);

		return goodsMapper.selectByExampleSelective(example, columns);*/
		return null;

	}
}
