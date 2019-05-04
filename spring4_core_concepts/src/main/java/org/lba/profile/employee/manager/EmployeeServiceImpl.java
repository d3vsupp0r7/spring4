package org.lba.profile.employee.manager;

import java.util.ArrayList;
import java.util.List;

import org.lba.profile.Employee;
import org.lba.profile.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> provideEmployee() {
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee("aEmployeeManagerName1", "aEmployeeManagerSurname1", "manager"));
		employee.add(new Employee("aEmployeeManagerName2", "aEmployeeManagerSurname2", "manager"));
		employee.add(new Employee("aEmployeeManagerName3", "aEmployeeManagerSurname3", "manager"));
		return employee;
	}

}
