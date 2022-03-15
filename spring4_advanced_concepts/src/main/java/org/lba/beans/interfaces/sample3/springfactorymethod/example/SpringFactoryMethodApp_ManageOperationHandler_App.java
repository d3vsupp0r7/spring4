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

public class SpringFactoryMethodApp_ManageOperationHandler_App {

	static final Logger LOGGER = Logger.getLogger(SpringFactoryMethodApp_ManageOperationHandler_App.class);
	
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
		SpringFactoryMethodApp_ManageOperationHandler_App mainApp = context.getBean(SpringFactoryMethodApp_ManageOperationHandler_App.class);
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
		/*Test: Manage operation Handler Create*/
		// PODAM message builder
		PodamFactory factory = new PodamFactoryImpl();
		Employee employee = factory.manufacturePojo(Employee.class);
		LOGGER.debug("Object builded with PODAM Lib: " + employee.toString());
		/**/
		String productSelector = "product1";
		/* Invocation not necessary beacause factroy creation in demanded on spring framework 
		 * Product productFromFactory = factoryMethodImpl.createProduct(productSelector);
		 * 
		 * At application startup spring call the factory configuration to build and put beans
		 * into spring context.
		 * */
		
		/**/
		String param1 = "CREATE";
		String param2 = "PARAM_2";
		/*Bean present into context and ready to use with atowired bean loaded*/
		Product product1 = (Product) contextApp.getBean("product1");
		/*************************/
		LOGGER.debug("######### - printContextBean - START #########");
		String[] beans = contextApp.getBeanDefinitionNames();
		LOGGER.debug("*** SpringFactoryMethodApp - printContextBean - number of beans: " + beans.length);
		Arrays.sort(beans);
		int id = 1;
		for (String bean : beans) 
		{
			LOGGER.debug(id +") " + bean + " of Type :: " + contextApp.getBean(bean).getClass());
			//LOGGER.debug(id +") " + bean );
			id++;
		}
		LOGGER.debug("######### SpringFactoryMethodApp - printContextBean -   END #########");
		/*************************/

		factoryMethodImpl.createProductWithParams(productSelector, param1, param2);
		if(product1 != null) {
			LOGGER.debug("[OK] - Product Instance created");
			product1.processOperationHandler(employee);
		}else {
			LOGGER.debug("[ERROR] - Product Instance NOT created [ERROR]");
		}

		/**/
	}

}
