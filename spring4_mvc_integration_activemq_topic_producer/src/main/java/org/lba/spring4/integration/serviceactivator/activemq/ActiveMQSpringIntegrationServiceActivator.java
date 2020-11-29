package org.lba.spring4.integration.serviceactivator.activemq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQSpringIntegrationServiceActivator {

	static final Logger logger = Logger.getLogger(ActiveMQSpringIntegrationServiceActivator.class);
	
	public ActiveMQSpringIntegrationServiceActivator() {
		logger.debug("*** ActiveMQSpringIntegrationServiceActivator - CONSTRUCTOR - STARTED ***");
	}
	
	@ServiceActivator
	public void processMsg(String msg) {
		logger.debug("*** ActiveMQSpringIntegrationServiceActivator - processMsg - String param  - START ***");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("** processMsg - received : "+ msg + " as of " + sdf.format(date) + " **" );
		logger.debug("*** ActiveMQSpringIntegrationServiceActivator - processMsg - String param  - END ***");
	}

	@ServiceActivator
	public void processMsg( EmployeeComplexPayload complexPayload) {
		logger.debug("*** ActiveMQSpringIntegrationServiceActivator - processMsg - Complex Payload Object param  - START ***");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("** processMsg - received : "+  complexPayload.toString() + " as of " + sdf.format(date) + " **" );
		logger.debug("*** ActiveMQSpringIntegrationServiceActivator - processMsg - Complex Payload Object param  - END ***");
	}

}
