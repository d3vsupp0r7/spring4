package org.lba.spring4.service;

import java.util.List;

import org.lba.spring4.model.EmployeeModel;

public interface EmployeeService {

	void sampleCall();

	void sayHello();

	EmployeeModel saveModelObject(EmployeeModel model);

	List<EmployeeModel> getAllEmployee();

}
