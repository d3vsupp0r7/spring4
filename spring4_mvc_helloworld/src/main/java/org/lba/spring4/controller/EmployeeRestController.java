package org.lba.spring4.controller;

import java.util.List;

import org.lba.spring4.controller.data.EmployeeModel;
import org.lba.spring4.db.model.EmployeeDBModel;

public interface EmployeeRestController {

	//C
	public EmployeeModel createEmployee(EmployeeModel aEmployee);
	//R
	public List<EmployeeDBModel> readAllEmployees();
	//U
	public EmployeeModel updateEmployee(EmployeeModel aEmployee);
	//D
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee);
}
