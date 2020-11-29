

package org.lba.activemq.standalone.xml;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.support.MessageBuilder;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class ActiveMQStandaloneProducerXmlMainApp {

	static final Logger logger = Logger.getLogger(ActiveMQStandaloneProducerXmlMainApp.class);

	public static void main(String[] args) {
		/**/
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring-integration-activemq-topic-producer.xml");
		context.refresh();
		/**/
		// PODAM message builder
		PodamFactory factory = new PodamFactoryImpl();
		EmployeeComplexPayload complexPayload = factory.manufacturePojo(EmployeeComplexPayload.class);
		logger.debug("Object to send: " + complexPayload.toString());
		/**/
		PublishSubscribeChannel pubSubChannel = BeanFactoryAnnotationUtils.qualifiedBeanOfType(context.getBeanFactory(), PublishSubscribeChannel.class, "activemq-topic-InputChannel");
		pubSubChannel.send(MessageBuilder.withPayload(complexPayload).build());
		/**/
		//Close spring context
		((ConfigurableApplicationContext)context).close();
	}
}
