package org.lba.spring4.config.activemq;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.EmployeeDBModel;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Profile("activeMQ")
public class JmsConsumer {

	static final Logger logger = Logger.getLogger(JmsConsumer.class);
	
	@JmsListener(destination = "object-queue", containerFactory="jsaFactory")
	public void receive(EmployeeDBModel company){
		System.out.println("Recieved Message: " + company);
	}
}
