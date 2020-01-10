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

public class LoadEmpServlet  extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
       //读取要修改的员工的id
	   int id = Integer.parseInt(request.getParameter("id"));
	   //查询出对应id的员工的信息
	   Connection conn = null;
	   PreparedStatement prep = null;
	   ResultSet rst = null;
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd1507db","root","123456");
	    prep = conn.prepareStatement("SELECT * FROM emp WHERE id=?");
	    prep.setInt(1, id);
	    rst = prep.executeQuery();
	    //依据查询到的员工信息生成一个修改页面
	    if(rst.next()){
			String name = rst.getString("name");
			double salary = rst.getDouble("salary");
			int age = rst.getInt("age");
			out.println("<form action='modify' method='post'>");
			out.println("ID:" + id + "<br/>");
			out.println("姓名:<input name='name' value='" + name + "'/><br/>");
			out.println("薪水:<input name='salary' value='" + salary + "'/><br/>");
			out.println("年龄:<input name='age' value='" + age + "'/><br/>");
			out.println("<input type='hidden' name='id' value='" + id + "'/>");
			out.println("<input type='submit' value='确定'/>");
			out.println("</form>");
	    }
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