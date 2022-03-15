package org.lba.spring.gof.factorymethod;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.util.GenerateRandomNumbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ComponentScan(basePackages = "org.lba.spring.gof.factorymethod")
public class InterfaceFactoryMethod_GOF_RandomGenerator_App {

	static final Logger LOGGER = Logger.getLogger(InterfaceFactoryMethod_GOF_RandomGenerator_App.class);

	public static void main(String[] args) {

		/*Initialize Spring context*/
		String springContextFileName = "spring-gof-factorymethod.xml";
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/factorymethod/"+springContextFileName);
		/**/
		InterfaceFactoryMethod_GOF_RandomGenerator_App mainApp = context.getBean(InterfaceFactoryMethod_GOF_RandomGenerator_App.class);
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
		int numberGen = 5;
		/**/
		for(int i = 0; i < numberGen; i++) {
			LOGGER.debug("\r\n********** Iteration [" + (i+1) + "] - START **********");
			// PODAM message builder
			PodamFactory factory = new PodamFactoryImpl();
			Employee employee = factory.manufacturePojo(Employee.class);
			LOGGER.debug("Object builded with PODAM Lib: " + employee.toString());
			/**/
			String productSelector = generateProductSelector();
			Product productFromFactory = factoryMethodImpl.createProduct(productSelector);
			/**/
			String param1 = generateOperationHandler();
			String param2 = generateParameter2();
			/**/
			factoryMethodImpl.createProductWithParams(productSelector, param1, param2);
			if(productFromFactory != null) {
				LOGGER.debug("[OK] - Product Instance created\r\n");
				productFromFactory.processOperationHandler(employee);
			}else {
				LOGGER.debug("[ERROR] - Product Instance NOT created [ERROR]");
			}
			LOGGER.debug("********** Iteration [" + (i+1) + "] - END **********\r\n");
		}
		/**/
	}

	private String generateProductSelector() {
		LOGGER.debug("\r\n** generateProductSelector - START **");
		List<String> productSelectors = Arrays.asList("product1", "product2");
		int num = GenerateRandomNumbers.getRandomNumberInRange(0, 1);
		/**/
		LOGGER.debug("productSelectors - num: " + num);
		LOGGER.debug("productSelectors - value: " + productSelectors.get(num));
		LOGGER.debug("** generateProductSelector - END **\r\n");
		return productSelectors.get(num);
	} 

	private String generateOperationHandler() {
		LOGGER.debug("\r\n** generateOperationHandler - START **");
		List<String> operationHandler = Arrays.asList("CREATE", "READ", "UPDATE", "DELETE");
		int num = GenerateRandomNumbers.getRandomNumberInRange(0, 3);
		/**/
		LOGGER.debug("operationHandler - num: " + num);
		LOGGER.debug("operationHandler - value: " + operationHandler.get(num));
		LOGGER.debug("** generateOperationHandler - END **\r\n");
		return operationHandler.get(num);
	} 

	private String generateParameter2() {
		LOGGER.debug("\r\n** generateParameter2 - START **");
		List<String> parameter2 = Arrays.asList("PARAM_2_VALUE_1", "PARAM_2_VALUE_2", "PARAM_2_VALUE_3", "PARAM_2_VALUE_4");
		int num = GenerateRandomNumbers.getRandomNumberInRange(0, 3);
		/**/
		LOGGER.debug("parameter2 - num: " + num);
		LOGGER.debug("parameter2 - value: " + parameter2.get(num));
		LOGGER.debug("** generateParameter2 - END **\r\n");
		return parameter2.get(num);
	} 

}
