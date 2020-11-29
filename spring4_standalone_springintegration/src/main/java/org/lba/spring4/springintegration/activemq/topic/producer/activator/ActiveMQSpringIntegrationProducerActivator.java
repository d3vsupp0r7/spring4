package org.lba.spring4.springintegration.activemq.topic.producer.activator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQSpringIntegrationProducerActivator {

	static final Logger logger = Logger.getLogger(ActiveMQSpringIntegrationProducerActivator.class);
	
	public ActiveMQSpringIntegrationProducerActivator() {
		logger.debug("*** ActiveMQSpringIntegrationProducerActivator [CONSTRUCTOR - STARTED ] ***");
	}
	
	@ServiceActivator
	public void processMsg( EmployeeComplexPayload complexPayload) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("************* Produer Activator -  PAYLOAD ************* ");
		logger.debug(complexPayload.toString() );
		logger.debug("MSG received date: " + sdf.format(date) );
		logger.debug("** ActiveMQTopicProducerSpringIntegrationServiceActivator - processMsg - Object Processor - END  **");
	
	}
}
