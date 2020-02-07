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
			//��cookie,����Ҫ����
			boolean flag = false;
			for(int i=0;i<cookies.length;i++){
				Cookie c = cookies[i];
				if("items".equals(c.getName())){
					//�ҵ�������Ϊitems��cookie
					out.println(c.getValue());
					flag = true;
				}
			}
			if(!flag){
				//û���ҵ�����Ϊitems��cookie
				Cookie c = new Cookie("items","123");
				response.addCookie(c);
			}
		}else{
			//û���ҵ��κε�cookie
			Cookie c = new Cookie("items","123");
			response.addCookie(c);
		}
		out.close();
	}

}
