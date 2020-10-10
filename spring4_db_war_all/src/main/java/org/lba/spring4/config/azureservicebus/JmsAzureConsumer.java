package org.lba.spring4.config.azureservicebus;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.EmployeeDBModel;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Profile("azureServiceBus")
public class JmsAzureConsumer {

	static final Logger logger = Logger.getLogger(JmsAzureConsumer.class);
	
	@JmsListener(destination = "myqueue", containerFactory="jsaFactory")
	public void receive(EmployeeDBModel company){
		System.out.println("Recieved Message: " + company);
	}
}
