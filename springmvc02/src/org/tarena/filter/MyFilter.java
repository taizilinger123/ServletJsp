package org.tarena.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
    
	//每次的拦截方法
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		   //前期逻辑
		   request.setCharacterEncoding("UTF-8");
		   chain.doFilter(request, response);//调用servlet
		   //后期逻辑
		
	}
    //启动Tomcat服务器时，加载web.xml里Filter配置
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
