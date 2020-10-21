package org.lba.spring4;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.EmployeeWithColumnTransformerEntity;
import org.lba.spring4.db.repository.EmployeeTestRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppH2_EmployeeWithColumnTransformerEntity {

	static final  Logger logger = Logger.getLogger(MainAppH2_EmployeeWithColumnTransformerEntity.class);

	public static void main(String[] args) {
		
		logger.debug("** H2 -   START **");
		
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
		EmployeeTestRepository service = (EmployeeTestRepository) context.getBean("employeeTestRepository");
		
		List<EmployeeWithColumnTransformerEntity> allEmployeeAtStartup = service.findAll();
		for (EmployeeWithColumnTransformerEntity employee : allEmployeeAtStartup) {
			logger.debug("Employee found: " + employee.toString());
			logger.debug("Mail: " + employee.getEmail());
		}
		
		/*******/
		logger.debug("** H2 -   END **");
		//Close spring context
		((ConfigurableApplicationContext)context).close();

	}
}
