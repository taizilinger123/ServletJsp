package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   request.setCharacterEncoding("utf-8");
	   String name = request.getParameter("name");
	   String salary = request.getParameter("salary");
	   String age = request.getParameter("age");
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   out.println(name+" "+salary+ " "+age);
	   out.close();
   }
}

//http://localhost:8080/web02/addEmp.html