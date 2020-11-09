package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.db.model.EmployeeDBModel;

public interface EmployeeService {

	//C
	public EmployeeDBModel saveEmployee(EmployeeDBModel employee);

	//R
	public List<EmployeeDBModel> listAllEmployees();
	public EmployeeDBModel findById(long id);

	//U
	public int updateEmployeeById(long id, EmployeeDBModel employee);
	
	//D
	public void deleteEmployeeById(long id);



	
}
