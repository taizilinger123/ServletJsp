package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	   String ip = request.getRemoteAddr();
	   System.out.println(ip);
	   request.setCharacterEncoding("utf-8");
       String uri = request.getRequestURI();
       String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
       if("/list".equals(action)){
    	   //查询出所有的员工信息
    	   try {
    		EmployeeDAO  dao = new EmployeeDAO();
    		List<Employee> employees = dao.findAll();
    		//依据查询到的数据生成表格
    		//(转发给listEmp.jsp)
    		request.setAttribute("employees",employees);
    		RequestDispatcher rd = request.getRequestDispatcher("listEmp.jsp");
    		rd.forward(request, response);
//    		response.sendRedirect("listEmp.jsp");
    	   }catch(Exception e){
    		   e.printStackTrace();
    		   //转发到异常处理页面
//    		   request.setAttribute("msg","系统出错，请联系管理员");
//    		   request.getRequestDispatcher("error.jsp").forward(request, response);
    		   //交给容器来处理
    		   throw new ServletException(e);
    	   }	
       }else if("/add".equals(action)){ 	  
    	   String name = request.getParameter("name");
    	   String salary = request.getParameter("salary");
    	   String age = request.getParameter("age");
    	   /*
    	    * 对请求参数一定要做合法性的检查，(暂时不做)
    	    */
           //将员工信息插入到数据库
    	   try {
    			EmployeeDAO dao = new EmployeeDAO();
    			Employee e = new Employee();
    			e.setName(name);
    			e.setSalary(Double.parseDouble(salary));
    			e.setAge(Integer.parseInt(age));
    			dao.save(e);
    			response.sendRedirect("list.do");
    	} catch (Exception e) {
    			e.printStackTrace();
    			throw new ServletException(e);
    	 }
       }else if("/del".equals(action)){
           //读取要删除的员工的id
    	   int id = Integer.parseInt(request.getParameter("id"));
    	   //删除指定id的记录   	
    	   try {
   			    EmployeeDAO dao = new EmployeeDAO();
   			    dao.delete(id);
    	        response.sendRedirect("list.do");
    	   } catch (Exception e) {
    		   e.printStackTrace();
    		   throw new ServletException(e);
    	   }
       }else if("/load".equals(action)){
    	    //读取要修改的员工的id
    	   int id = Integer.parseInt(request.getParameter("id"));
    	   //查询出对应id的员工的信息
    	   try {
  			    EmployeeDAO dao = new EmployeeDAO();
  			    Employee e = dao.findById(id);
    	    //依据查询到的员工信息生成一个修改页面
    	    request.setAttribute("e", e);
    	    RequestDispatcher rd = request.getRequestDispatcher("updateEmp.jsp");
    	    rd.forward(request, response);
    	   } catch (Exception e) {
    		   e.printStackTrace();
    		   throw new ServletException(e);
          }
       }else if("/modify".equals(action)){
    	    int id = Integer.parseInt(request.getParameter("id"));
	   		String name = request.getParameter("name");
	   		String salary = request.getParameter("salary");
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
