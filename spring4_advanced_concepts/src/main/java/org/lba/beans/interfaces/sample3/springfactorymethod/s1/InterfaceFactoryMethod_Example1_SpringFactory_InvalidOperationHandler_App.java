package org.lba.beans.interfaces.sample3.springfactorymethod.s1;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ComponentScan(basePackages = "org.lba.beans.interfaces.sample2")
public class InterfaceFactoryMethod_Example1_SpringFactory_InvalidOperationHandler_App {

	static final Logger LOGGER = Logger.getLogger(InterfaceFactoryMethod_Example1_SpringFactory_InvalidOperationHandler_App.class);

	public static void main(String[] args) {

		/*Initialize Spring context*/
		String springContextFileName = "app-context-for-interfaces-example2.xml";
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/interfaces/"+springContextFileName);
		/**/
		InterfaceFactoryMethod_Example1_SpringFactory_InvalidOperationHandler_App mainApp = context.getBean(InterfaceFactoryMethod_Example1_SpringFactory_InvalidOperationHandler_App.class);
		mainApp.start(args);
		
		/*Close Spring context*/
		((ConfigurableApplicationContext)context).close();

	}

	/************************/
	@Autowired
	private IFactoryMethod factoryMethodImpl;
	/**
	 * 
	 * @param args
	 */
	private void start(String[] args) {
		/*Test 1: Invalid Operation Handler*/
		// PODAM message builder
		PodamFactory factory = new PodamFactoryImpl();
		Employee employee = factory.manufacturePojo(Employee.class);
		LOGGER.debug("Object builded with PODAM Lib: " + employee.toString());
		/**/
		String productSelector = "product1";
		Product productFromFactory = factoryMethodImpl.createProduct(productSelector);
		if(productFromFactory != null) {
			LOGGER.debug("[OK] - Product Instance created");
			productFromFactory.processOperationHandler(employee);
		}else {
			LOGGER.debug("[ERROR] - Product Instance NOT created [ERROR]");
		}

		/**/
	}

}
