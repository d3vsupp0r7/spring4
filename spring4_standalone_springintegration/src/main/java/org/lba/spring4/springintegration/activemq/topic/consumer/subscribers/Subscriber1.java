package org.lba.spring4.springintegration.activemq.topic.consumer.subscribers;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class Subscriber1 implements MessageHandler {

	static final Logger logger = Logger.getLogger(Subscriber1.class);
	
	public Subscriber1() {
		logger.debug("*** Subscriber1 [CONSTRUCTOR - STARTED ] ***");
	}

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {
		logger.debug("************* RECEIVED PAYLOAD - Subscriber1 [S1] - START ************* ");
		logger.debug("*** Subscriber1 Handler - START **");
		logger.debug("* Msg Payload: " + ((EmployeeComplexPayload)message.getPayload()).toString() );
		logger.debug("*** Subscriber1 Handler - END **");
		logger.debug("************* RECEIVED PAYLOAD - Subscriber1 [S1] - END ************* ");
		
		
	}
	
}
