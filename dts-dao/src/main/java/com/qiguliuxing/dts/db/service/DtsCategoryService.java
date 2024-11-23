package com.qiguliuxing.dts.db.service;

import com.github.pagehelper.PageHelper;
import com.qiguliuxing.dts.db.dao.DtsCategoryMapper;
import com.qiguliuxing.dts.db.domain.DtsCategory;

import com.qiguliuxing.dts.db.util.IdGenerator;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DtsCategoryService {
	@Resource
	private DtsCategoryMapper categoryMapper;

	public List<DtsCategory> queryCategoryList(String id, String name, Integer page, Integer size) {
		DtsCategory dtsCategory = new DtsCategory();
		if (id != null && !id.isEmpty()) {
			dtsCategory.setId(id);
		}
		if (name != null && !name.isEmpty()) {
			dtsCategory.setName(name);
		}

		PageHelper.startPage(page, size);
		return categoryMapper.selectCategoryList(dtsCategory);
	}

	public List<DtsCategory> queryCategoryListAll(String id, String name) {
		DtsCategory dtsCategory = new DtsCategory();
		if (id != null && !id.isEmpty()) {
			dtsCategory.setId(id);
		}
		if (name != null && !name.isEmpty()) {
			dtsCategory.setName(name);
		}

		return categoryMapper.selectCategoryList(dtsCategory);
	}

	public List<DtsCategory> queryChannel() {
		PageHelper.startPage(1, 9);// 设置分页10
		return categoryMapper.selectCategoryList(new DtsCategory());
	}

	public void addCategory(DtsCategory category) {
		IdGenerator idGenerator = new IdGenerator();
		category.setId(idGenerator.getStrId());
		category.setAddTime(LocalDateTime.now());
		category.setUpdateTime(LocalDateTime.now());
		categoryMapper.insertCategory(category);
	}

	public void deleteCategoryById(String id) {
		categoryMapper.deleteCategoryById(id);
	}

	public int updateCategoryById(DtsCategory category) {
		category.setUpdateTime(LocalDateTime.now());
		return categoryMapper.updateCategoryById(category);
	}

	public DtsCategory findCategoryByGoodsId(String goodsId){
		return categoryMapper.findCategoryByGoodsId(goodsId);
	}

	public List<DtsCategory> queryL1WithoutRecommend(int offset, int limit) {
		/*DtsCategoryExample example = new DtsCategoryExample();
		example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);*/
		DtsCategory dtsCategory = new DtsCategory();
		PageHelper.startPage(offset, limit);
		return categoryMapper.selectCategoryList(dtsCategory);
		//return categoryMapper.selectByExample(example);
	}

	//查询已关联商品的分类列表
	public List<DtsCategory>  selectCategoryExsitsGoods(){
		return categoryMapper.selectCategoryExsitsGoods();
	}

	//根据ID获取分类
	public DtsCategory findById(String id) {
		return categoryMapper.findById(id);
	}

	/*

	public List<DtsCategory> queryL1(int offset, int limit) {
		DtsCategoryExample example = new DtsCategoryExample();
		example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
		PageHelper.startPage(offset, limit);
		return categoryMapper.selectByExample(example);
	}

	public List<DtsCategory> queryL1() {
		DtsCategoryExample example = new DtsCategoryExample();
		example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
		return categoryMapper.selectByExample(example);
	}

	public List<DtsCategory> queryByPid(Integer pid) {
		DtsCategoryExample example = new DtsCategoryExample();
		example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
		return categoryMapper.selectByExample(example);
	}

	public List<DtsCategory> queryL2ByIds(List<Integer> ids) {
		DtsCategoryExample example = new DtsCategoryExample();
		example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
		return categoryMapper.selectByExample(example);
	}
*/
}
