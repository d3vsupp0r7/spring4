package org.lba.spring4.controller.activemq.queue.producer.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq/queue/springintegration/obj")
@ImportResource({"classpath:springIntegration/spring-integration-activemq-queue.xml"})
public class ActiveMQSpringIntegrationQueueMessageProducerObjectController {

	static final Logger logger = Logger.getLogger(ActiveMQSpringIntegrationQueueMessageProducerObjectController.class);

	@Autowired
	@Qualifier("activemq-inputChannel")
	private MessageChannel activemqInputChannel;
	
	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody EmployeeComplexPayload complexPayload){
		// http://localhost:8080/spring4_mvc_integration_activemq_topic_producer/activemq/queue/springintegration/obj/message
		
		logger.debug("ActiveMQSpringIntegrationMessageObjectController - Send message on queue");
		activemqInputChannel.send(MessageBuilder.withPayload(complexPayload).build());
		
		String messageStr = "ActiveMQSpringIntegrationMessageObjectController - Message sent to activemq queue with spring integration";
		return new ResponseEntity(messageStr , HttpStatus.OK);
	}
}
