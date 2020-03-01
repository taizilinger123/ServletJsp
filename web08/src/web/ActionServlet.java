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
        	  //�ȱȽ���֤���Ƿ���ȷ
        	  String number1 = request.getParameter("number");
          	  HttpSession session = request.getSession();
          	  String number2 = (String)session.getAttribute("number");
          	  if(!number1.equalsIgnoreCase(number2)){
          		  //��֤�����
          		  request.setAttribute("number_error","��֤�����");
          		  request.getRequestDispatcher("login.jsp").forward(request, response);
          		  return;
          	  }
        	  //��ȡ�û���������
        	  String username = request.getParameter("username");     
        	  String pwd = request.getParameter("pwd");
        	  //�����û��������룬��ѯ���ݿ����Ƿ��ж�Ӧ�ļ�¼
        	  UserDAO dao = new UserDAO();
        	  try {
				User user = dao.findByUsername(username);
				if(user != null && user.getPwd().equals(pwd)){
					//�з��������ļ�¼�����½�ɹ�
					//��¼�ɹ�����һЩ���ݰ󶩵�session������					
					session.setAttribute("user", user);
					response.sendRedirect("success.jsp");
				}else{
					//��¼ʧ�ܣ����û���Ӧ��ʾ
					request.setAttribute("login_failed","�û������������");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
          }
	}

}
