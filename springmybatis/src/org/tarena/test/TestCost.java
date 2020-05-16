package org.tarena.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.tarena.entity.Cost;
import org.tarena.util.MyBatisUtil;

public class TestCost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqlSession session = MyBatisUtil.getSession();
		System.out.println(session);
//		List<Cost> list = session.selectList("findAll");
//		List<Cost> list = session.selectList("findPage",5);
//		for(Cost c : list){
//			System.out.println(c.getCost_id()+" "+c.getName());
//		}
		//测试返回Map结果
//		List<Map<String, Object>> list = session.selectList("findMap");
//		for(Map<String, Object> data : list){
//			System.out.println(data.get("cost_id")+" "+data.get("name"));
//		}
		//测试返回int值
		int rows = session.selectOne("findRows");
		System.out.println("记录数:"+rows);
		session.close();
	}
}
