package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");
          String uri = request.getRequestURI();
          String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
          if("/login".equals(action)){
        	  //读取用户名和密码
        	  String username = request.getParameter("username");
        	  String pwd = request.getParameter("pwd");
        	  //依据用户名和密码，查询数据库中是否有对应的记录
        	  UserDAO dao = new UserDAO();
        	  try {
				User user = dao.findByUsername(username);
				if(user != null && user.getPwd().equals(pwd)){
					//有符合条件的记录，则登陆成功
					//登录成功，将一些数据绑订到session对象上
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("success.jsp");
				}else{
					//登录失败，给用户相应提示
					request.setAttribute("login_failed","用户名或密码错误");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
          }
	}

}
