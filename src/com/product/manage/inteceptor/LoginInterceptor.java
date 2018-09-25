package com.product.manage.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.product.manage.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
	    throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
	    throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
			//判断用户是否登陆  如果没有登陆  重定向到登陆页面   不放行   如果登陆了  就放行了
			// URL  http://localhost:8080/springmvc-mybatis/login.action
			//URI /login.action
		/*	String requestURI = request.getRequestURI();
			if(!requestURI.contains("/login")){
				String username = (String) request.getSession().getAttribute("user");
				if(null == username){
					response.sendRedirect(request.getContextPath() + "/toLogin.do");
					return false;
				}
			}
			return true;*/
		String url = request.getRequestURI();
		if(url.indexOf("/login.do")>=0||url.indexOf("/register.do")>=0) {
			return true;
		}
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		if(user!=null) {
			return true;
		}
		request.setAttribute("message","还没有登录,请先登录");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		return false;
	}
	
}
