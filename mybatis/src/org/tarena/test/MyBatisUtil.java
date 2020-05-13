package org.tarena.test;

import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	public static SqlSession getSqlSession(){
		   SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		   //加载SqlMapConfig.xml文件
		   String conf = "SqlMapConfig.xml";
		   //Reader reader = Resources.getResourceAsReader(conf);
		   InputStream confStream = MyBatisUtil.class.getClassLoader().getResourceAsStream(conf);
		   //获取SqlSessionFactory
		   //SqlSessionFactory factory = builder.build(conf);
		   SqlSessionFactory factory = builder.build(confStream);
	       //获取SqlSession
		   SqlSession session = factory.openSession();
		   return session;
	}
}
