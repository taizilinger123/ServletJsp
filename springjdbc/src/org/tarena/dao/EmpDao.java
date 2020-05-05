package org.tarena.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.tarena.entity.Emp;

@Repository//É¨ÃèDao
public class EmpDao {
   @Resource//×¢Èë	
   private JdbcTemplate template;//×¢Èë	
	
   public void save(Emp emp){
	  String sql = "insert into emp(name,salary,age) values(?,?,?)";
	  Object[] params = {emp.getName(),emp.getSalary(),emp.getAge()};
	  template.update(sql, params);
   }
   
   public void delete(int id){
	   String sql = "delete from emp where  id=?";
	   Object[] params = {id};
	   template.update(sql,params);
   }
}
