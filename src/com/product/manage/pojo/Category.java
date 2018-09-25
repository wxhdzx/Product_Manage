package com.product.manage.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "tb_category")
public class Category {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cId;

    private String cName;
    private Set<Product> products=new  HashSet<>();
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
    
   
    
	
    
}