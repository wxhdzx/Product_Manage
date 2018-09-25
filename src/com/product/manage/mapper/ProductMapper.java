package com.product.manage.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.product.manage.pojo.Product;

public interface ProductMapper extends Mapper<Product> {
	public List<Product> queryAll(Product product);

	public Integer queryCount();
	
	public Integer save(Product product);

	public Product selectById(Integer pId);

	public void updateById(Product product);
}
