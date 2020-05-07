package org.tarena.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.entity.Cost;
import org.tarena.entity.CostRowMapper;

@Repository//É¨Ãèid=costDao
public class CostDao {
   @Resource//×¢Èë
   private JdbcTemplate template;
   
   public List<Cost> findAll(){
	   String sql = "select *  from cost";
	   CostRowMapper rowMapper = new CostRowMapper();
	   List<Cost> list = template.query(sql, rowMapper);
	   return list;
   }
}
