package com.product.manage.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.manage.mapper.ProductMapper;
import com.product.manage.pojo.Product;
import com.product.manage.pojo.User;
import com.product.manage.util.PageBean;

@Service
@Transactional
public class ProductService extends BaseService<Product>{
	@Autowired
	private ProductMapper productMapper;
	/*public List<Product> queryAll(){
		List<Product> list = productMapper.queryAll();
		return list;
	}*/
	
	public PageBean queryAllPage(Integer currentPage,Integer pageSize,Integer minprice,Integer maxprice,String pName){
		//如果条件不为空,就加入叫天
		Product product=new Product();
		if(StringUtils.isNotBlank(pName)) {
			product.setpName(pName);
		}
		product.setStart((currentPage-1)*pageSize);
		product.setPageSize(pageSize);
		List<Product> products = productMapper.queryAll(product);
		PageBean pageBean=new PageBean();
		//总记录数
		Integer total=productMapper.queryCount();
		//总页数
		//product.setStart((currentPage-1)*pageSize);
		int totalPage=total%pageSize==0?total/pageSize:(total/pageSize)+1;
		pageBean.setCount(total);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalPage(totalPage);
		pageBean.setProducts(products);
		return pageBean;
	}
	
	public Integer saveProduct(Product product) {
		return productMapper.save(product);
	}

	public Product selectById(Integer pId) {
		// TODO Auto-generated method stub
		return productMapper.selectById(pId);
	}

	public void updateById(Product product) {
		// TODO Auto-generated method stub
		productMapper.updateById( product);
	}
}
