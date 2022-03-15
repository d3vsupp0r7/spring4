package org.lba.spring.gof.factorymethod;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ComponentScan(basePackages = "org.lba.spring.gof.factorymethod")
public class InterfaceFactoryMethod_GOF_ManageOperationHandler_App {

	static final Logger LOGGER = Logger.getLogger(InterfaceFactoryMethod_GOF_ManageOperationHandler_App.class);

	public static void main(String[] args) {

		/*Initialize Spring context*/
		String springContextFileName = "spring-gof-factorymethod.xml";
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/factorymethod/"+springContextFileName);
		/**/
		InterfaceFactoryMethod_GOF_ManageOperationHandler_App mainApp = context.getBean(InterfaceFactoryMethod_GOF_ManageOperationHandler_App.class);
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
