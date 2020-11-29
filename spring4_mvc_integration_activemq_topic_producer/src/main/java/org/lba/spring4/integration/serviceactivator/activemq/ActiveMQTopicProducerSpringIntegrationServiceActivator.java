package org.lba.spring4.integration.serviceactivator.activemq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQTopicProducerSpringIntegrationServiceActivator {

	static final Logger logger = Logger.getLogger(ActiveMQTopicProducerSpringIntegrationServiceActivator.class);
	
	public ActiveMQTopicProducerSpringIntegrationServiceActivator() {
		logger.debug("*** ActiveMQTopicProducerSpringIntegrationServiceActivator - INSTANTIATED *** ");
	}
	
	@ServiceActivator
	public void processMsg(String msg) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("************* RECEIVED PAYLOAD ************* ");
		logger.debug(msg);
		logger.debug("MSG received date: " + sdf.format(date) );
		logger.debug("** ActiveMQTopicProducerSpringIntegrationServiceActivator - processMsg - String Processor - END  **");

	}

	@ServiceActivator
	public void processMsg( EmployeeComplexPayload complexPayload) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("************* RECEIVED PAYLOAD ************* ");
		logger.debug(complexPayload.toString() );
		logger.debug("MSG received date: " + sdf.format(date) );
		logger.debug("** ActiveMQTopicProducerSpringIntegrationServiceActivator - processMsg - Object Processor - END  **");
	
	}

}
