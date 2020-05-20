package org.tarena.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.tarena.entity.Cost;

public class MyCostDao implements CostDao{
	
	private SqlSessionTemplate template;

	public List<Cost> findAll() {
         return template.selectList("findAll");
	}

	public List<Map<String, Object>> findMap() {
		 return template.selectList("findMap");
	}

	public List<Cost> findPage(int begin) {
		return template.selectList("findPage",begin);
	}

	public int findRows() {
		return template.selectOne("findRows");
	}

}
