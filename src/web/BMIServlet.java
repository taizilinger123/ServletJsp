package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServlet extends HttpServlet{
	   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   		//��ȡ�������ֵ
		    String weight = request.getParameter("weight");
	   		String height = request.getParameter("height");
	   		//��һЩ����
	   		double bmi = Double.parseDouble(weight)/Double.parseDouble(height)/Double.parseDouble(height);
	   		//���
	   		response.setContentType("text/html");
	   		PrintWriter out = response.getWriter();	   		
	   		out.println(bmi);
	   	    //�������Զ��ر�out
	   		//out.close();
	}
}

//http://localhost:8080/web01-lab/bmi?weight=60&height=1.7