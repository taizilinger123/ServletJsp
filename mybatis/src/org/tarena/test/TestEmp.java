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
       //测试多行查询
       //调用id=findAll的SQL
//       List<Emp> list = session.selectList("findAll");
//       List<Emp> list = session.selectList("findLikeName","%月%");
//       for(Emp e : list){
//    	   System.out.println(e.getName());
//       }
       //测试单行查询
       Emp emp = session.selectOne("findById",18);
       if(emp != null){
           System.out.println(emp.getName());
       }else{
    	   System.out.println("未查到记录");
       }
	   session.close();//释放session
	}
}
