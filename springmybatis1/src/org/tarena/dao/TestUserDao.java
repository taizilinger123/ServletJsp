package org.tarena.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.entity.User;

public class TestUserDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		UserDao userDao = ac.getBean("userDao",UserDao.class);
        User user = userDao.findByName("king");
        if(user != null){
        	System.out.println(user.getPwd());
        }else{
        	System.out.println("用户名不对");
        }
	}
}
