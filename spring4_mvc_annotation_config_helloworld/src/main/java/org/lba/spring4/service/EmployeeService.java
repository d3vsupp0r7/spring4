package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.db.model.Employee;

public interface EmployeeService {

	//C
	Employee saveEmployee(Employee employee);

	//R
	List<Employee> listAllEmployees();
	Employee findById(long id);

	//U

	//D
	void deleteEmployeeById(long id);
}
