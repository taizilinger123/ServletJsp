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
	   for(int i=0;i<Integer.parseInt(qty);i++){
		    greeting += "<h1>hello Kitty</h1>";
	   }
	   //���÷��������ص���������	
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   out.println(greeting);
	   out.close();
   }
}

//http://localhost:8080/web01/hello?qty=8