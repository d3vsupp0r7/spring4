package org.lba.spring4.springintegration.filter;

import org.lba.spring4.springintegration.message.EmployeePayload;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class EmployeeNameFilterForChain_ExampleForError implements MessageSelector{

	public boolean accept(Message<?> message) {
		System.out.println("** Filter **");
		boolean accepted = false;
		
		EmployeePayload p = (EmployeePayload)message.getPayload();
		
		  if (message.getPayload() instanceof EmployeePayload && p.getName().startsWith("b")) {
			  System.out.println("\t ** Message was accepted by filter **");
			  accepted = true;
		  }

		return accepted;
	}

}
