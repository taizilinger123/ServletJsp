package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class DemoServlet extends  HttpServlet{

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		  System.out.println("-------DemoServlet------");
		  res.setContentType("text/plain;charset=utf-8");
          PrintWriter out  = res.getWriter();
          out.println("上证指数:3560");
          out.flush();
          out.close();
	} 
}
