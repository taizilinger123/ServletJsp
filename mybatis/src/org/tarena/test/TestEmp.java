package org.tarena.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestEmp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	   SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	   //加载SqlMapConfig.xml文件
	   String conf = "SqlMapConfig.xml";
	   //Reader reader = Resources.getResourceAsReader(conf);
	   InputStream confStream = TestEmp.class.getClassLoader().getResourceAsStream(conf);
	   //获取SqlSessionFactory
	   SqlSessionFactory factory = builder.build(confStream);
       //获取SqlSession
	   SqlSession session = factory.openSession();
	   System.out.println("使用session操作");
	   session.close();//释放session
	}
}
