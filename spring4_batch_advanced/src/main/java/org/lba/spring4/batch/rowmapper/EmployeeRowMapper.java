package org.lba.spring4.batch.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lba.spring4.model.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee model = new Employee();
		/**/
		model.setId(rs.getLong("id"));
		model.setName(rs.getString("name"));
		model.setSurname(rs.getString("surname"));
		model.setBornDate(rs.getDate("bornDate"));
		/**/
		return model;
	}
	
}
