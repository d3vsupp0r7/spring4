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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody EmployeeModel aEmployee) {
		
		logger.debug("Create employee: " + aEmployee.toString());
		Employee toSaveEmployee = new Employee(aEmployee.getName(), aEmployee.getSurname());

		Employee savedEmployee = employeeService.saveEmployee(toSaveEmployee);
		return savedEmployee;
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
		Employee employee = employeeService.findById(id);		
		return employee;
	}

	/*UPDATE*/
	@Override
	@PutMapping("/employee/{id}")
	public EmployeeModel updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeModel aEmployee) {

		Employee employee = employeeService.findById(id);		
		if (employee==null) {
			logger.debug("Employee with id " + id + " not found");
		}
		
		employee.setId(id);
		employee.setName(aEmployee.getName());
		employee.setSurname(aEmployee.getSurname());
		
		int resultOfUpdate = employeeService.updateEmployeeById(id, employee);
		
		return null;
	}

	/*DELETE*/
	@Override
	public EmployeeModel deleteEmployee(EmployeeModel aEmployee) {
		// TODO Auto-generated method stub
		return null;
	}




}
