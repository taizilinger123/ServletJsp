package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		String userlist = (String)ctx.getAttribute("userlist");
		out.println(userlist);
		//��ȡȫ�ֵĳ�ʼ������
		String company = ctx.getInitParameter("company");
		out.println(company);
		out.close();
	}
}
