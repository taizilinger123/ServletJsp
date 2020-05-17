package org.tarena.dao;

import java.util.List;
import java.util.Map;

import org.tarena.entity.Cost;

public interface CostDao {
   public List<Cost> findAll();
   public List<Cost> findPage(int begin);
   public List<Map<String, Object>> findMap();
   public int findRows();
}
