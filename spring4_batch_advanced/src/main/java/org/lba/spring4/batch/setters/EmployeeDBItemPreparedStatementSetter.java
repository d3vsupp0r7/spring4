package org.lba.spring4.batch.setters;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lba.spring4.xml.model.EmployeeXmlModel;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

public class EmployeeDBItemPreparedStatementSetter implements ItemPreparedStatementSetter<EmployeeXmlModel>{

	@Override
	public void setValues(EmployeeXmlModel item, PreparedStatement ps) throws SQLException {
		 
		ps.setInt(1, item.getId());
	    ps.setString(2, item.getName());
	    ps.setString(3, item.getSurname());
		ps.setDate(4, new java.sql.Date(item.getDateOfBirth().getTime()));
		
	}

}
