package com.product.manage.pojo;

import java.util.Date;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;
   
    private String pName;

    private Double pPrice;

    private String pImage;

    private Date pDate;

    private String pDesc;
    
    private Integer pCid;
    private Integer pNumber;
    private Category category=new Category();
    
    private Integer currentPage;
    private Integer pageSize;

	private Integer start;
    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage == null ? null : pImage.trim();
    }

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc == null ? null : pDesc.trim();
    }

    public Integer getpCid() {
        return pCid;
    }

    public void setpCid(Integer pCid) {
        this.pCid = pCid;
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }
    
    
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}