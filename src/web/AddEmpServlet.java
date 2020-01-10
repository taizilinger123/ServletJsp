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

public class AddEmpServlet extends HttpServlet{
   public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	   request.setCharacterEncoding("utf-8");
	   String name = request.getParameter("name");
	   String salary = request.getParameter("salary");
	   String age = request.getParameter("age");
	   /*
	    * 对请求参数一定要做合法性的检查，(暂时不做)
	    */
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
       //将员工信息插入到数据库
	   Connection conn = null;
	   PreparedStatement prep = null;
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd1507db","root","123456");
		prep = conn.prepareStatement("INSERT INTO " +
				"emp(name,salary,age) " +
				"VALUES(?,?,?)");
		prep.setString(1, name);
		prep.setDouble(2, Double.parseDouble(salary));
		prep.setInt(3, Integer.parseInt(age));
		prep.executeUpdate();
//		out.println("添加成功<br/><br/>");
//		out.println("<a href='list'>员工列表</a>");
		response.sendRedirect("list");
		System.out.println("重定向之后的代码会执行...");
	} catch (Exception e) {
		/*
		 * step1,记日志
		 */
		e.printStackTrace();
		/*
		 * step2,看异常是否能够恢复,如果能够恢复则立即恢复，如果不能恢复(比如，数据库服务暂停,
		 * 网络中断等，这样的异常一般称之为系统异常)，则提示用户稍后重试。
		 */
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
	out.close();
   }
}

//http://localhost:8080/web03/addEmp.html