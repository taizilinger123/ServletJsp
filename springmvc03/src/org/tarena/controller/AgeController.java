package org.tarena.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgeController {
	
  @RequestMapping("/toage.do")
  public String toage(){
	  return "age";//����age.jsp
  }
  
  @RequestMapping("/age.do")
  public String age(String birth,ModelMap model) throws Exception{
	  //�����û���������գ���������
	 Date now = new Date();
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 Date birth1 = sdf.parse(birth);
     int result = now.getYear()-birth1.getYear();
	 model.put("msg", "����Ϊ:"+result);
	 return "age";//����age.jsp,${msg}
      
  }
  
  //��ǰController�쳣����,ִ�и÷����󣬲����ٵ���ExceptionResolver
  @ExceptionHandler//�ֲ��쳣������
  public String handleException(HttpServletRequest request, Exception e){
	 request.setAttribute("msg","������Ϣ�����¼���ʧ��");
	 return "age";//����age.jsp
  }
  
}
