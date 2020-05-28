package org.tarena.note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.tarena.note.dao.UserDao;
import org.tarena.note.entity.NoteResult;
import org.tarena.note.entity.User;
import org.tarena.note.util.NoteUtil;

@Service//扫描Service组件
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;//注入

	public NoteResult checkLogin(String name, String pwd) throws Exception {

		NoteResult result = new NoteResult();
		User user = userDao.findByName(name);
		//如果user返回null,说明按name查询条件不满足，表示name不存在
		if(user == null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//如果user返回不为null,说明用户名正确，然后比对密码
		//将用户输入的pwd密码加密
		String md5_pwd = NoteUtil.md5(pwd);
		//与数据库密码比对
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("密码不正确");
			return result;
		}
		result.setStatus(0);
		result.setMsg("用户名和密码正确");
		return result;
	}

}
