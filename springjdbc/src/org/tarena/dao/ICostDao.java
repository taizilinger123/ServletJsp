package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Cost;

public interface ICostDao {

	public  List<Cost> findAll();
	/**
	 * ��ȡָ��ҳ�ļ�¼��һҳ5����¼
	 * @param page
	 * @return
	 */
	public  List<Cost> findPage(int page);

}