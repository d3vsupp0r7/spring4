package org.lba.beans.interfaces.sample3.springfactorymethod.example;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.lba.beans.interfaces.sample1.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class SpringFactoryMethodApp_InvalidOperationHandler_App {

	static final Logger LOGGER = Logger.getLogger(SpringFactoryMethodApp_InvalidOperationHandler_App.class);
	
	@Autowired
	private ApplicationContext contextApp;
	
	public static void main(String[] args) {

		/*Initialize Spring context*/
		String springContextFileName = "spring-factorymethod-example.xml";
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/interfaces/"+springContextFileName);
		/**/
		/*************************/
		LOGGER.debug("*** SpringFactoryMethodApp - printContextBean - START ***");
		String[] beans = context.getBeanDefinitionNames();
		LOGGER.debug("*** SpringFactoryMethodApp - printContextBean - number of beans: " + beans.length);
		Arrays.sort(beans);
		int id = 1;
		for (String bean : beans) 
		{
			LOGGER.debug(id +") " + bean + " of Type :: " + context.getBean(bean).getClass());
			//LOGGER.debug(id +") " + bean );
			id++;
		}
		LOGGER.debug("*** SpringFactoryMethodApp - printContextBean -   END ***");
		/*************************/
		/**/
		SpringFactoryMethodApp_InvalidOperationHandler_App mainApp = context.getBean(SpringFactoryMethodApp_InvalidOperationHandler_App.class);
		mainApp.start(args);
		
		/*Close Spring context*/
		((ConfigurableApplicationContext)context).close();

	}

	/************************/
	@Autowired
	private FactoryMethodImpl factoryMethodImpl;
	/**
	 * 
	 * @param args
	 */
	
	private void start(String[] args) {
		/*Test 1: Manage Null operationHandler*/
		// PODAM message builder
		PodamFactory factory = new PodamFactoryImpl();
		Employee employee = factory.manufacturePojo(Employee.class);
		LOGGER.debug("Object builded with PODAM Lib: " + employee.toString());
		/**/
		Product product1 = (Product) contextApp.getBean("product1");
		if(product1 != null) {
			LOGGER.debug("[OK] - Product Instance created");
			product1.processOperationHandler(employee);
		}else {
			LOGGER.debug("[ERROR] - Product Instance NOT created [ERROR]");
		}

		/**/
	}
	
	

}
