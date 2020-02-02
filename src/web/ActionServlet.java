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
	   request.setCharacterEncoding("utf-8");
       String uri = request.getRequestURI();
       String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
       if("/list".equals(action)){
    	   //��ѯ�����е�Ա����Ϣ
    	   try {
    		EmployeeDAO  dao = new EmployeeDAO();
    		List<Employee> employees = dao.findAll();
    		//���ݲ�ѯ�����������ɱ��
    		//(ת����listEmp.jsp)
    		request.setAttribute("employees",employees);
    		RequestDispatcher rd = request.getRequestDispatcher("listEmp.jsp");
    		rd.forward(request, response);
    	   }catch(Exception e){
    		   e.printStackTrace();
    		   //ת�����쳣����ҳ��
//    		   request.setAttribute("msg","ϵͳ��������ϵ����Ա");
//    		   request.getRequestDispatcher("error.jsp").forward(request, response);
    		   //��������������
    		   throw new ServletException(e);
    	   }	
       }else if("/add".equals(action)){ 	  
    	   String name = request.getParameter("name");
    	   String salary = request.getParameter("salary");
    	   String age = request.getParameter("age");
    	   /*
    	    * ���������һ��Ҫ���Ϸ��Եļ�飬(��ʱ����)
    	    */
           //��Ա����Ϣ���뵽���ݿ�
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
           //��ȡҪɾ����Ա����id
    	   int id = Integer.parseInt(request.getParameter("id"));
    	   //ɾ��ָ��id�ļ�¼   	
    	   try {
   			    EmployeeDAO dao = new EmployeeDAO();
   			    dao.delete(id);
    	        response.sendRedirect("list.do");
    	   } catch (Exception e) {
    		   e.printStackTrace();
    		   throw new ServletException(e);
    	   }
       }else if("/load".equals(action)){
    	    //��ȡҪ�޸ĵ�Ա����id
    	   int id = Integer.parseInt(request.getParameter("id"));
    	   //��ѯ����Ӧid��Ա������Ϣ
    	   try {
  			    EmployeeDAO dao = new EmployeeDAO();
  			    Employee e = dao.findById(id);
    	    //���ݲ�ѯ����Ա����Ϣ����һ���޸�ҳ��
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
