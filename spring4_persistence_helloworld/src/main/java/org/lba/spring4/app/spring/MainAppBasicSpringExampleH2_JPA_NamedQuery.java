package org.lba.spring4.app.spring;

import java.util.List;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.simple.Employee;
import org.lba.spring4.db.repository.EmployeeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppBasicSpringExampleH2_JPA_NamedQuery {

	static final  Logger logger = Logger.getLogger(MainAppBasicSpringExampleH2_JPA_NamedQuery.class);

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
		logger.debug("** Initial read **");
		EmployeeRepository service = (EmployeeRepository) context.getBean("employeeRepository");
		
		logger.debug("** READ JPA External query - no params **");
		logger.debug("** QUERY: findAllNamedExternalFileJPAQuery **");
		List<Employee> allEmployeeAtStartup = service.findAllNamedExternalFileJPAQuery();
		for (Employee employee : allEmployeeAtStartup) {
			logger.debug("Employee found: " + employee.toString());
		}

		logger.debug("** READ JPA External query - with params **");
		logger.debug("** QUERY: findByNameNamedExternalFileJPAQuery **");
		String param1 = "EmployeeName_2";
		allEmployeeAtStartup = service.findByNameNamedExternalFileJPAQuery(param1);
		for (Employee employee : allEmployeeAtStartup) {
			logger.debug("Employee found: " + employee.toString());
		}
		
		/*******/
		logger.debug("** H2 -   END **");
		//Close spring context
		((ConfigurableApplicationContext)context).close();

	}
}
