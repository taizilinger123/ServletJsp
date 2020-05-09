package org.tarena.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.entity.Cost;

public class TestCostDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	    ICostDao costDao = ac.getBean("costDao",CostDao.class);
		List<Cost> list = costDao.findAll();
		for(Cost c : list){
			System.out.println(c.getCost_id()+" "+c.getName());
		}
	}
}
