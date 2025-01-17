package com.qiguliuxing.dts.db.service;

import com.github.pagehelper.PageHelper;
import com.qiguliuxing.dts.db.dao.DtsAdMapper;
import com.qiguliuxing.dts.db.domain.DtsAd;
import com.qiguliuxing.dts.db.domain.DtsAdExample;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DtsAdService {
	@Resource
	private DtsAdMapper adMapper;

	public List<DtsAd> queryIndex() {
		//example.or().andPositionEqualTo((byte) 1).andDeletedEqualTo(false).andEnabledEqualTo(true);
		DtsAd dtsAd = new DtsAd();
		dtsAd.setPosition(1);
		dtsAd.setDeleted(0);
		dtsAd.setEnabled(1);
		return adMapper.selectAdList(dtsAd);
	}

	public List<DtsAd> querySelective(String name, String content, String enabled, String goodsId, Integer page, Integer limit, String sort,
			String order) {
		DtsAd dtsAd = new DtsAd();

		if (!StringUtils.isEmpty(name)) {
			dtsAd.setName(name);
		}
		if (!StringUtils.isEmpty(content)) {
			dtsAd.setContent(content);
		}
		if (!StringUtils.isEmpty(enabled)){
			dtsAd.setEnabled(Integer.valueOf(enabled));
		}
		if( !StringUtils.isEmpty(goodsId)){
			dtsAd.setGoodsId(goodsId);
		}

		PageHelper.startPage(page, limit);
		return adMapper.selectAdList(dtsAd);
	}

	public int updateById(DtsAd ad) {
		ad.setUpdateTime(LocalDateTime.now());
		return adMapper.updateAdById(ad);
	}

	public void deleteById(Integer id) {
		//逻辑删除
		//adMapper.logicalDeleteAdById(id);
		adMapper.deleteAdById(id);
	}

	public void add(DtsAd ad) {
		ad.setAddTime(LocalDateTime.now());
		ad.setUpdateTime(LocalDateTime.now());
		adMapper.insertAd(ad);
	}

	public DtsAd findById(Integer id) {
		return adMapper.selectOneByID(id);
	}
}
