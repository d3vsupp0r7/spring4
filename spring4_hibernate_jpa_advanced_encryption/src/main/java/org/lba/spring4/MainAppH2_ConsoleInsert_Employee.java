package org.lba.spring4;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.Employee;
import org.lba.spring4.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppH2_ConsoleInsert_Employee {

	static final  Logger logger = Logger.getLogger(MainAppH2_ConsoleInsert_Employee.class);

	public static void main(String[] args) {
		
		logger.debug("** H2 -   START: MainAppH2_ConsoleInsert_Employee **");
		//1. Read Spring Context 
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextH2.xml");

		Scanner in;
		in = new Scanner(System.in);

		System.out.println("What's your name? ");
		String name = in.nextLine();
		System.out.println("What's your surname? ");
		String surname =  in.nextLine();

		String put = String.format("name: %s, surname: %s", name, surname);
		System.out.println("output: " + put);
		
		/**/
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		
		List<Employee> allEmployeeAtStartup = service.findAllEmployee();
		for (Employee employee : allEmployeeAtStartup) {
			logger.debug("Employee found: " + employee.toString());
		}
		/*Create*/
		logger.debug("** Create new employee **");
		Employee employeeToSave = new Employee(name, surname);
		Employee savedEmployee = service.createEmployee(employeeToSave);
		logger.debug("Employee saved: " + savedEmployee.toString());
		/*Read*/
		logger.debug("\t** Read all employee after create **");
		List<Employee> allEmployeeAfterCreate = service.findAllEmployee();
		for (Employee employee : allEmployeeAfterCreate) {
			logger.debug("Employee found: " + employee.toString());
		}
		
		/*******/
		logger.debug("** H2 -   END: MainAppH2_ConsoleInsert_Employee **");
		//Close spring context
		((ConfigurableApplicationContext)context).close();

	}
}
