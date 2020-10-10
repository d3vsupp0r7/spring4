package org.lba.spring4.controller.activemq.queue.producer;

import org.apache.log4j.Logger;
import org.lba.spring4.config.activemq.JmsProducer;
import org.lba.spring4.db.model.EmployeeDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("activeMQ")
@RestController
@RequestMapping("/activemq/obj")
public class ActiveMQMessageObjectController {

	static final Logger logger = Logger.getLogger(ActiveMQMessageObjectController.class);
		
	@Autowired
	JmsProducer producer;

	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody EmployeeDBModel employee){
		producer.send(employee);
		String message = "Message sent to activemq queue";
		return new ResponseEntity(message , HttpStatus.OK);
	}
}
