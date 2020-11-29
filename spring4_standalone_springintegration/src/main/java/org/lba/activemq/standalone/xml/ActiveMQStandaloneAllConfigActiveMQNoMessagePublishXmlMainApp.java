

package org.lba.activemq.standalone.xml;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ActiveMQStandaloneAllConfigActiveMQNoMessagePublishXmlMainApp {

	static final Logger logger = Logger.getLogger(ActiveMQStandaloneAllConfigActiveMQNoMessagePublishXmlMainApp.class);

	public static void main(String[] args) {
		/**/
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring-integration-activemq-topic-all-activemq-config.xml");
		context.refresh();
		/**/
		//Close spring context
		((ConfigurableApplicationContext)context).close();
	}
}
