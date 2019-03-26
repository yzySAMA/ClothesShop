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
import com.jack.service.ProductService;
import com.jack.service.ScitemService;

@Service
public class ScitemServiceImpl implements ScitemService{
	
	@Autowired
	ScitemMapper scitemMapper;
	@Autowired
	ShopcartMapper shopcartMapper;
	@Autowired
	CartItemMapper cartItemMapper;
	@Autowired
	ProductService productService;
	
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
		//根据pid,scid查看scitem表是否已经有此商品
		ScitemExample example2 = new ScitemExample();
		example2.createCriteria().andScidEqualTo(scid).andPidEqualTo(scitem.getPid());
		List<Scitem> list2 = scitemMapper.selectByExample(example2);
		//如果购物项中已经有该商品，那么将其count增加
		if (list2.size() != 0) {
			scitem.setCount((Integer.parseInt(scitem.getCount())+Integer.parseInt(list2.get(0).getCount()))+"");
			scitem.setSubtotal((Integer.parseInt(scitem.getSubtotal())+Integer.parseInt(list2.get(0).getSubtotal()))+"");
			int rows = scitemMapper.updateByExample(scitem, example2);
			return rows;
		}
		//否则新增商品
		int rows = scitemMapper.insert(scitem);
		if (rows == 0) {
			throw new ServiceException("添加商品到购物车失败");
		}
		return rows;
	}
	
	/**展示购物车信息*/
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
	
	/**删除购物项*/
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
