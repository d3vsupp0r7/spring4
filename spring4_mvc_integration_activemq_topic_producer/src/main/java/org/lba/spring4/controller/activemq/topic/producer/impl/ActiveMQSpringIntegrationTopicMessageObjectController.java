package org.lba.spring4.controller.activemq.topic.producer.impl;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq/topic/springintegration/obj")
@ImportResource({"classpath:springIntegration/spring-integration-activemq-topic.xml"})
public class ActiveMQSpringIntegrationTopicMessageObjectController {

	static final Logger logger = Logger.getLogger(ActiveMQSpringIntegrationTopicMessageObjectController.class);

	@Autowired
	@Qualifier("activemq-topic-InputChannel")
	private PublishSubscribeChannel pubSubChannel;

	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody EmployeeComplexPayload complexPayload){
		// http://localhost:8080/spring4_mvc_integration_activemq_topic_producer/activemq/topic/springintegration/obj/message
		logger.debug("ActiveMQSpringIntegrationTopicMessageObjectController - Send message on topic");
		pubSubChannel.send(MessageBuilder.withPayload(complexPayload).build());

		String messageStr = "ActiveMQSpringIntegrationTopicMessageObjectController - Message sent to activemq topic with spring integration";
		return new ResponseEntity(messageStr , HttpStatus.OK);
	}
}
