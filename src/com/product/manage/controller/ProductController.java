package com.product.manage.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.manage.pojo.Category;
import com.product.manage.pojo.Product;
import com.product.manage.service.CategoryService;
import com.product.manage.service.ProductService;
import com.product.manage.util.PageBean;
import com.product.manage.util.PicUploadResult;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value="list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="1")Integer currentPage,@RequestParam(defaultValue="5")Integer pageSize,Integer minprice,Integer maxprice,String pName) {
		 PageBean pb = productService.queryAllPage(currentPage, pageSize,minprice,maxprice,pName);
		 request.getSession().setAttribute("pb",pb);
		 return "index";
	}
	//跳向添加界面
	@RequestMapping("add")
	public String toAdd(HttpServletRequest request) {
	/*	List<String> cName = categoryService.queryName();
		request.setAttribute("cName",cName);*/
		 List<Category> list = categoryService.queryAll();
		 request.getSession().setAttribute("list",list);
		
		return "add";
	}
	//删除页面
	@RequestMapping("delete")
	public String delete(Integer pId) {
		productService.deleteById(pId);
		return "redirect:list.do";
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(Product product,@RequestParam("file")List<MultipartFile> file) {
		product.setpDate(new Date());
		String filename =null;
		// 判断所上传文件是否存在
		if (!file.isEmpty() &&file.size() > 0) {
			//循环输出上传的文件
			for (MultipartFile files :file) {
				// 获取上传文件的原始名称
				PicUploadResult fileUploadResult = new PicUploadResult();
				filename = files.getOriginalFilename();
				// 设置上传文件的保存地址目录
				String newPath = getFilePath(files.getOriginalFilename());
				 // 生成图片的绝对引用地址
		         String picUrl = StringUtils.replace(StringUtils.substringAfter(newPath,"E:\\product_manage\\upload"),
		                "\\", "/");
		        //fileUploadResult.setUrl("http://image.manage.com" + picUrl);
		        
		        File filePath = new File(newPath);
				
				// 如果保存文件的地址不存在，就先创建目录
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				try {
					// 使用MultipartFile接口的方法完成文件上传到指定位置
					files.transferTo(filePath);
				} catch (Exception e) {
					e.printStackTrace();
                      
				}
				
			}
			}
		product.setpImage(filename);
		productService.saveProduct(product);
		return "redirect:list.do";
	}
	
	private String getFilePath(String sourceFileName) {
		// TODO Auto-generated method stub
		  String baseFolder = "E:\\\\product_manage\\\\upload" + File.separator + "images";
	      Date nowDate = new Date();
	        // yyyy/MM/dd
	        String fileFolder = baseFolder + File.separator + new DateTime(nowDate).toString("yyyy")
	                + File.separator + new DateTime(nowDate).toString("MM") + File.separator
	                + new DateTime(nowDate).toString("dd");
	        File file = new File(baseFolder);
	        if (!file.isDirectory()) {
	            // 如果目录不存在，则创建目录
	            file.mkdirs();
	        }
	        // 生成新的文件名
	        String fileName =sourceFileName;
	               //RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
	       // System.out.println(fileName);
	        return fileFolder + File.separator + fileName;
	    }


	
	//根据id查找该商品
	@RequestMapping("toUpdate")
	public String findById(Integer pId,HttpServletRequest request) {
		Product product = productService.selectById(pId);
		request.getSession().setAttribute("product",product);
		
		 List<Category> list = categoryService.queryAll();
		 request.getSession().setAttribute("list",list);
		return "update";
	}
	//修改商品数据
	@RequestMapping("update")
	public String update(Product product,@RequestParam("file")List<MultipartFile> file) {
		String filename =null;
		// 判断所上传文件是否存在
		if (!file.isEmpty() &&file.size() > 0) {
			//循环输出上传的文件
			for (MultipartFile files :file) {
				// 获取上传文件的原始名称
				PicUploadResult fileUploadResult = new PicUploadResult();
				filename = files.getOriginalFilename();
				// 设置上传文件的保存地址目录
				String newPath = getFilePath(files.getOriginalFilename());
				 // 生成图片的绝对引用地址
		         String picUrl = StringUtils.replace(StringUtils.substringAfter(newPath,"E:\\product_manage\\upload"),
		                "\\", "/");
		        //fileUploadResult.setUrl("http://image.manage.com" + picUrl);
		        
		        File filePath = new File(newPath);
				
				// 如果保存文件的地址不存在，就先创建目录
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				try {
					// 使用MultipartFile接口的方法完成文件上传到指定位置
					files.transferTo(filePath);
				} catch (Exception e) {
					e.printStackTrace();
                      
				}
				
			}
			}
		product.setpImage(filename);
		productService.updateById(product);
		return "redirect:list.do";
	}
}
