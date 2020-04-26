package org.tarena.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver{
    
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object method, Exception e) {
		//���쳣��Ϣд���ļ�
		System.out.println("���쳣��Ϣд���ļ�:"+e);
		//��ת������ҳ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		return mav;
	}
   
}
