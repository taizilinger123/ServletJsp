package org.tarena.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	 public static SqlSession getSession(){
		 //SqlSessionFactoryBuilder
		 SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		 InputStream in =  MyBatisUtil.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
		 //SqlSessionFactory
		 SqlSessionFactory factory = builder.build(in);
		 //SqlSession
		 SqlSession session = factory.openSession();
		 return session;
	 }
  
}
