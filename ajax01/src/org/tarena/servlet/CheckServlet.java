package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
      response.setContentType("text/plain;charset=utf-8");
      PrintWriter out = response.getWriter();
      //接收请求带过来的name值
      String name = request.getParameter("name");
      System.out.println("-------"+name);
      //检测name值是否可用
      if("scott".equals(name)){
    	out.println("用户名已被占用");  
      }else{
    	out.println("用户名可用");  
      }
      out.flush();
      out.close();
    }
}
