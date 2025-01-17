package com.qiguliuxing.dts.db.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiguliuxing.dts.db.dao.DtsGoodsSpecificationMapper;
import com.qiguliuxing.dts.db.domain.DtsGoodsSpecification;
import com.qiguliuxing.dts.db.domain.DtsGoodsSpecificationExample;

@Service
public class DtsGoodsSpecificationService {
	@Resource
	private DtsGoodsSpecificationMapper goodsSpecificationMapper;

	public List<DtsGoodsSpecification> queryByGoodsId(String id) {
		return goodsSpecificationMapper.queryByGoodsId(id);
	}

	public DtsGoodsSpecification findById(Integer id) {
		return goodsSpecificationMapper.selectByPrimaryKey(id);
	}

	public void deleteByGid(String gid) {
		DtsGoodsSpecification dtsGoodsSpecification = new DtsGoodsSpecification();
		dtsGoodsSpecification.setGoodsId(gid);
		goodsSpecificationMapper.deleteByGid(dtsGoodsSpecification);
	}

	public void add(DtsGoodsSpecification goodsSpecification) {
		goodsSpecification.setAddTime(LocalDateTime.now());
		goodsSpecification.setUpdateTime(LocalDateTime.now());
		goodsSpecificationMapper.insertSelective(goodsSpecification);
	}

	/**
	 * [ { name: '', valueList: [ {}, {}] }, { name: '', valueList: [ {}, {}] } ]
	 *
	 * @param id
	 * @return
	 */
	public Object getSpecificationVoList(String id) {
		List<DtsGoodsSpecification> goodsSpecificationList = queryByGoodsId(id);

		Map<String, VO> map = new HashMap<>();
		List<VO> specificationVoList = new ArrayList<>();

		for (DtsGoodsSpecification goodsSpecification : goodsSpecificationList) {
			String specification = goodsSpecification.getSpecification();
			VO goodsSpecificationVo = map.get(specification);
			if (goodsSpecificationVo == null) {
				goodsSpecificationVo = new VO();
				goodsSpecificationVo.setName(specification);
				List<DtsGoodsSpecification> valueList = new ArrayList<>();
				valueList.add(goodsSpecification);
				goodsSpecificationVo.setValueList(valueList);
				map.put(specification, goodsSpecificationVo);
				specificationVoList.add(goodsSpecificationVo);
			} else {
				List<DtsGoodsSpecification> valueList = goodsSpecificationVo.getValueList();
				valueList.add(goodsSpecification);
			}
		}

		return specificationVoList;
	}

	private class VO {
		private String name;
		private List<DtsGoodsSpecification> valueList;

		@SuppressWarnings("unused")
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<DtsGoodsSpecification> getValueList() {
			return valueList;
		}

		public void setValueList(List<DtsGoodsSpecification> valueList) {
			this.valueList = valueList;
		}
	}

}
