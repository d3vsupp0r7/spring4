package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.db.model.EmployeeModel;

public interface EmployeeService {

	//Create
	public EmployeeModel createEmployee(EmployeeModel saveEmployee);
	//Read
	public List<EmployeeModel> findAllEmployee();
	public EmployeeModel findById(EmployeeModel saveEmployee);
	public EmployeeModel findByName(EmployeeModel saveEmployee);
	//Update
	public EmployeeModel updateEmployee(EmployeeModel employee);
	//Delete
	public EmployeeModel deleteById(EmployeeModel employee);
	public void saveAll(List<EmployeeModel> employeeCollection);
}
