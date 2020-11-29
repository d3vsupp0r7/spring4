package org.lba.spring4.integration.transformer;

import java.util.Map;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeIntegrationPayload;
import org.springframework.stereotype.Component;

@Component
public class EmployeeIntegrationPayloadMapToObjectTransformer {

	static final Logger logger = Logger.getLogger(EmployeeIntegrationPayloadMapToObjectTransformer.class);
	
	public EmployeeIntegrationPayload transformData(Map<String,String> message) {
		
		logger.debug("* EmployeeIntegrationPayloadMapToObjectTransformer - START *");
		EmployeeIntegrationPayload employeeIntegrationPayload = new EmployeeIntegrationPayload();
		/**/
		employeeIntegrationPayload.setId(Long.parseLong(message.get("id")) );
		employeeIntegrationPayload.setName(message.get("name") );
		employeeIntegrationPayload.setSurname(message.get("surname") );
		/**/
		logger.debug("CONVERSION: " + employeeIntegrationPayload.toString());
		logger.debug("* EmployeeIntegrationPayloadMapToObjectTransformer - END *");
		return employeeIntegrationPayload;
	}
}
