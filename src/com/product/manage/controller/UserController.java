package com.product.manage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.product.manage.pojo.User;
import com.product.manage.service.UserService;

@Controller
/*
 * 用户实现登录注册功能
  */
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String toLogin(String uName,String uPassword,HttpServletRequest request) {
		User record=new User();
		record.setuName(uName);
		record.setuPassword(uPassword);;
		User user = userService.queryByRecord(record);
		if(user!=null) {
			//将user保存到session中
			request.getSession().setAttribute("user",user);
			//跳转到主界面
			return "index";
		}
		request.setAttribute("message","用户名或者密码错误");
		return "login";
	}
	/*
	 * 注册功能
	 * */
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(User user,HttpServletRequest request) {
		Integer i = userService.save(user);
		if(i>0) {
			//调向登录界面
			request.setAttribute("message","注册成功,请登录");
			return "login";
		}
		return "register";
	}
	//登录界面
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	//退出登录
	@RequestMapping("logout")
	public String logou(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}
}
