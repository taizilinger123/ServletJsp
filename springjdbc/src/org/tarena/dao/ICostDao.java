package org.tarena.dao;

import java.util.List;

import org.tarena.entity.Cost;

public interface ICostDao {

	public abstract List<Cost> findAll();

}