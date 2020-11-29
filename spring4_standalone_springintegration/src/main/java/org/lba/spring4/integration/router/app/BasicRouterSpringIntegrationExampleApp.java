package org.lba.spring4.integration.router.app;

import java.util.Random;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class BasicRouterSpringIntegrationExampleApp {

	static final Logger logger = Logger.getLogger(BasicRouterSpringIntegrationExampleApp.class);
	
	public static void main(String[] args) {
		/**/
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring-integration-router-basic.xml");
		context.refresh();
		/**/
		// PODAM message builder
		PodamFactory factory = new PodamFactoryImpl();
		EmployeeComplexPayload complexPayload = factory.manufacturePojo(EmployeeComplexPayload.class);
		complexPayload.getCustomMetadata().setChannelName("employeeChannel");
		logger.debug("Object to send: " + complexPayload.toString());
		/**/
		MessageChannel channel =
				context.getBean("routerChannel", MessageChannel.class);
		channel.send(MessageBuilder.withPayload(complexPayload).build());
		/**/
		logger.debug("** Example dynamic routing **\r\n");
		int routerMsg = 10;
		
		for(int i = 0; i < routerMsg; i++) {
			/**/
			logger.debug("******************************************************\r\n");
			logger.debug("*** [" + i + "] ***");
			complexPayload = factory.manufacturePojo(EmployeeComplexPayload.class);
			int num = getRandomNumberInRange(0,10);
			logger.debug("* generated num: " + num);
			
			if(num%2==0) {
				/**/
				logger.debug("* Send to employee channel");
				complexPayload.getCustomMetadata().setChannelName("employeeChannel");
				/**/
				String genName = complexPayload.getEmployeeIntegrationPayload().getName();
				complexPayload.getEmployeeIntegrationPayload().setName("EmployeeName_"+genName);
			}else {
				/**/
				logger.debug("* Send to manager channel");
				complexPayload.getCustomMetadata().setChannelName("managerChannel");
				String genName = complexPayload.getEmployeeIntegrationPayload().getName();
				/**/
				complexPayload.getEmployeeIntegrationPayload().setName("ManagerName_"+genName);
			}
			logger.debug("Object to send: " + complexPayload.toString());
			/**/
			 channel = context.getBean("routerChannel", MessageChannel.class);
				channel.send(MessageBuilder.withPayload(complexPayload).build());
			logger.debug("******************************************************\r\n");
		}
		
		/**/
		//Close spring context
		((ConfigurableApplicationContext)context).close();

	}

	private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
