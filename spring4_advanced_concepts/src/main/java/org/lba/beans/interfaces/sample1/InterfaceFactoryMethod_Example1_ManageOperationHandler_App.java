package org.lba.beans.interfaces.sample1;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ComponentScan(basePackages = "org.lba.beans.interfaces.sample1")
public class InterfaceFactoryMethod_Example1_ManageOperationHandler_App {

	static final Logger LOGGER = Logger.getLogger(InterfaceFactoryMethod_Example1_ManageOperationHandler_App.class);

	public static void main(String[] args) {

		/*Initialize Spring context*/
		String springContextFileName = "app-context-for-interfaces-example1.xml";
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/interfaces/"+springContextFileName);
		/**/
		InterfaceFactoryMethod_Example1_ManageOperationHandler_App mainApp = context.getBean(InterfaceFactoryMethod_Example1_ManageOperationHandler_App.class);
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
		/*Test: Manage operation Handler Create*/
		// PODAM message builder
		PodamFactory factory = new PodamFactoryImpl();
		Employee employee = factory.manufacturePojo(Employee.class);
		LOGGER.debug("Object builded with PODAM Lib: " + employee.toString());
		/**/
		String productSelector = "product1";
		Product productFromFactory = factoryMethodImpl.createProduct(productSelector);
		/**/
		String param1 = "CREATE";
		String param2 = "PARAM_2";
		/**/
		factoryMethodImpl.createProductWithParams(productSelector, param1, param2);
		if(productFromFactory != null) {
			LOGGER.debug("[OK] - Product Instance created");
			productFromFactory.processOperationHandler(employee);
		}else {
			LOGGER.debug("[ERROR] - Product Instance NOT created [ERROR]");
		}

		/**/
	}

}
