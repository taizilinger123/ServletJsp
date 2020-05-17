package org.tarena.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.tarena.entity.Cost;
import org.tarena.util.MyBatisUtil;

public class CostDao implements ICostDao{

	public List<Cost> findAll() {
		SqlSession session = MyBatisUtil.getSession();
		List list = session.selectList("findAll");
		return list;
	}

}
