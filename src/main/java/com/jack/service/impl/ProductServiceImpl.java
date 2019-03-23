package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.jack.common.exception.ServiceException;
import com.jack.dao.ProductMapper;
import com.jack.entity.Product;
import com.jack.entity.ProductExample;
import com.jack.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> findPageByPname(Integer startPage, Integer PageSize, String Pname) {
		// 分页查询
		PageHelper.startPage(startPage, PageSize);
		ProductExample example = new ProductExample();
		// 创建模糊查询
		if(!StringUtils.isEmpty(Pname)) {
			example.createCriteria().andPnameLike("%" + Pname + "%");
		}
		List<Product> list = productMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			throw new ServiceException("没有查询到数据");
		}
		return list;
	}


}
