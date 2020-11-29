package org.lba.spring4.springintegration.activemq.topic.consumer.subscribers;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component	
public class Subscriber1MessageListener implements MessageListener {
	
	static final Logger logger = Logger.getLogger(Subscriber1MessageListener.class);
	
	public Subscriber1MessageListener() {
		logger.debug("*** Subscriber1MessageListener [CONSTRUCTOR - STARTED ] ***");
	}

	@Override
	public void onMessage(javax.jms.Message message) {
		if (message instanceof TextMessage) {
			try {
				String msg = ((TextMessage) message).getText();
				logger.debug("Message consumed by MessageSubscriber1 : " + msg);
			} catch (JMSException ex) {
				throw new RuntimeException(ex);
			}
		} else {
			throw new IllegalArgumentException("Message must be of type TextMessage");
		}
		
	}
	
}
