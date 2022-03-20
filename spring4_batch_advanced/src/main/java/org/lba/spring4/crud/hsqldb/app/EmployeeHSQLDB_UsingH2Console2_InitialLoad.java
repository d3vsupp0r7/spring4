package org.lba.spring4.crud.hsqldb.app;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeHSQLDB_UsingH2Console2_InitialLoad {

	static final Logger logger = Logger.getLogger(EmployeeHSQLDB_UsingH2Console2_InitialLoad.class);

	public static void main(String[] args) {
		
		/*1. Load Spring profile*/
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/hsqldb-config/spring-context-hsqldb-using-h2console-initialLoad.xml");
		/*Create model example*/
		EmployeeService launcher = context.getBean("employeeServiceImpl", EmployeeService.class);
		List<Employee> listEmployee = launcher.listAllEmployees();
		/*2.1 Iterate on saved object*/
		for (Employee employeeModel : listEmployee) {
			logger.debug("Employee: " + employeeModel.toString());
		}

		/**/
		Employee sampleModel = new Employee();
		sampleModel.setId(1L);
		sampleModel.setName("Name_1");
		sampleModel.setSurname("Surname_2");
		sampleModel.setBornDate(new Date());
		/*2. Obtain Spring Bean*/
		
		/*3. Save an object*/
		launcher.saveEmployee(sampleModel);
		/*4. READ saved object*/
	
		/*5. Iterate on saved object*/
		listEmployee = launcher.listAllEmployees();
		for (Employee employeeModel : listEmployee) {
			logger.debug("Employee: " + employeeModel.toString());
		}
		//6. Close Spring context
		context.close();
	}
	
}
