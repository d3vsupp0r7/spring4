package org.lba.spring4.controller;

import java.util.List;

import org.lba.spring4.controller.data.EmployeeModel;

public interface EmployeeController {

	//C
	public EmployeeModel createEmployee(EmployeeModel aEmployee);
	//R
	public List<EmployeeModel> readAllEmployees();
	//U
	public EmployeeModel updateEmployee(EmployeeModel aEmployee);
	//D
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee);
}
