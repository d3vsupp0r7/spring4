package org.lba.spring4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.EmployeeEncriptedWithConvertAnnotationEntity;
import org.lba.spring4.db.repository.EmployeeEntityColumnTransformerRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppH2_EmployeeEncriptedWithConvertAnnotationEntity {

	static final  Logger logger = Logger.getLogger(MainAppH2_EmployeeEncriptedWithConvertAnnotationEntity.class);

	public static void main(String[] args) {
		
		logger.debug("** H2 -   START: MainAppH2_ConsoleInsert_EmployeeTransformer **");
		
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
		EmployeeEntityColumnTransformerRepository service = (EmployeeEntityColumnTransformerRepository) context.getBean("employeeEntityColumnTransformerRepository");
		
		/*Create*/
		logger.debug("** Create new employee with HIBERNATE **");
		EmployeeEncriptedWithConvertAnnotationEntity employeeToSave = new EmployeeEncriptedWithConvertAnnotationEntity(name, surname, "example_input_for_mail");
		EmployeeEncriptedWithConvertAnnotationEntity savedEmployee = service.save(employeeToSave);
		logger.debug("Employee saved: " + savedEmployee.toString());
		/*
		 * aa                     = 84Y2KVMhFs8XAQkWPYPREg==
		 * test_email@gmail.com   = SWTfo0dmwDyRTzjTRDgUdARbB6XI9kJrZZdZU1H0ukc=
		 * example_input_for_mail = RVWQYSh8u07OBTJ2YR3MLLbOm2K28MEh52pRhDOmtL4=
		 * */
		List<EmployeeEncriptedWithConvertAnnotationEntity> allEmployeeAtStartup = service.findAll();
		for (EmployeeEncriptedWithConvertAnnotationEntity employee : allEmployeeAtStartup) {
			logger.debug("Employee found: " + employee.toString());
			logger.debug("Mail: " + employee.getEmail());
		}
		
		try {
			logger.debug("** READ employee WITHOUT HIBERNATE **");
			Connection con = DriverManager.getConnection("jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1", "sa", "");

			PreparedStatement stmt = con.prepareStatement("select * from EMPLOYEE_ENCRYPTED_TRANSFORMER where id = ?");
			stmt.setLong(1, savedEmployee.getId());

			ResultSet rs = stmt.executeQuery();
			rs.next();
			String emailEncriptedOnDB = rs.getString("email");
			logger.info("emailEncriptedOnDB in database: " + emailEncriptedOnDB);
		} catch (SQLException e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		
		
		/*******/
		logger.debug("** H2 -   END: MainAppH2_ConsoleInsert_EmployeeTransformer **");
		//Close spring context
		((ConfigurableApplicationContext)context).close();

	}
}
