package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		//要注意该方法有可能返回null
		if(cookies != null){
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				String name = c.getName();
				String value = c.getValue();
				out.println(name +" "+ value+"<br/>");
			}
		}else{
			out.println("找不到任何的cookie");
		}
		out.close();
	}

}
