package org.lba.spring4;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppH2 {

	static final  Logger logger = Logger.getLogger(MainAppH2.class);

	public static void main(String[] args) {
		//1. Read Spring Context 
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextH2.xml");

		/*Initial Read*/
		logger.debug("** H2 - START **");
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
