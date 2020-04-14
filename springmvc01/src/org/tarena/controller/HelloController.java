package org.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");//������ͼ����
		//����Ҫ����JSPҳ���ģ������
		mav.getModel().put("msg", "ģ������");//����Ҫ����ȥ��ģ������
		//�ȼ���request.setAttribute("msg","ģ������");
		return mav;
	}
    
}

