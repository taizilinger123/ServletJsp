package org.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CostRowMapper implements RowMapper<Cost>{

	public Cost mapRow(ResultSet rs, int arg1) throws SQLException {
		Cost cost = new Cost();
		cost.setCost_id(rs.getInt("cost_id"));
		cost.setName(rs.getString("name"));
		cost.setBase_duration(rs.getLong("base_duration"));
		cost.setBase_cost(rs.getDouble("base_cost"));
		cost.setUnit_cost(rs.getDouble("unit_cost"));
		cost.setDescr(rs.getString("descr"));
		cost.setStatus(rs.getString("status"));
		cost.setCreatime(rs.getDate("creatime"));
		cost.setStartime(rs.getDate("startime"));
		cost.setCost_type(rs.getString("cost_type"));
		return cost;
	}
    
}
