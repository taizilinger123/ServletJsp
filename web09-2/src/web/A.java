package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class A extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//先获得上下文
		ServletContext ctx = getServletContext();
		//将一些数据绑订到上下文
		ctx.setAttribute("userlist","花千骨，白子画");
		//读取全局的初始化参数
		String company = ctx.getInitParameter("company");
		out.println(company);
		out.close();
	}
}
