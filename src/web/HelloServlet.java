package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   //��ȡ�������ֵ
	   String qty = request.getParameter("qty");
	   /*
	    * ͨ����Ҫ���������ֵ��һЩ��飬���磬���qty�ǲ���һ���Ϸ������֡�
	    */
	   //����
	   String greeting = "";
	   for(int i=0;i<Integer.parseInt(qty);i++){		    greeting += "<h1>���ҳ�������</h1>";
	   }
	   //���÷��������ص���������
	   //unicode --->gbk,utf-8  ����
	   //gbk--->unicode  ����
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   //outĬ������£���ʹ��"iso-8859-1"������
	   out.println(greeting);
	   out.close();
   }
}

//http://localhost:8080/web01/hello?qty=8
//http://localhost:8888/web02/hello.html