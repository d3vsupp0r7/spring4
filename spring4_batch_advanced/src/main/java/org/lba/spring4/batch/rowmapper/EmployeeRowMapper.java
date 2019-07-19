package org.lba.spring4.batch.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lba.spring4.model.EmployeeModel;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<EmployeeModel>{

	@Override
	public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmployeeModel model = new EmployeeModel();
		/**/
		model.setId(rs.getInt("id"));
		model.setName(rs.getString("name"));
		model.setSurname(rs.getString("surname"));
		model.setBornDate(rs.getDate("bornDate"));
		/**/
		return model;
	}
	
}
