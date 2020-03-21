package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.model.Employee;

public interface EmployeeService {

	//C
	public Employee saveEmployee(Employee employee);

	//R
	public List<Employee> listAllEmployees();
	public Employee findById(long id);

	//U
	public int updateEmployeeById(long id, Employee employee);

	//D
	public void deleteEmployeeById(long id);


}
