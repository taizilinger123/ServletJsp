package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyEmpServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{ 
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
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
		response.sendRedirect("list");
	} catch (Exception e) {
		e.printStackTrace();
		out.println("系统繁忙，请稍后重试");
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