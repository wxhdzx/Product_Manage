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
	//������ӽ���
	@RequestMapping("add")
	public String toAdd(HttpServletRequest request) {
	/*	List<String> cName = categoryService.queryName();
		request.setAttribute("cName",cName);*/
		 List<Category> list = categoryService.queryAll();
		 request.getSession().setAttribute("list",list);
		
		return "add";
	}
	//ɾ��ҳ��
	@RequestMapping("delete")
	public String delete(Integer pId) {
		productService.deleteById(pId);
		return "redirect:list.do";
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(Product product,@RequestParam("file")List<MultipartFile> file) {
		product.setpDate(new Date());
		String filename =null;
		// �ж����ϴ��ļ��Ƿ����
		if (!file.isEmpty() &&file.size() > 0) {
			//ѭ������ϴ����ļ�
			for (MultipartFile files :file) {
				// ��ȡ�ϴ��ļ���ԭʼ����
				PicUploadResult fileUploadResult = new PicUploadResult();
				filename = files.getOriginalFilename();
				// �����ϴ��ļ��ı����ַĿ¼
				String newPath = getFilePath(files.getOriginalFilename());
				 // ����ͼƬ�ľ������õ�ַ
		         String picUrl = StringUtils.replace(StringUtils.substringAfter(newPath,"E:\\product_manage\\upload"),
		                "\\", "/");
		        //fileUploadResult.setUrl("http://image.manage.com" + picUrl);
		        
		        File filePath = new File(newPath);
				
				// ��������ļ��ĵ�ַ�����ڣ����ȴ���Ŀ¼
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				try {
					// ʹ��MultipartFile�ӿڵķ�������ļ��ϴ���ָ��λ��
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
	            // ���Ŀ¼�����ڣ��򴴽�Ŀ¼
	            file.mkdirs();
	        }
	        // �����µ��ļ���
	        String fileName =sourceFileName;
	               //RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
	       // System.out.println(fileName);
	        return fileFolder + File.separator + fileName;
	    }


	
	//����id���Ҹ���Ʒ
	@RequestMapping("toUpdate")
	public String findById(Integer pId,HttpServletRequest request) {
		Product product = productService.selectById(pId);
		request.getSession().setAttribute("product",product);
		
		 List<Category> list = categoryService.queryAll();
		 request.getSession().setAttribute("list",list);
		return "update";
	}
	//�޸���Ʒ����
	@RequestMapping("update")
	public String update(Product product,@RequestParam("file")List<MultipartFile> file) {
		String filename =null;
		// �ж����ϴ��ļ��Ƿ����
		if (!file.isEmpty() &&file.size() > 0) {
			//ѭ������ϴ����ļ�
			for (MultipartFile files :file) {
				// ��ȡ�ϴ��ļ���ԭʼ����
				PicUploadResult fileUploadResult = new PicUploadResult();
				filename = files.getOriginalFilename();
				// �����ϴ��ļ��ı����ַĿ¼
				String newPath = getFilePath(files.getOriginalFilename());
				 // ����ͼƬ�ľ������õ�ַ
		         String picUrl = StringUtils.replace(StringUtils.substringAfter(newPath,"E:\\product_manage\\upload"),
		                "\\", "/");
		        //fileUploadResult.setUrl("http://image.manage.com" + picUrl);
		        
		        File filePath = new File(newPath);
				
				// ��������ļ��ĵ�ַ�����ڣ����ȴ���Ŀ¼
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				try {
					// ʹ��MultipartFile�ӿڵķ�������ļ��ϴ���ָ��λ��
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
