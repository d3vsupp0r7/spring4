package org.lba.spring4.springintegration;

import java.util.Map;

import org.lba.spring4.springintegration.message.EmployeePayload;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class MainNestedChainApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextForChain.xml");
		/**/
		System.out.println("** Simple nested spring-integration chain example **");
		EmployeePayload payload = new EmployeePayload("aName", "aSurname");
		Message employeeMsg = MessageBuilder.withPayload(payload).build();
		/**/
		System.out.println("** Sending a message **");
		QueueChannel employeeSendChannel = context.getBean("senderChannelForNested", QueueChannel.class);
		employeeSendChannel.send(employeeMsg);
		System.out.println("** MSG Sent **");

		/*Receive flow*/
		QueueChannel employeeRecvChannel = context.getBean("receiverChannelForNested", QueueChannel.class);
		Message employeeRecvMsg = (Message) employeeRecvChannel.receive(2000);
		System.out.println("** Read from receiverChannelForNested **");
		System.out.println("\t** Received payload: " + employeeRecvMsg.getPayload().toString());
		/*Processing headers*/
		System.out.println("\t** Processing received headers **");
		MessageHeaders headers = employeeRecvMsg.getHeaders();
		for (Map.Entry<String, Object> entry : headers.entrySet()) {
			System.out.println("\\t [Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
		}
		//Close spring context
		((ConfigurableApplicationContext)context).close();
		
		
	}

}
