package org.lba.spring4.integration.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/rest/api/integration/simple")
@ImportResource({ "classpath:springIntegration/spring-integration-simple.xml",
"classpath:springIntegration/spring-integration-objectPayload.xml",
"classpath:springIntegration/spring-integration-objectPayloadWithTransformer.xml",
"classpath:springIntegration/spring-integration-objectPayloadWithFilter.xml"})
public class SimpleIntegrationRestController {

	static final Logger logger = Logger.getLogger(SimpleIntegrationRestController.class);

	@Autowired
	@Qualifier("simpleinput")
	private MessageChannel simpleinput;

	@Autowired
	PollableChannel simpleoutput;

	/**/
	@Autowired
	@Qualifier("simpleObjectPayloadInputChannel")
	private MessageChannel simpleObjectPayloadInputChannel;

	@Autowired
	PollableChannel simpleObjectPayloadOutputChannel;
	/**/
	@Autowired
	@Qualifier("simpleOPInputChannel")
	private MessageChannel simpleOPInputChannel;
	
	@Autowired
	PollableChannel simpleOPOutputChannel;
	/**/
	@Autowired
	@Qualifier("simpleOPFilterInputChannel")
	private MessageChannel simpleOPFilterInputChannel;
	
	@Autowired
	PollableChannel simpleOPFilterOutputChannel;
	

	@GetMapping("/s1")
	public ResponseEntity<String> simpleIntegration(){
		// http://localhost:8080/spring4_mvc_integration_activemq_topic_producer/rest/api/integration/simple/s1
		/**/
		simpleinput.send(MessageBuilder.withPayload("Message - simpleIntegration - s1").build());
		/**/
		Message<?> reply = simpleoutput.receive();
		logger.debug("* OUTPUT CHANNEL:received: " + reply);
		/**/
		String message = "Message sent with spring integration";
		return new ResponseEntity<String>(message , HttpStatus.OK);
	}

	@PostMapping("/s1/complexpayload")
	public ResponseEntity<String> simpleIntegration(@RequestBody EmployeeComplexPayload complexPayload){
		// http://localhost:8080/spring4_mvc_integration_activemq_topic_producer/rest/api/integration/simple/s1/complexpayload
		/**/
		simpleObjectPayloadInputChannel.send(MessageBuilder.withPayload(complexPayload).build());
		/**/
		Message<?> reply = simpleObjectPayloadOutputChannel.receive();
		logger.debug("* OUTPUT CHANNEL:received: " + reply);
		/**/
		String message = "Message sent with spring integration";
		return new ResponseEntity<String>(message , HttpStatus.OK);
	}

	@PostMapping("/s1/pltransformer")
	public ResponseEntity<String> simpleIntegrationTransformer(@RequestBody EmployeeComplexPayload complexPayload){
		// http://localhost:8080/spring4_mvc_integration_activemq_topic_producer/rest/api/integration/simple/s1/pltransformer
		/**/
		Map<String,String> patientMap = new HashMap<String, String>();
		patientMap.put("id", complexPayload.getEmployeeIntegrationPayload().getId().toString());
		patientMap.put("name", "aNameFromMap");
		patientMap.put("surname", "aSurnameFromMap");
		logger.debug("Sent: " + patientMap);

		simpleOPInputChannel.send(MessageBuilder.withPayload(patientMap).build());
		/**/
		Message<?> reply = simpleOPOutputChannel.receive();
		logger.debug("* OUTPUT CHANNEL:received: " + reply);
		/**/
		String message = "Message sent with spring integration";
		return new ResponseEntity<String>(message , HttpStatus.OK);
	}

	@PostMapping("/s1/filter")
	public ResponseEntity<String> simpleIntegrationFilter(@RequestBody EmployeeComplexPayload complexPayload){
		// http://localhost:8080/spring4_mvc_integration_activemq_topic_producer/rest/api/integration/simple/s1/filter
		/**/
		simpleOPFilterInputChannel.send(MessageBuilder.withPayload(complexPayload).build());
		/**/
		Message<?> reply = simpleOPFilterOutputChannel.receive();
		logger.debug("* OUTPUT CHANNEL:received: " + reply);
		/**/
		String message = "Message sent with spring integration";
		return new ResponseEntity<String>(message , HttpStatus.OK);
	}
}
