package org.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
/**
 * 将emp记录封装成Emp对象
 * @author sige
 *
 */
public class EmpRowMapper implements RowMapper<Emp>{

	public Emp mapRow(ResultSet rs, int index) throws SQLException {
		//将当前rs指针指向的记录取出,封装成Emp返回
		Emp emp = new Emp();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setSalary(rs.getDouble("salary"));
		emp.setAge(rs.getInt("age"));
		return emp;
	}
    
}
