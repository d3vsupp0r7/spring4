package org.lba.spring4.service.impl;

import java.util.List;

import org.lba.spring4.db.model.ProcessedEmployeeModel;
import org.lba.spring4.db.repository.ProcessedEmployeeRepository;
import org.lba.spring4.service.ProcessedEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("processedEmployeeService")
public class ProcessedEmployeeServiceImpl implements ProcessedEmployeeService {
	
	@Autowired
	private ProcessedEmployeeRepository processedEmployeeRepository;

	@Override
	public ProcessedEmployeeModel createProcessedEmployee(ProcessedEmployeeModel saveEmployee) {
		return processedEmployeeRepository.save(saveEmployee);
	}

	@Override
	public void saveAll(List<ProcessedEmployeeModel> employeeCollection) {
		processedEmployeeRepository.save(employeeCollection);
		
	}

	@Override
	public List<ProcessedEmployeeModel> findAllProcessedEmployee() {
		return processedEmployeeRepository.findAll();
	}	
}
