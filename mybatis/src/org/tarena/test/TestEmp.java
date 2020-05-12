package org.tarena.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.tarena.entity.Emp;

public class TestEmp {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
       SqlSession session = MyBatisUtil.getSqlSession();
       //调用id=findAll的SQL
//       List<Emp> list = session.selectList("findAll");
       List<Emp> list = session.selectList("findLikeName","%月%");
       for(Emp e : list){
    	   System.out.println(e.getName());
       }
	   session.close();//释放session
	}
}
