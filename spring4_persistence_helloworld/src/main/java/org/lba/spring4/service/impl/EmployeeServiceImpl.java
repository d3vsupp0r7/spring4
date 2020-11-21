package org.lba.spring4.service.impl;

import java.util.List;

import org.lba.spring4.db.model.simple.Employee;
import org.lba.spring4.db.repository.EmployeeRepository;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee saveEmployee) {
		return employeeRepository.save(saveEmployee);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Employee saveEmployee) {
		return employeeRepository.findById(saveEmployee.getId());
	}

	@Override
	public Employee findByName(Employee saveEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee deleteById(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
