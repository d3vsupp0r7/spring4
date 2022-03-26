package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.db.model.ProcessedEmployeeModel;

public interface ProcessedEmployeeService {

	//Create
	public ProcessedEmployeeModel createProcessedEmployee(ProcessedEmployeeModel saveEmployee);
	//Read
	public List<ProcessedEmployeeModel> findAllProcessedEmployee();
	public void saveAll(List<ProcessedEmployeeModel> employeeCollection);
}
