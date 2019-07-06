package org.lba.spring4.controller.impl;

import java.util.List;

import org.lba.spring4.controller.EmployeeController;
import org.lba.spring4.controller.data.EmployeeModel;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeControllerImpl implements EmployeeController{
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public EmployeeModel createEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeModel> readAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
