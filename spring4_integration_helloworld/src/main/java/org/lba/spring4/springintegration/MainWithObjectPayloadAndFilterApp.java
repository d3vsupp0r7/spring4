package org.lba.spring4.springintegration;

import org.lba.spring4.springintegration.message.EmployeePayload;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

public class MainWithObjectPayloadAndFilterApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextWithPayloadAndFilter.xml");
		MessageChannel input = (MessageChannel) context.getBean("inboundChannel");
		PollableChannel output = (PollableChannel) context.getBean("outboundChannel");
		/**/
		EmployeePayload payload = new EmployeePayload("aName", "aSurname");
		/**/
		input.send(MessageBuilder.withPayload(payload).build());
		Message<?> reply = output.receive();
		System.out.println("received: " + reply.toString());
		//Close spring context
		((ConfigurableApplicationContext)context).close();
	}

}
