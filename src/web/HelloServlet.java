package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   //request.setCharacterEncoding("utf-8");
	   //读取请求参数值
	   String qty = request.getParameter("qty");
	   String uname = request.getParameter("uname");
	   uname = new String(uname.getBytes("iso-8859-1"),"utf-8");
	   /*
	    * 通常需要对请求参数值做一些检查，比如，检查qty是不是一个合法的数字。
	    */
	   //处理
	   String greeting = "";
	   for(int i=0;i<Integer.parseInt(qty);i++){		    
		   greeting += "<h1>你好，" + uname + "</h1>";
	   }
	   //设置服务器返回的数据类型
	   //unicode --->gbk,utf-8  编码
	   //gbk--->unicode  解码
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   //out默认情况下，会使用"iso-8859-1"来编码
	   out.println(greeting);
	   out.close();
   }
}

//http://localhost:8080/web01/hello?qty=8
//http://localhost:8888/web02/hello.html