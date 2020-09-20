package org.lba.spring4.controller;

import java.util.List;

import org.lba.spring4.controller.data.EmployeeModel;
import org.lba.spring4.db.model.Employee;

public interface EmployeeRestController {

	//C
	public Employee createEmployee(EmployeeModel aEmployee);
	//R
	public List<Employee> readAllEmployees();
	public Employee getEmployeeById(long id);
	//U
	public EmployeeModel updateEmployee(long id, EmployeeModel aEmployee);
	//D
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee);
	
}
