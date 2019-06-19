package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.db.model.Employee;

public interface EmployeeService {

	//Create
	public Employee createEmployee(Employee saveEmployee);
	//Read
	public List<Employee> findAllEmployee();
	public Employee findById(Employee saveEmployee);
	public Employee findByName(Employee saveEmployee);
	//Update
	public Employee updateEmployee(Employee employee);
	//Delete
	public Employee deleteById(Employee employee);
}
