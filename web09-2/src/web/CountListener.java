package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener{
    /**
     * session���󴴽�֮����������ô˷�����
     */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session������");
		HttpSession session = arg0.getSession();
		ServletContext ctx = session.getServletContext();
		Integer count = (Integer)ctx.getAttribute("count");
		if(count == null){
			count = 1;
		}else{
			count ++;
		}
		ctx.setAttribute("count", count);
	}
    /**
     * session��������֮����������ô˷���
     */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session������");
		HttpSession session = arg0.getSession();
		ServletContext ctx = session.getServletContext();
		Integer count = (Integer)ctx.getAttribute("count");
		count --;
		ctx.setAttribute("count", count);
	}

}
