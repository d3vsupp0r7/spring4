package org.lba.spring4.crud.hsqldb.app;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeHSQLDBMain {

	static final Logger logger = Logger.getLogger(EmployeeHSQLDBMain.class);

	public static void main(String[] args) {
		
		/*1. Load Spring profile*/
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/hsqldb-config/spring-context-hsqldb.xml");
		/*Create model example*/
		Employee sampleModel = new Employee();
		sampleModel.setId(1L);
		sampleModel.setName("Name_1");
		sampleModel.setSurname("Surname_2");
		sampleModel.setBornDate(new Date());
		/*2. Obtain Spring Bean*/
		EmployeeService launcher = context.getBean("employeeServiceImpl", EmployeeService.class);
		/*3. Save an object*/
		launcher.saveEmployee(sampleModel);
		/*4. READ saved object*/
		List<Employee> listEmployee = launcher.listAllEmployees();
		/*5. Iterate on saved object*/
		for (Employee employeeModel : listEmployee) {
			logger.debug("Employee: " + employeeModel.toString());
		}
		//6. Close Spring context
		context.close();
	}
	
}
