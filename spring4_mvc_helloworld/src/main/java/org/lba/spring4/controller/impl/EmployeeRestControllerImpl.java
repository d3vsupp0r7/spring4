package org.lba.spring4.controller.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.controller.EmployeeRestController;
import org.lba.spring4.controller.data.EmployeeModel;
import org.lba.spring4.db.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api")
public class EmployeeRestControllerImpl implements EmployeeRestController{

	static final Logger logger = Logger.getLogger(EmployeeRestControllerImpl.class);

	@Autowired
	private EmployeeService employeeService;

	/*CREATE*/
	@Override
	public EmployeeModel createEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	/*READ*/
	@Override
	@GetMapping("/employees")
	public List<Employee> readAllEmployees() {
		return employeeService.listAllEmployees();
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("id") long id) {
		
		logger.debug("Fetching User with id " + id);
		Employee user = employeeService.findById(id);		
		return user;
	}

	/*UPDATE*/
	@Override
	public EmployeeModel updateEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	/*DELETE*/
	@Override
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}


}
