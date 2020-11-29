package org.lba.spring4.integration.serviceactivator;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class SimpleServiceActivatorObjectPayload {

	static final Logger logger = Logger.getLogger(SimpleServiceActivatorObjectPayload.class);
	
	@ServiceActivator
	public String handleMessage(EmployeeComplexPayload message) {
		logger.debug("SimpleServiceActivatorObjectPayload - Received message: " + message.toString());
		return "SimpleServiceActivatorObjectPayload RETURN MESSAGE:" + message.toString();
	}
}
