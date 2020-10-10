package org.lba.spring4.controller;

import java.util.List;

import org.lba.spring4.controller.data.EmployeeFormModel;
import org.lba.spring4.db.model.EmployeeDBModel;

public interface EmployeeRestController {

	//C
	public EmployeeDBModel createEmployee(EmployeeFormModel aEmployee);
	//R
	public List<EmployeeDBModel> readAllEmployees();
	public EmployeeDBModel getEmployeeById(long id);
	//U
	public EmployeeDBModel updateEmployee(long id, EmployeeFormModel aEmployee);
	//D
	public EmployeeFormModel deleteEmployee(EmployeeFormModel aEmployee);
	
	public void deleteEmployeeById(Long id);
	
}
