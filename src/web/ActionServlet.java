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
 	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
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
    		   out.println("ϵͳ��æ���Ժ�����");
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
    			out.println("ϵͳ��æ�����Ժ�����");
    	 }
       }else if("/del".equals(action)){
           //��ȡҪɾ����Ա����id
    	   int id = Integer.parseInt(request.getParameter("id"));
    	   //ɾ��ָ��id�ļ�¼
    	   Connection conn = null;
    	   PreparedStatement prep = null;
    	   try {
    		Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd1507db","root","123456");
    	    prep = conn.prepareStatement("DELETE FROM emp WHERE id=?");
    	    prep.setInt(1, id);
    	    prep.executeUpdate();
    	    //�ض���Ա���б�
    	    response.sendRedirect("list.do");
    	   } catch (Exception e) {
    		   e.printStackTrace();
    		   out.println("ϵͳ��æ�����Ժ�����");
    	   }finally{
    			if(conn != null){
    				try {
    					conn.close();
    				} catch (SQLException e) {
    					e.printStackTrace();				
    				}
    			}		
    		}
       }else if("/load".equals(action)){
    	   int id = Integer.parseInt(request.getParameter("id"));
    		String name = request.getParameter("name");
    		String salary = request.getParameter("salary");
    		String age = request.getParameter("age");
    	   Connection conn = null;
    	   try {
    		Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd1507db","root","123456");
    		PreparedStatement stat = conn.prepareStatement("UPDATE emp SET name=?,salary=?,age=? WHERE id=?");
    		stat.setString(1, name);
    		stat.setDouble(2, Double.parseDouble(salary));
    		stat.setInt(3, Integer.parseInt(age));
    		stat.setInt(4, id);
    		stat.executeUpdate();
    		response.sendRedirect("list.do");
    	} catch (Exception e) {
    		e.printStackTrace();
    		out.println("ϵͳ��æ�����Ժ�����");
    	}finally{
    		if(conn != null){
    			try {
    				conn.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		 }		
    	  }
       }

	}

}
