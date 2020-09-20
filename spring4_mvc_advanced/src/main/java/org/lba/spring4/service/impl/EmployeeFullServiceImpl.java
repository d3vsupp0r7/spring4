package org.lba.spring4.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.Employee;
import org.lba.spring4.db.model.EmployeeFull;
import org.lba.spring4.db.repository.EmployeeFullRepository;
import org.lba.spring4.service.EmployeeFullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFullServiceImpl implements EmployeeFullService {

	static final Logger logger = Logger.getLogger(EmployeeFullServiceImpl.class);
	
	@Autowired
	private EmployeeFullRepository employeeRepository;

	/* CREATE */
	@Override
	public EmployeeFull saveEmployee(EmployeeFull employee) {
	
		EmployeeFull savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	/* READ */
	@Override
	public List<EmployeeFull> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeFull findById(long id) {
		return employeeRepository.findById(id);
	}

	/* UPDATE */
	@Override
	public int updateEmployeeById(long id,EmployeeFull employee) {
	
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
