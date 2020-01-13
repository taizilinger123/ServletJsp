package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SomeServlet extends HttpServlet {
	public SomeServlet(){
	   System.out.println("someServlet's constructor...");	
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("someServlet's init...");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	    doGet(request, response);	     
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		System.out.println("someServlet's doGet...");	
		ServletConfig config = getServletConfig();
		String company = config.getInitParameter("company");
		System.out.println(company);
	}

	@Override
	public void destroy() {
       System.out.println("someServlet's destroy...");
	}

//	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
//		System.out.println("someServlet's service...");	
//		ServletConfig config = getServletConfig();
//		String company = config.getInitParameter("company");
//		System.out.println(company);
//	}
	
}
