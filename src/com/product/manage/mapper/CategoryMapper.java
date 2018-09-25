package com.product.manage.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.product.manage.pojo.Category;

public interface CategoryMapper extends Mapper<Category> {
	public List<String> queryName();
	public List<Category> queryAll();
}
