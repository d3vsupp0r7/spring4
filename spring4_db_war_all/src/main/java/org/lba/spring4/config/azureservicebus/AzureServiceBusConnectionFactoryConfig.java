package org.lba.spring4.config.azureservicebus;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;

@Configuration
@Profile("azureServiceBus")
public class AzureServiceBusConnectionFactoryConfig {

	static final Logger logger = Logger.getLogger(AzureServiceBusConnectionFactoryConfig.class);
	
	@Value("${azure.servicebus.namespace}")
	String namespace;
	
	@Value("${azure.servicebus.sakn}")
	String sasKeyName;
	
	@Value("${azure.servicebus.sasKey}")
	String  sasKey;
	
	@Value("${azure.servicebus.queue.name1}")
	String  azureQueueName;
	
	@Value("${azure.servicebus.topic.name1}")
	String azureTopic1Name;

	/*
	 * Initial ConnectionFactory
	 */
	@Bean
	public ConnectionFactory connectionFactory(){
		
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		/**/
		logger.debug("*** AzureConnectionFactoryConfig - START ***");
		logger.debug("* namespace: " + namespace);
		logger.debug("* sasKeyName: " + sasKeyName);
		logger.debug("* sasKey: " + sasKey);
		logger.debug("* azureQueueName: " + azureQueueName);
		logger.debug("* azureTopic1Name: " + azureTopic1Name);
		logger.debug("*** AzureConnectionFactoryConfig -   END ***");
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

	/*
	 * Used for Receiving Message
	 */
	/* @Bean
    public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(jacksonJmsMessageConverter());
        configurer.configure(factory, connectionFactory);
        return factory;
    }*/

	/*
	 * Used for Sending Messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate template = new JmsTemplate();
		template.setMessageConverter(jacksonJmsMessageConverter());
		template.setConnectionFactory(connectionFactory());
		return template;
	}

	/**/
	public String getConnectionString() {
		
		String result=null;
		/**/
		String namespace = "YOUR_AZURE_NAMESPACE_IS_SERVICEBUS_NAME";
		String entityPath = "YOUR_AZURE_SERVICEBUS_QUEUE_NAME";
		String sakn = "YOUR_SERVICE_BUS_SHARED_ACCESS_KEY_NAME";
		String sasKey = "YOUR_SERVICE_BUS_SHARED_KEY_VALUE";
		/**/
		ConnectionStringBuilder connStr = new ConnectionStringBuilder(namespace,entityPath,sakn,sasKey);
		result = connStr.toString();
		logger.debug("Connection string azure SeviceBus: " + result);
		/**/
		return result;

	}
}
