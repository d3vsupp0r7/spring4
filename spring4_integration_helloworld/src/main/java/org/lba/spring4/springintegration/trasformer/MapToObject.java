package org.lba.spring4.springintegration.trasformer;

import java.util.Map;

import org.lba.spring4.springintegration.message.EmployeePayload;
import org.springframework.stereotype.Component;

@Component
public class MapToObject {

	public EmployeePayload map(Map<String,String> message) {
		
		EmployeePayload employeeTransformationFromSIMessage = new EmployeePayload();
		employeeTransformationFromSIMessage.setName(message.get("name"));
		employeeTransformationFromSIMessage.setSurname(message.get("surname"));

		return employeeTransformationFromSIMessage;
	}
}
