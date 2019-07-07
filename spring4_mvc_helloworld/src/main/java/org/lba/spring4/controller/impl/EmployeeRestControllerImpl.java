package org.lba.spring4.controller.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.controller.EmployeeRestController;
import org.lba.spring4.controller.data.EmployeeModel;
import org.lba.spring4.db.model.EmployeeDBModel;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api")
public class EmployeeRestControllerImpl implements EmployeeRestController{
	
	static final Logger logger = Logger.getLogger(EmployeeRestControllerImpl.class);
	
	@Autowired
	private EmployeeService employeeService;

	@Override
	public EmployeeModel createEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/allEmployee")
	public List<EmployeeDBModel> readAllEmployees() {
		return employeeService.getAllEmployees();
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
