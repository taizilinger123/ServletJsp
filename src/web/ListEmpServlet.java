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

public class ListEmpServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	  //查询出所有的员工信息
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   Connection conn = null;
	   PreparedStatement prep = null;
	   ResultSet rst = null;
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd1507db","root","123456");
		prep = conn.prepareStatement("SELECT * FROM emp");
		rst = prep.executeQuery();
		//依据查询到的数据生成表格
		out.println("<table border='1' width='60%' cellpadding='0' cellspacing='0'>");
		out.println("<tr><td>ID</td><td>姓名</td><td>薪水</td><td>年龄</td></tr>");
		while(rst.next()){
			int id = rst.getInt("id");
			String name = rst.getString("name");
			double salary = rst.getDouble("salary");
			int age = rst.getInt("age");
			out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+salary+"</td><td>"+age+"</td></tr>");
		}
		out.println("</table><br/><br/>");
		out.println("<a href='addEmp.html'>添加员工</a>");
	   }catch(Exception e){
		   e.printStackTrace();
		   out.println("系统繁忙，稍后重试");
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