package org.lba.spring4.springintegration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

public class MainWithTransformerApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextWithTransformer.xml");
		MessageChannel input = (MessageChannel) context.getBean("input");
		PollableChannel output = (PollableChannel) context.getBean("output");
		/**/
		System.out.println("** Preparing a Map message payload **");
        Map<String,String> employeeMap = new HashMap<String, String>();
        employeeMap.put("name", "aNameFromMap");
        employeeMap.put("surname", "aSurnameFromMap");
        System.out.println("Sent: " + employeeMap);
		input.send(MessageBuilder.withPayload(employeeMap).build());
		/**/
		Message<?> reply = output.receive();
		System.out.println("Received payload: " + reply);
		//Close spring context
		((ConfigurableApplicationContext)context).close();
	}

}
