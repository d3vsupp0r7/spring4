package org.lba.spring4.batch.processor;

import org.apache.log4j.Logger;
import org.lba.spring4.batch.model.Employee;
import org.springframework.batch.item.ItemProcessor;

public class EmployeeCustomItemProcessor implements ItemProcessor<Employee, Employee> {
	
	static final Logger logger = Logger.getLogger(EmployeeCustomItemProcessor.class);
	
    public Employee process(Employee itemObj) throws Exception {
    	logger.debug("Processing Item = " + itemObj);
        return itemObj;
    }
}
