package com.product.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.mapper.Mapper;

@Service
/**
 * 通用service
 * @author dell
 *
 * @param <T>
 */
public abstract class BaseService<T> {
	@Autowired
	private Mapper<T> mapper;
	//通过id查询
	public T queryById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	//通过id删除
	public Integer deleteById(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}
	//查询所有
	public List<T> queryAll(){
		return mapper.select(null);
	}
	//根据某个条件查询一条记录
	public T queryByRecord(T record) {
		return mapper.selectOne(record);
	}
	//保存数据
	public Integer save(T t) {
		return mapper.insert(t);
	}
	//根据某个条件修改数据
	public Integer update(T record) {
		return mapper.updateByPrimaryKey(record);
	}
	
}
