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
		//�Ȼ��������
		ServletContext ctx = getServletContext();
		//��һЩ���ݰ󶩵�������
		ctx.setAttribute("userlist","��ǧ�ǣ����ӻ�");
		//��ȡȫ�ֵĳ�ʼ������
		String company = ctx.getInitParameter("company");
		out.println(company);
		out.close();
	}
}
