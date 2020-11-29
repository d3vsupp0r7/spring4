package org.lba.spring4.integration.filter;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class EmployeeSpringIntegrationFilter implements MessageSelector{

	static final Logger logger = Logger.getLogger(EmployeeSpringIntegrationFilter.class);
	
	@Override
	@Filter
	public boolean accept(Message<?> message) {
		logger.debug("** Filter **");
		boolean accepted = false;
		
		EmployeeComplexPayload employeeComplexPayload = (EmployeeComplexPayload)message.getPayload();
		
		  if (message.getPayload() instanceof EmployeeComplexPayload && employeeComplexPayload.getEmployeeIntegrationPayload().getName().startsWith("b")) {
			  logger.debug("** Message was accepted by filter **");
			  accepted = true;
		  }else {
			  logger.debug("** Message was discarded by filter **");
		  }

		return accepted;
	}

}
