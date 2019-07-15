package org.lba.spring4.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.lba.spring4.model.EmployeeModel;
import org.lba.spring4.repository.EmployeeRepository;
import org.lba.spring4.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	static final  Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EmployeeRepository sampleRepository; 

	@Override
	public void sampleCall() {
		logger.debug("sampleCall: Method from spring bean: EmployeeServiceImpl");
	}

	@Override
	public void sayHello() {
		logger.debug("Hello from spring bean: EmployeeServiceImpl");
		
	}

	@Override
	public EmployeeModel saveModelObject(EmployeeModel model) {
		logger.debug("Saving object: " + model.toString());
		EmployeeModel savedEmployee = sampleRepository.save(model);
		logger.debug("Saved object id: " + savedEmployee.getId());
		return savedEmployee;
		
	}
	
	@Override
	public List<EmployeeModel> getAllEmployee(){
		return sampleRepository.findAll();
	}
}
