package org.lba.spring4.config.activemq;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.EmployeeDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
@Profile("activeMQ")
public class JmsProducer {
	
	static final Logger logger = Logger.getLogger(JmsProducer.class);
	
	@Autowired(required = false)
	JmsTemplate jmsTemplate;

	String queue;

	public void send(EmployeeDBModel company){
		String queue="object-queue";
		jmsTemplate.convertAndSend(queue, company);
	}
}
