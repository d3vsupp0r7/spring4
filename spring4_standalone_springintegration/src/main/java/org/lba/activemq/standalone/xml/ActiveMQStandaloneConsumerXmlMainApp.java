package org.lba.activemq.standalone.xml;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.log4j.Logger;
import org.lba.spring4.springintegration.activemq.topic.consumer.subscribers.Subscriber1;
import org.lba.spring4.springintegration.activemq.topic.consumer.subscribers.Subscriber1MessageListener;
import org.lba.spring4.springintegration.activemq.topic.consumer.subscribers.Subscriber2;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.channel.PublishSubscribeChannel;

public class ActiveMQStandaloneConsumerXmlMainApp {

	static final Logger logger = Logger.getLogger(ActiveMQStandaloneConsumerXmlMainApp.class);
		
	public static void main(String[] args) {
		/**/
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring-integration-activemq-topic-consumer.xml");
		context.refresh();
		/**/
		PublishSubscribeChannel pubSubChannel = BeanFactoryAnnotationUtils.qualifiedBeanOfType(context.getBeanFactory(), PublishSubscribeChannel.class, "activemq-topic-InputChannel");
		/**/
		Subscriber1 service1 = (Subscriber1) context.getBean("subscriber1");
		Subscriber2 service2 = (Subscriber2) context.getBean("subscriber2");
		Subscriber1MessageListener service3 = (Subscriber1MessageListener) context.getBean("messageSubscriber1");
		/**/
		pubSubChannel.subscribe(service1);
		pubSubChannel.subscribe(service2);

		//Close spring context
		((ConfigurableApplicationContext)context).close();
	}
	
}
