package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        System.out.println("actionServlet's  service...");	
        //���������Դ·��
        String uri = request.getRequestURI();
        System.out.println(uri);
        //����������Դ·��
        String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
        System.out.println(action);
        if("/list".equals(action)){
        	System.out.println("Ա���б�");
        }else if("/add".equals(action)){
        	System.out.println("���Ա��");
        }
	}
}
