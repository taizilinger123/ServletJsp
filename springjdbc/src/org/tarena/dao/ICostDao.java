package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Cost;

public interface ICostDao {

	public  List<Cost> findAll();
	/**
	 * 提取指定页的记录，一页5条记录
	 * @param page
	 * @return
	 */
	public  List<Cost> findPage(int page);

}