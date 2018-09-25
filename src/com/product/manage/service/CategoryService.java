package com.product.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.manage.mapper.CategoryMapper;
import com.product.manage.pojo.Category;
import com.product.manage.pojo.User;

@Service
@Transactional
public class CategoryService extends BaseService<Category>{
	@Autowired
	private CategoryMapper categoryMapper;
	public List<String> queryName(){
		return categoryMapper.queryName();
	}
	public List<Category> queryAll() {
		return categoryMapper.queryAll();
	}
}
