package org.lba.spring4.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.model.Employee;
import org.lba.spring4.repository.EmployeeRepository;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	/* CREATE */
	@Override
	public Employee saveEmployee(Employee employee) {

		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	/* READ */
	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(long id) {
		return employeeRepository.findById(id);
	}

	/* UPDATE */
	@Override
	public int updateEmployeeById(long id,Employee employee) {

		int result = -1;

		result = employeeRepository.updateEmployeeById(id, employee.getName(), employee.getSurname());

		return result;
	}

	/* DELETE */
	@Override
	public void deleteEmployeeById(long id) {
		employeeRepository.delete(id);
	}

}
