package org.tarena.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.entity.Emp;

@Repository//ɨ��Dao
public class EmpDao {
   @Resource//ע��	
   private JdbcTemplate template;//ע��	
	
   public void save(Emp emp){
	  String sql = "insert into emp(name,salary,age) values(?,?,?)";
	  Object[] params = {emp.getName(),emp.getSalary(),emp.getAge()};
	  template.update(sql, params);
   }
}
