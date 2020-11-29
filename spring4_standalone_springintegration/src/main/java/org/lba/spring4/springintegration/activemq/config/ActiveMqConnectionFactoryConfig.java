package org.lba.spring4.springintegration.activemq.config;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQPrefetchPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class ActiveMqConnectionFactoryConfig {

	@Value("${spring.activemq.broker-url}")
	String brokerUrl;

	@Value("${spring.activemq.user}")
	String userName;

	@Value("${spring.activemq.password}")
	String password;

	/*
	 * Initial ConnectionFactory
	 */
	@Bean
	public ConnectionFactory connectionFactory(){


		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		connectionFactory.setBrokerURL(brokerUrl);
		connectionFactory.setUserName(userName);
		connectionFactory.setPassword(password);

		/**/
		connectionFactory.setTrustedPackages(Arrays.asList("org.lba.spring4.integration.payload","java.lang","java.util"));
		/**/

		/**/
		ActiveMQPrefetchPolicy policy = new ActiveMQPrefetchPolicy();
		policy.setQueuePrefetch(1);
		connectionFactory.setPrefetchPolicy(policy);
		/**/

		return connectionFactory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

}
