package org.lba.spring4.springintegration.activemq.topic.consumer.subscribers;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class Subscriber2 implements MessageHandler{

	static final Logger logger = Logger.getLogger(Subscriber2.class);
	
	public Subscriber2() {
		// 
		logger.debug("*** Subscriber2 [CONSTRUCTOR - STARTED ] ***");
	}

	@Override
	public void handleMessage(Message<?> message) throws MessagingException {

		logger.debug("************* RECEIVED PAYLOAD - Subscriber2 [S2] - START ************* ");
		logger.debug("*** Subscriber2 Handler - START **");
		logger.debug("* Msg Payload: " + ((EmployeeComplexPayload)message.getPayload()).toString() );
		logger.debug("*** Subscriber2 Handler - END **");
		logger.debug("************* RECEIVED PAYLOAD - Subscriber2 [S2] -   END ************* ");
	}
	
}
