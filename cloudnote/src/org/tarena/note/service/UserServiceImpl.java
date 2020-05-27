package org.tarena.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.NoteResult;
import org.tarena.note.entity.User;

@Service//扫描Service组件
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;//注入

	public NoteResult checkLogin(String name, String pwd) {

		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		if(!user.getCn_user_password().equals(pwd)){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		return result;
	}

}
