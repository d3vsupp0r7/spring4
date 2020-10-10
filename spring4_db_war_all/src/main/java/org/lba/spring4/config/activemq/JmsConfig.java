package org.lba.spring4.config.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("activeMQ")
public class JmsConfig {  
	
	static final Logger logger = Logger.getLogger(JmsConfig.class);
	
	@Bean
	public Queue queue(){
		return new ActiveMQQueue("test-queue");
	}
}
