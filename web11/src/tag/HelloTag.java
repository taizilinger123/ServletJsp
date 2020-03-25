package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ��ǩ��
 *   1.�̳�SimpleTagSupport��
 *   2.override doTag����
 *   3.��ǩ����Щ���ԣ���ǩ��Ҳ��Ҫ��Ӧ������
 *     a.Ҫ��������һ��
 *     b.����Ҫƥ��
 *     c.Ҫ�ж�Ӧ��set������
 * @author sige
 *
 */
public class HelloTag extends SimpleTagSupport{
	private String msg;
	private int qty;
	
	public HelloTag(){
	  System.out.println("HelloTag�Ĺ�����...");	
	}
	
	public void setMsg(String msg) {
		System.out.println("setMsg����..." + msg);
		this.msg = msg;
	}

	public void setQty(int qty) {
		System.out.println("setQty����..." + qty);
		this.qty = qty;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag����...");
		/*
		 * SimpleTagSupport���ṩ��һ�����������pageContext,pageContext�ṩ��
		 * һЩ������������е���������
		 */
		PageContext ctx = (PageContext)getJspContext();
		JspWriter out = ctx.getOut();
        for(int i = 0; i < qty; i++){
      	  out.println(msg + "<br/>");
        }
	}
  
}
