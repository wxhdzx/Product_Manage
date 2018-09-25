package com.product.manage.controller;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
	@RequestMapping("/download")
	public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String pImage) throws Exception{
		  // ָ��Ҫ���ص��ļ�����·��
	    String path =pImage;
	    // �������ļ�����
	    File file = new File(path+File.separator+ pImage);
	    // ���ļ������룬��ֹ�����ļ�����
	    pImage = this.getFilename(request,pImage);
	    // ������Ӧͷ
	    HttpHeaders headers = new HttpHeaders();
	    // ֪ͨ����������صķ�ʽ���ļ�
	    headers.setContentDispositionFormData("attachment", pImage);
	    // ������������ʽ���ط����ļ�����
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    // ʹ��Sring MVC��ܵ�ResponseEntity�����װ������������
	   return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
	                                           headers,HttpStatus.OK);
	}
	/**
	 * ����������Ĳ�ͬ���б������ã����ر������ļ���
	 */
	public String getFilename(HttpServletRequest request,
	                                            String filename) throws Exception { 
	    // IE��ͬ�汾User-Agent�г��ֵĹؼ���
	    String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};  
	    // ��ȡ����ͷ������Ϣ
	    String userAgent = request.getHeader("User-Agent");  
	    for (String keyWord : IEBrowserKeyWords) { 
	         if (userAgent.contains(keyWord)) { 
	              //IE�ں��������ͳһΪUTF-8������ʾ
	              return URLEncoder.encode(filename, "UTF-8");
	         }
	    }  
	    //��������������ͳһΪISO-8859-1������ʾ
	    return new String(filename.getBytes("UTF-8"), "ISO-8859-1");  
	}  

	


}
