package org.tarena.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.entity.User;
@Controller
public class ListController {
	
	@RequestMapping("/list.do")
    public String execute(ModelMap model){
    	List<User>  list = new ArrayList<User>();
    	for(int i=0;i<10;i++){
    		User user = new User();
    		user.setUsername("tom"+i);
    		user.setPassword("1234"+i);
    		list.add(user);
    	}
    	model.put("users", list);
    	return "list";
    }
}
