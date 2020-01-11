package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class AddEmpServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   request.setCharacterEncoding("utf-8");
	   String name = request.getParameter("name");
	   String salary = request.getParameter("salary");
	   String age = request.getParameter("age");
	   /*
	    * ���������һ��Ҫ���Ϸ��Եļ�飬(��ʱ����)
	    */
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
       //��Ա����Ϣ���뵽���ݿ�
	   try {
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			e.setName(name);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			dao.save(e);
			response.sendRedirect("list");
	} catch (Exception e) {
			e.printStackTrace();
			out.println("ϵͳ��æ�����Ժ�����");
	}
	out.close();
   }
}