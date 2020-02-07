package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Find_addCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			//有cookie,则需要查找
			boolean flag = false;
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				if("items".equals(c.getName())){
					//找到了名称为items的cookie
					out.println(c.getValue());
					flag = true;
				}
			}
			if(!flag){
				//没有找到名称为items的cookie
				Cookie c = new Cookie("items","123");
				response.addCookie(c);
			}
		}else{
			//没有找到任何的cookie
			Cookie c = new Cookie("items","123");
			response.addCookie(c);
		}
		out.close();
	}

}
