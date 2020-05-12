package org.tarena.test;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;

public class TestEmp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
       SqlSession session = MyBatisUtil.getSqlSession();
	   System.out.println("使用session操作");
	   session.close();//释放session
	}
}
