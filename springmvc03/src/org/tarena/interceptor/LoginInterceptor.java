package org.tarena.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
    //��������ϣ����֮ǰ
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--afterCompletion--");
		
	}
    //controller֮��
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--postHandle--");
		
	}
    //controller֮ǰ
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("--preHandleʵ�ֵ�¼���--");
		HttpSession session = request.getSession();
		//��ȡ��¼�ɹ�����õ��û���Ϣ
		String name = (String)session.getAttribute("username");
		if(name != null){//��¼��
			return true;//����ִ��mvc��������
		}else{//δ��¼���¼ʧЧ
			response.sendRedirect("tologin.do");
			return false;//��ֹmvc��������
		}
		
	}
    
}
