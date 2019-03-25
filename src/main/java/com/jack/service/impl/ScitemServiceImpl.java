package com.jack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.common.exception.ServiceException;
import com.jack.common.vo.UUIDUtils;
import com.jack.dao.ScitemMapper;
import com.jack.entity.Scitem;
import com.jack.service.ScitemService;

@Service
public class ScitemServiceImpl implements ScitemService{
	
	@Autowired
	ScitemMapper scitemMapper;
	
	/**添加商品到购物车*/
	@Override
	public int doAddScitem(Scitem scitem) {
		String newShortUUID = UUIDUtils.newShortUUID();
		scitem.setScitemid(newShortUUID);
		int rows = scitemMapper.insert(scitem);
		if (rows == 0) {
			throw new ServiceException("添加商品到购物车失败");
		}
		return rows;
	}
}
