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
	    * ���������һ��Ҫ���Ϸ��Եļ�飬(��ʱ����)
	    */
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
       //��Ա����Ϣ���뵽���ݿ�
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
		out.println("��ӳɹ�<br/><br/>");
		out.println("<a href='list'>Ա���б�</a>");
	} catch (Exception e) {
		/*
		 * step1,����־
		 */
		e.printStackTrace();
		/*
		 * step2,���쳣�Ƿ��ܹ��ָ�,����ܹ��ָ��������ָ���������ָܻ�(���磬���ݿ������ͣ,
		 * �����жϵȣ��������쳣һ���֮Ϊϵͳ�쳣)������ʾ�û��Ժ����ԡ�
		 */
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
	out.close();
   }
}

//http://localhost:8080/web03/addEmp.html