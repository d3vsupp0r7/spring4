package org.lba.spring4.crud.h2.app;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeH2InitialLoadMain {

	static final Logger logger = Logger.getLogger(EmployeeH2InitialLoadMain.class);

	public static void main(String[] args) {
		
		/*1. Load Spring profile*/
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/h2-config/spring-context-h2-initial-load.xml");
		EmployeeService launcher = context.getBean("employeeServiceImpl", EmployeeService.class);
		/*2. Read initial load data from sql script*/
		logger.debug("*** READ an object to H2 Database - START ***");
		List<Employee> listEmployee = launcher.listAllEmployees();
		/*2.1 Iterate on saved object*/
		for (Employee employeeModel : listEmployee) {
			logger.debug("Employee: " + employeeModel.toString());
		}
		logger.debug("*** READ an object to H2 Database -   END ***");
		//6. Close Spring context
		context.close();
	}
}
