package com.jack.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.common.exception.ServiceException;
import com.jack.common.vo.UUIDUtils;
import com.jack.dao.CartItemMapper;
import com.jack.dao.ScitemMapper;
import com.jack.dao.ShopcartMapper;
import com.jack.entity.Scitem;
import com.jack.entity.ScitemExample;
import com.jack.entity.Shopcart;
import com.jack.entity.ShopcartExample;
import com.jack.entity.vo.MyCartItemVo;
import com.jack.service.ScitemService;

@Service
public class ScitemServiceImpl implements ScitemService{
	
	@Autowired
	ScitemMapper scitemMapper;
	@Autowired
	ShopcartMapper shopcartMapper;
	@Autowired
	CartItemMapper cartItemMapper;
	
	/**添加商品到购物车*/
	@Override
	public int doAddScitem(Scitem scitem,String uid) {
		String newShortUUID = UUIDUtils.newShortUUID();
		scitem.setScitemid(newShortUUID);
		//根据登录的用户名获取scid并设置scid
		ShopcartExample example = new ShopcartExample();
		example.createCriteria().andUidEqualTo(uid);
		List<Shopcart> selectByExample = shopcartMapper.selectByExample(example);
		if (selectByExample == null) {
			throw new ServiceException("请先登录");
		}
		String scid = selectByExample.get(0).getScid();
		scitem.setScid(scid);
		
		int rows = scitemMapper.insert(scitem);
		if (rows == 0) {
			throw new ServiceException("添加商品到购物车失败");
		}
		return rows;
	}

	@Override
	public List<MyCartItemVo> doShowCartList(String uid) {
		ShopcartExample example = new ShopcartExample();
		example.createCriteria().andUidEqualTo(uid);
		List<Shopcart> selectByExample = shopcartMapper.selectByExample(example);
		if (selectByExample == null) {
			throw new ServiceException("请先登录");
		}
		String scid = selectByExample.get(0).getScid();
		
		List<MyCartItemVo> doShowCartList = cartItemMapper.doShowCartList(scid);
		return doShowCartList;
	}
	
	@Override
	public int doDeleteScitem(String[] array) {
		List<String> list = Arrays.asList(array);
		ScitemExample example = new ScitemExample();
		example.createCriteria().andScitemidIn(list);
		int rows = scitemMapper.deleteByExample(example);
		if (rows == 0) {
			throw new ServiceException("该数据可能已经被删除");
		}
		
		return rows;
	}
	
}
