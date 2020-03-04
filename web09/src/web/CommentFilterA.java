package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilterA implements Filter{
	private FilterConfig config;
    /**
     * 容器启动后，会立即创建过滤器对象。
     * 只会创建一个。
     */
	public CommentFilterA(){
		System.out.println("filerA的构造器..."); 
	}
	
	public void destroy() {
		
	}
    /**
     * 容器调用doFilter方法来处理请求。
     * 容器会将request和response作为参数传递进来。
     * FilterChain(过滤器链)。
     * 如果调用了FilterChain的doFilter方法，
     * 则容器会继续向后调用。
     */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("filterA的doFilter方法开始执行...");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//读取初始化参数
		String illegalStr = config.getInitParameter("illegalStr");
		if(content.indexOf(illegalStr) != -1){
			//包含了敏感字
			out.println("<h1>评论内容包含了敏感字</h1>");
		}else{
			//继续向后调用
			arg2.doFilter(arg0, arg1);
		}
		System.out.println("filterA的doFilter方法执行完毕...");
	}
    /**
     * 容器在创建好过滤器对象之后，接下来会调用该对象的init方法。
     * 该方法只会执行一次。
     */
	public void init(FilterConfig arg0) throws ServletException {
		//将容器传递过来的FilterConfig对象保存下来
		config = arg0;
		System.out.println("filterA的init方法...");
	}

}
