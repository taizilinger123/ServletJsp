package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
      try {
		Thread.sleep(3000);
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
      response.setContentType("text/plain;charset=utf-8");
      PrintWriter out = response.getWriter();
      //���������������nameֵ
      request.setCharacterEncoding("utf-8");
      String name = request.getParameter("name");
      System.out.println("-------"+name);
      //���nameֵ�Ƿ����
      if("scott".equals(name)){
    	out.println("�û����ѱ�ռ��");  
      }else{
    	out.println("�û�������");  
      }
      out.flush();
      out.close();
    }
}
