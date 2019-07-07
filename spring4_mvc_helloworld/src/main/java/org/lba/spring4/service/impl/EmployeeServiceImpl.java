package org.lba.spring4.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.EmployeeDBModel;
import org.lba.spring4.db.repository.EmployeeRepository;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDBModel> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
