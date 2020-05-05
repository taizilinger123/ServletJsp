package org.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
/**
 * ��emp��¼��װ��Emp����
 * @author sige
 *
 */
public class EmpRowMapper implements RowMapper<Emp>{

	public Emp mapRow(ResultSet rs, int index) throws SQLException {
		//����ǰrsָ��ָ��ļ�¼ȡ��,��װ��Emp����
		Emp emp = new Emp();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setSalary(rs.getDouble("salary"));
		emp.setAge(rs.getInt("age"));
		return emp;
	}
    
}
