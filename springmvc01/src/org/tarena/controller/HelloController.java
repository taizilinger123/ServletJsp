package org.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");//设置视图名字
		//设置要传到JSP页面的模型数据
		mav.getModel().put("msg", "模型数据");//设置要传出去的模型数据
		//等价于request.setAttribute("msg","模型数据");
		return mav;
	}
    
}

