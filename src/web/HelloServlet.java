package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   //���÷��������ص���������	
	   response.setContentType("text/html");
	   PrintWriter out = response.getWriter();
	   out.println("<h1 style='color:red;'>" +
	   		"Hello Kitty</h1>");
	   out.close();
   }
}
