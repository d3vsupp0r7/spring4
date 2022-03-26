package org.lba.spring4.service.impl;

import java.util.List;

import org.lba.spring4.db.model.EmployeeModel;
import org.lba.spring4.db.repository.EmployeeRepository;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeModel createEmployee(EmployeeModel saveEmployee) {
		
		return employeeRepository.save(saveEmployee);
	}

	@Override
	public List<EmployeeModel> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeModel findById(EmployeeModel saveEmployee) {
		return employeeRepository.findById(saveEmployee.getId());
	}

	@Override
	public EmployeeModel findByName(EmployeeModel saveEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeModel deleteById(EmployeeModel employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(List<EmployeeModel> employeeCollection) {
		employeeRepository.save(employeeCollection);
		
	}

	
}
