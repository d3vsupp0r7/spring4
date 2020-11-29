package org.lba.spring4.integration.serviceactivator;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class SimpleServiceActivator {

	static final Logger logger = Logger.getLogger(SimpleServiceActivator.class);
	
	@ServiceActivator
	public String handleMessage(String message) {
		logger.debug("SimpleServiceActivator - Received message: " + message);
		return "SimpleServiceActivator RETURN MESSAGE:" + message;
	}
}
