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
    
	//ÿ�ε����ط���
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		   //ǰ���߼�
		   request.setCharacterEncoding("UTF-8");
		   chain.doFilter(request, response);//����servlet
		   //�����߼�
		
	}
    //����Tomcat������ʱ������web.xml��Filter����
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
