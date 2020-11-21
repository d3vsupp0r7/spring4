package org.lba.spring4.app.spring;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.relationship.manytomany.unidirectional.AddressM2MUnidirectional;
import org.lba.spring4.db.model.relationship.manytomany.unidirectional.EmployeeM2MUnidirectional;
import org.lba.spring4.db.model.simple.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppH2_M2M_Spring_Unidirectional {

	static final  Logger logger = Logger.getLogger(MainAppH2_M2M_Spring_Unidirectional.class);

	public static void main(String[] args) {
		//1. Read Spring Context 
		String profile = "h2";
		String suffix = ".xml";
		String contextFileNameSuffix = "applicationContext-";
		/**/
		String springContextFile = contextFileNameSuffix+profile+suffix;
		logger.debug("SPRING CONTEXT FILE: " + springContextFile);
		/**/
		ApplicationContext context = new ClassPathXmlApplicationContext(
				springContextFile);

		/*Initial Read*/
		logger.debug("** H2 - START **");
		AddressM2MUnidirectional address1 = new AddressM2MUnidirectional("Bengaluru", "Karnataka", "India", "560016");
		AddressM2MUnidirectional address2 = new AddressM2MUnidirectional("Jaipur", "Rajasthan", "India", "302017");

		// Employee1 have 2 addresses
		EmployeeM2MUnidirectional employee1 = new EmployeeM2MUnidirectional("Ravindra Singh", "Sales Manager", 450000);
		employee1.getAddresses().add(address1);
		employee1.getAddresses().add(address2);

		// Employee2 have 1 address
		EmployeeM2MUnidirectional employee2 = new EmployeeM2MUnidirectional("Mohit Sharma", "Software Engineer", 850000);
		employee2.getAddresses().add(address1);

		logger.debug("** Initial read **");
		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		List<Employee> allEmployeeAtStartup = service.findAllEmployee();
		for (Employee employee : allEmployeeAtStartup) {
			logger.debug("Employee found: " + employee.toString());
		}
		/*Create*/
		logger.debug("** Create new employee **");
		Employee employeeToSave = new Employee("NewEmployeeName", "NewEmployeeSurName");
		Employee savedEmployee = service.createEmployee(employeeToSave);
		logger.debug("Employee saved: " + savedEmployee.toString());
		/*Read*/
		logger.debug("\t** Read all employee after create **");
		List<Employee> allEmployeeAfterCreate = service.findAllEmployee();
		for (Employee employee : allEmployeeAfterCreate) {
			logger.debug("Employee found: " + employee.toString());
		}
		/**/
		logger.debug("** Find employee by id **");
		savedEmployee.setId(new Long("10001"));
		Employee employeeById = service.findById(savedEmployee);
		logger.debug("Employee found: " + employeeById.toString());
		/*******/
		logger.debug("** H2 -   END **");
		//Close spring context
		((ConfigurableApplicationContext)context).close();

	}
}
