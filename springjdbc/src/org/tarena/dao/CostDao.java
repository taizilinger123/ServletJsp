package org.tarena.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.entity.Cost;
import org.tarena.entity.CostRowMapper;

@Repository//扫描id=costDao
public class CostDao implements ICostDao {
   @Resource//注入
   private JdbcTemplate template;
   
   /* (non-Javadoc)
 * @see org.tarena.dao.ICostDao#findAll()
 */
public List<Cost> findAll(){
	   String sql = "select *  from cost";
	   CostRowMapper rowMapper = new CostRowMapper();
	   List<Cost> list = template.query(sql, rowMapper);
	   return list;
   }
}
