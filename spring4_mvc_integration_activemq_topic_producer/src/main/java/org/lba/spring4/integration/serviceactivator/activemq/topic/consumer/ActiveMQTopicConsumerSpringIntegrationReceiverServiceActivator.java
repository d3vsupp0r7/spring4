package org.lba.spring4.integration.serviceactivator.activemq.topic.consumer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.ServiceActivator;

@Configuration
@ImportResource({ "classpath:springIntegration/spring-integration-activemq-consumer-topic.xml"})
public class ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator {

	static final Logger logger = Logger.getLogger(ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator.class);
	
	public ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator() {
		logger.debug("*** ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator - INSTANTIATED *** ");
	}
	
	@ServiceActivator
	public void processMsg(String msg) {
		logger.debug("*** ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator - processMsg - String Processor - START  ***");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("* RECEIVED PAYLOAD *");
		logger.debug(msg);
		logger.debug("MSG received date: " + sdf.format(date) );
		logger.debug("*** ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator - processMsg - String Processor - END  ***");
	}

	@ServiceActivator
	public void processMsg( EmployeeComplexPayload complexPayload) {
		logger.debug("*** ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator - processMsg - Object Processor - START  ***");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("* RECEIVED PAYLOAD *");
		logger.debug(complexPayload.toString() );
		logger.debug("MSG received date: " + sdf.format(date) );
		logger.debug("*** ActiveMQTopicConsumerSpringIntegrationReceiverServiceActivator - processMsg - Object Processor - END  ***");
	}

}
