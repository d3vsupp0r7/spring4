package org.lba.profile.employee;

import java.util.ArrayList;
import java.util.List;

import org.lba.profile.Employee;
import org.lba.profile.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> provideEmployee() {
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee("aEmployeeName1", "aEmployeeSurname1", "employee"));
		employee.add(new Employee("aEmployeeName2", "aEmployeeSurname2", "employee"));
		employee.add(new Employee("aEmployeeName3", "aEmployeeSurname3", "employee"));
		return employee;
	}

}
