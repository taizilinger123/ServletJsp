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
		result.setData(user.getCn_user_id());//返回user_id
		return result;
	}

	public NoteResult regist(String name, String password, String nickname) throws Exception {
		NoteResult result = new NoteResult();
		//检测用户名是否被占用
		User has_user = userDao.findByName(name);
		if(has_user != null){
			result.setStatus(1);
			result.setMsg("用户名已被占用");
			return result;
		}
		//注册
		User user = new User();
		user.setCn_user_name(name);//设置用户名
		user.setCn_user_nick(nickname);//设置昵称
		String md5_pwd = NoteUtil.md5(password);
		user.setCn_user_password(md5_pwd);//设置加密后的密码
		String userId = NoteUtil.createId();
		user.setCn_user_id(userId);//设置ID
		//调用userDao保存
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}

}
