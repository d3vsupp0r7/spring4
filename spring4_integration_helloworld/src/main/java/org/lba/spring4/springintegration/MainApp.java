package org.lba.spring4.springintegration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;

public class MainApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		MessageChannel input = (MessageChannel) context.getBean("input");
		PollableChannel output = (PollableChannel) context.getBean("output");
		input.send(MessageBuilder.withPayload("Simple String message").build());
		Message<?> reply = output.receive();
		System.out.println("received: " + reply);
		//Close spring context
		((ConfigurableApplicationContext)context).close();
	}

}
