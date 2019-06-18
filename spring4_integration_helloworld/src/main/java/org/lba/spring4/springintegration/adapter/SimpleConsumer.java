package org.lba.spring4.springintegration.adapter;

import org.springframework.messaging.Message;

public class SimpleConsumer {

	public void consume(Message<String> msg) {
		System.out.println( "Consumed: " + msg.getPayload() );
	}
}
