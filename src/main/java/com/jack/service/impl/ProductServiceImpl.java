package com.jack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jack.common.exception.ServiceException;
import com.jack.common.vo.UUIDUtils;
import com.jack.dao.ProductMapper;
import com.jack.entity.Orders;
import com.jack.entity.Product;
import com.jack.entity.ProductExample;
import com.jack.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	/**
	 * 分页查询,根据pname模糊查询
	 */
	@Override
	public PageInfo<Product> findPageByPname(Integer startPage, Integer PageSize, String Pname) {
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
		PageInfo<Product> pi = new PageInfo<>(list);
		return pi;
	}

	@Override
	public int insertObject(Product record) {
		//1.验证数据合法性
		if (record == null) {
			throw new ServiceException("保存对象不能为空");
		}
		if (StringUtils.isEmpty(record.getPname())) {
			throw new ServiceException("商品名不能为空");
		}
		if (record.getPrice() == null || record.getPrice() < 0) {
			throw new ServiceException("价格不能为空或非法");
		}
		if(StringUtils.isEmpty(record.getPimage())) {
			throw new ServiceException("请上传图片文件");
		}
		if (record.getPnumber() == null || record.getPnumber() < 0) {
			throw new ServiceException("数量不能为空或非法");
		}
		if (StringUtils.isEmpty(record.getCid())) {
			throw new ServiceException("请选择商品类别");
		}
		String pid = UUIDUtils.newShortUUID();
		record.setPid(pid);
		int rows;
		try {
			rows = productMapper.insert(record);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}
	/**
	 * 根据pid查询商品信息
	 */
	@Override
	public Product findProductByPid(String pid) {
		if (StringUtils.isEmpty(pid)) {
			throw new ServiceException("请选择");
		}
		Product pro = productMapper.selectByPrimaryKey(pid);
		if (pro == null) {
			throw new ServiceException("查询不到数据");
		}
		return pro;
	}
	/**
	 * 修改商品信息
	 */
	@Override
	public int updateProduct(Product record) {
		if (record == null) {
			throw new ServiceException("保存对象不能为空");
		}
		
		if (StringUtils.isEmpty(record.getPname())) {
			throw new ServiceException("商品名不能为空");
		}
		if (record.getPrice() == null || record.getPrice() < 0) {
			throw new ServiceException("价格不能为空或非法");
		}
		if(StringUtils.isEmpty(record.getPimage())) {
			throw new ServiceException("请上传图片文件");
		}
		if (record.getPnumber() == null || record.getPnumber() < 0) {
			throw new ServiceException("数量不能为空或非法");
		}
		if (StringUtils.isEmpty(record.getCid())) {
			throw new ServiceException("请选择商品类别");
		}
		int rows = productMapper.updateByPrimaryKey(record);
		
		return rows;
	}


}
