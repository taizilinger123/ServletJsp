package org.tarena.test;

import java.util.List;

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
		List<Cost> list = session.selectList("findPage",5);
		for(Cost c : list){
			System.out.println(c.getCost_id()+" "+c.getName());
		}
		session.close();
	}
}
