package org.lba.spring4.controller.activemq.queue.springintegration.producer;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("activeMQ")
@RestController
@RequestMapping("/activemq/springintegration/obj")
@ImportResource({ "classpath:springIntegration/spring-integration-activemq-queue.xml"})
public class ActiveMQQueueSpringIntegrationMessageObjectController {

	static final Logger logger = Logger.getLogger(ActiveMQQueueSpringIntegrationMessageObjectController.class);

	@Autowired
	@Qualifier("activemq-inputChannel")
	private MessageChannel activemqInputChannel;
	
	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody EmployeeComplexPayload complexPayload){
		// http://localhost:8080/spring4_db_war_all/activemq/springintegration/obj/message	
		logger.debug("ActiveMQSpringIntegrationMessageObjectController - Send message on queue");
		activemqInputChannel.send(MessageBuilder.withPayload(complexPayload).build());
		
		String messageStr = "ActiveMQSpringIntegrationMessageObjectController - Message sent to activemq queue with spring integration";
		return new ResponseEntity(messageStr , HttpStatus.OK);
	}
}
