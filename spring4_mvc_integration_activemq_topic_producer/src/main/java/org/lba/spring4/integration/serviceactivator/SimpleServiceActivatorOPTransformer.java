package org.lba.spring4.integration.serviceactivator;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class SimpleServiceActivatorOPTransformer {

	static final Logger logger = Logger.getLogger(SimpleServiceActivatorOPTransformer.class);
	
	@ServiceActivator
	public String handleMessage(Map<String,String> message) {
		logger.debug("SimpleServiceActivatorOPTransformer - Received message: " + message.toString());
		return "SimpleServiceActivatorOPTransformer RETURN MESSAGE:" + message.toString();
	}
}
