 package org.lba.spring4.springintegration;

import org.lba.spring4.springintegration.message.EmployeePayload;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class MainChainApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContextForChain.xml");
		/**/
		System.out.println("** Simple spring-integration chain example **");
		EmployeePayload payload = new EmployeePayload("aName", "aSurname");
		Message employeeMsg = MessageBuilder.withPayload(payload).build();
		/**/
		System.out.println("** Sending a message **");
		QueueChannel employeeSendChannel = context.getBean("senderChannel", QueueChannel.class);
		employeeSendChannel.send(employeeMsg);
		System.out.println("** MSG Sent **");

		/*Receive flow*/
		QueueChannel employeeRecvChannel = context.getBean("receiverChannel", QueueChannel.class);
		Message employeeRecvMsg = (Message) employeeRecvChannel.receive(2000);
		System.out.println("** Read from receiverChannel **");
		System.out.println("Received payload: " + employeeRecvMsg.getPayload().toString());
		System.out.println("Message Header: " + employeeRecvMsg.getHeaders().get("enriched").toString());
		//Close spring context
		((ConfigurableApplicationContext)context).close();
		
		
	}

}
