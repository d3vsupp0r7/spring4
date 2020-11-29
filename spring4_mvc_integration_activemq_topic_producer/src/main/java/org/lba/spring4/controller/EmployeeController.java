package org.lba.spring4.controller;

import org.lba.spring4.controller.data.EmployeeModel;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmployeeController {

	//C
	public String createEmployee(@ModelAttribute("employee") EmployeeModel aEmployee, BindingResult result);
	//R
	public String readAllEmployees(ModelMap model);
	//U
	public EmployeeModel updateEmployee(EmployeeModel aEmployee);
	//D
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee);
	public String deleteEmployeeById(@PathVariable  String id);
}
