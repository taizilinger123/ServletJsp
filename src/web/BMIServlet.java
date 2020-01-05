package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet{
	   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   		//读取请求参数值
		    String weight = request.getParameter("weight");
	   		String height = request.getParameter("height");
	   		//做一些处理
	   		double bmi = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);
	   		//输出
	   		response.setContentType("text/html");
	   		PrintWriter out = response.getWriter();	   		
	   		out.println(bmi);
	   	    //容器会自动关闭out
	   		//out.close();
	}
}

//http://localhost:8080/web01-lab/bmi?weight=60&height=1.7