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
		//获得请求资源路径
		String uri = request.getRequestURI();
		//分析请求资源路径
		String action = 
			uri.substring(uri.lastIndexOf("/"),
					uri.lastIndexOf("."));
		//依据分析的结果，调用不同的分支处理
		if(action.equals("/list")){
			try {
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees =
					dao.findAll();
				//使用转发，将处理转交给empList.jsp
				//step1,绑订数据
				request.setAttribute("emplist",
						employees);
				//step2,获得转发器
				RequestDispatcher rd = 
					request.getRequestDispatcher(
							"empList.jsp");
				//step3,转发
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
//				request.setAttribute("error_msg",
//						"系统繁忙，稍后重试");
//				request.getRequestDispatcher(
//						"error.jsp")
//				.forward(request, response);
				//将异常抛给容器
				throw new ServletException(e);
				}
		}else if(action.equals("/add")){
			//读取员工信息
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			/* 在服务器端，通常需要对请求参数值做检查,
			 * 比如，检查name是否为null或者空字符串,
			 * 此处暂时不做。
			 */
			//输出员工信息
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				//记日志
				e.printStackTrace();
				/*看异常是否能够恢复,如果不能够
				 * 恢复(比如，数据库服务停止，网络中断
				 * 等产生的异常,一般称之为系统异常)，
				 * 则提示用户稍后重试。
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
				//使用转发，转发给updateEmp.jsp
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
