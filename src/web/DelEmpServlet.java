package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelEmpServlet  extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
       //读取要删除的员工的id
	   int id = Integer.parseInt(request.getParameter("id"));
	   //删除指定id的记录
	   Connection conn = null;
	   PreparedStatement prep = null;
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd1507db","root","123456");
	    prep = conn.prepareStatement("DELETE FROM emp WHERE id=?");
	    prep.setInt(1, id);
	    prep.executeUpdate();
	    //重定向到员工列表
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