package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 标签类
 *   1.继承SimpleTagSupport类
 *   2.override doTag方法
 *   3.标签有哪些属性，标签类也有要对应的属性
 *     a.要求属性名一致
 *     b.类型要匹配
 *     c.要有对应的set方法。
 * @author sige
 *
 */
public class HelloTag extends SimpleTagSupport{
	private String msg;
	private int qty;
	
	public HelloTag(){
	  System.out.println("HelloTag的构造器...");	
	}
	
	public void setMsg(String msg) {
		System.out.println("setMsg方法..." + msg);
		this.msg = msg;
	}

	public void setQty(int qty) {
		System.out.println("setQty方法..." + msg);
		this.qty = qty;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag方法...");
		/*
		 * SimpleTagSupport类提供了一个方法来获得pageContext,pageContext提供了
		 * 一些方法来获得所有的隐含对象。
		 */
		PageContext ctx = (PageContext)getJspContext();
		JspWriter out = ctx.getOut();
        for(int i = 0; i < qty; i++){
      	  out.println(msg + "<br/>");
        }
	}
  
}
