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
	    response.sendRedirect("list");
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