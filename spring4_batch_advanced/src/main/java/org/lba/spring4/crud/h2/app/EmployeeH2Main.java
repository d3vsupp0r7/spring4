package org.lba.spring4.crud.h2.app;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeH2Main {

	static final Logger logger = Logger.getLogger(EmployeeH2Main.class);

	public static void main(String[] args) {
		
		/*1. Load Spring profile*/
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/h2-config/spring-context-h2.xml");
		/*Create model example*/
		Employee sampleModel = new Employee();
		sampleModel.setId(1l);
		sampleModel.setName("Name_1");
		sampleModel.setSurname("Surname_2");
		sampleModel.setBornDate(new Date());
		/*2. Obtain Spring Bean*/
		logger.debug("*** Calling an object - START ***");
		EmployeeService launcher = context.getBean("employeeServiceImpl", EmployeeService.class);
		logger.debug("*** Calling an object -   END ***");
		/*3. Save an object*/
		logger.debug("*** Saving an object to H2 Database - START ***");
		launcher.saveEmployee(sampleModel);
		logger.debug("*** Saving an object to H2 Database -   END ***");
		/*4. READ saved object*/
		logger.debug("*** READ an object to H2 Database - START ***");
		List<Employee> listEmployee = launcher.listAllEmployees();
		/*5. Iterate on saved object*/
		for (Employee employeeModel : listEmployee) {
			logger.debug("Employee: " + employeeModel.toString());
		}
		logger.debug("*** READ an object to H2 Database -   END ***");
		//6. Close Spring context
		context.close();
		
	}
}
