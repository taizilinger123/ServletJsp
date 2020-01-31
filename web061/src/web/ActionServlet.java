package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//���������Դ·��
		String uri = request.getRequestURI();
		//����������Դ·��
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		//���ݷ����Ľ�������ò�ͬ�ķ�֧����
		if(action.equals("/list")){
			try {
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees =
					dao.findAll();
				//ʹ��ת����������ת����empList.jsp
				//step1,������
				request.setAttribute("emplist",
						employees);
				//step2,���ת����
				RequestDispatcher rd = 
					request.getRequestDispatcher(
							"empList.jsp");
				//step3,ת��
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
//				request.setAttribute("error_msg",
//						"ϵͳ��æ���Ժ�����");
//				request.getRequestDispatcher(
//						"error.jsp")
//				.forward(request, response);
				//���쳣�׸�����
				throw new ServletException(e);
				}
		}else if(action.equals("/add")){
			//��ȡԱ����Ϣ
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			/* �ڷ������ˣ�ͨ����Ҫ���������ֵ�����,
			 * ���磬���name�Ƿ�Ϊnull���߿��ַ���,
			 * �˴���ʱ������
			 */
			//���Ա����Ϣ
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				//����־
				e.printStackTrace();
				/*���쳣�Ƿ��ܹ��ָ�,������ܹ�
				 * �ָ�(���磬���ݿ����ֹͣ�������ж�
				 * �Ȳ������쳣,һ���֮Ϊϵͳ�쳣)��
				 * ����ʾ�û��Ժ����ԡ�
				 * 
				 */
				throw new ServletException(e);
			}
		}else if(action.equals("/del")){
			int id = Integer.parseInt(
					request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				dao.delete(id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/load")){
			int id = Integer.parseInt(
					request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = dao.findById(id);
				//ʹ��ת����ת����updateEmp.jsp
				request.setAttribute("e", e);
				request.getRequestDispatcher(
						"updateEmp.jsp")
				.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/modify")){
			int id = 
				Integer.parseInt(
						request.getParameter("id"));
			String name = 
				request.getParameter("name");
			String salary = 
				request.getParameter("salary");
			String age = request.getParameter("age");
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.modify(e);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}

}
