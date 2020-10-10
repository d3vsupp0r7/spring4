package org.lba.spring4.config.azureservicebus;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.EmployeeDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
@Profile("azureServiceBus")
public class JmsAzureProducer {
	
	static final Logger logger = Logger.getLogger(JmsAzureProducer.class);
	
	@Autowired
	JmsTemplate jmsTemplate;

	String queue;

	public void send(EmployeeDBModel company){
		String queue="myqueue";
		jmsTemplate.convertAndSend(queue, company);
	}
}
