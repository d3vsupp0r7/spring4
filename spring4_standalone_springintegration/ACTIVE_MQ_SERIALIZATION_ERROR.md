## Problem - 1

101 [main] INFO org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [spring-integration-activemq-topic-all-config.xml]
524 [main] INFO org.springframework.integration.config.IntegrationRegistrar - No bean named 'integrationHeaderChannelRegistry' has been explicitly defined. Therefore, a default DefaultHeaderChannelRegistry will be created.
602 [main] INFO org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@2a33fae0: startup date [Sun Nov 29 09:52:34 CET 2020]; root of context hierarchy
735 [main] INFO org.springframework.integration.config.DefaultConfiguringBeanFactoryPostProcessor - No bean named 'errorChannel' has been explicitly defined. Therefore, a default PublishSubscribeChannel will be created.
735 [main] INFO org.springframework.integration.config.DefaultConfiguringBeanFactoryPostProcessor - No bean named 'taskScheduler' has been explicitly defined. Therefore, a default ThreadPoolTaskScheduler will be created.
1397 [main] INFO org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler - Initializing ExecutorService  'taskScheduler'
1591 [main] INFO org.springframework.context.support.DefaultLifecycleProcessor - Starting beans in phase 0
1591 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Adding {jms:outbound-channel-adapter} as a subscriber to the 'activemq-topic-InputChannel' channel
1598 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 1 subscriber(s).
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - started org.springframework.integration.config.ConsumerEndpointFactoryBean#0
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Adding {service-activator:messageHandlerTopic} as a subscriber to the 'activemq-topic-InputChannel' channel
1598 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 2 subscriber(s).
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - started messageHandlerTopic
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Adding {message-handler:offeringmsg1} as a subscriber to the 'activemq-topic-InputChannel' channel
1598 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 3 subscriber(s).
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - started offeringmsg1
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Adding {message-handler:offeringmsg2} as a subscriber to the 'activemq-topic-InputChannel' channel
1598 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 4 subscriber(s).
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - started offeringmsg2
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Adding {logging-channel-adapter:_org.springframework.integration.errorLogger} as a subscriber to the 'errorChannel' channel
1598 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.errorChannel' has 1 subscriber(s).
1598 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - started _org.springframework.integration.errorLogger
1598 [main] INFO org.springframework.context.support.DefaultLifecycleProcessor - Starting beans in phase 1073741823
1598 [main] INFO org.springframework.integration.jms.ChannelPublishingJmsMessageListener$GatewayDelegate - started org.springframework.integration.jms.ChannelPublishingJmsMessageListener$GatewayDelegate@c430e6c
1808 [main] INFO org.springframework.integration.jms.JmsMessageDrivenEndpoint - started messageDrivenAdapter
2020-11-29 09:52:35 DEBUG ActiveMQStandaloneAllConfigXmlMainApp:32 - Object to send: EmployeeComplexPayload [customMetadata=CustomMetadata [maxMessages=364556534], employeeIntegrationPayload=EmployeeIntegrationPayload [id=7984633205400, name=VixniOqeQr, surname=CK7UWICkmD]]
2020-11-29 09:52:35 DEBUG ActiveMQSpringIntegrationProducerActivator:21 - ************* Produer Activator -  PAYLOAD ************* 
2020-11-29 09:52:35 DEBUG ActiveMQSpringIntegrationProducerActivator:22 - EmployeeComplexPayload [customMetadata=CustomMetadata [maxMessages=364556534], employeeIntegrationPayload=EmployeeIntegrationPayload [id=7984633205400, name=VixniOqeQr, surname=CK7UWICkmD]]
2020-11-29 09:52:35 DEBUG ActiveMQSpringIntegrationProducerActivator:23 - MSG received date: 2020/11/29 09:52:35
2020-11-29 09:52:35 DEBUG ActiveMQSpringIntegrationProducerActivator:24 - ** ActiveMQTopicProducerSpringIntegrationServiceActivator - processMsg - Object Processor - END  **
2020-11-29 09:52:35 DEBUG Subscriber1:15 - ************* RECEIVED PAYLOAD - Subscriber1 [S1] - START ************* 
2020-11-29 09:52:35 DEBUG Subscriber1:16 - *** Subscriber1 Handler - START **
2020-11-29 09:52:35 DEBUG Subscriber1:17 - * Msg Payload: EmployeeComplexPayload [customMetadata=CustomMetadata [maxMessages=364556534], employeeIntegrationPayload=EmployeeIntegrationPayload [id=7984633205400, name=VixniOqeQr, surname=CK7UWICkmD]]
2020-11-29 09:52:35 DEBUG Subscriber1:18 - *** Subscriber1 Handler - END **
2020-11-29 09:52:35 DEBUG Subscriber1:19 - ************* RECEIVED PAYLOAD - Subscriber1 [S1] - END ************* 
2020-11-29 09:52:35 DEBUG Subscriber2:16 - ************* RECEIVED PAYLOAD - Subscriber2 [S2] - START ************* 
2020-11-29 09:52:35 DEBUG Subscriber2:17 - *** Subscriber2 Handler - START **
2020-11-29 09:52:35 DEBUG Subscriber2:18 - * Msg Payload: EmployeeComplexPayload [customMetadata=CustomMetadata [maxMessages=364556534], employeeIntegrationPayload=EmployeeIntegrationPayload [id=7984633205400, name=VixniOqeQr, surname=CK7UWICkmD]]
2020-11-29 09:52:35 DEBUG Subscriber2:19 - *** Subscriber2 Handler - END **
2020-11-29 09:52:35 DEBUG Subscriber2:20 - ************* RECEIVED PAYLOAD - Subscriber2 [S2] -   END ************* 
1878 [main] INFO org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@2a33fae0: startup date [Sun Nov 29 09:52:34 CET 2020]; root of context hierarchy
1878 [main] INFO org.springframework.context.support.DefaultLifecycleProcessor - Stopping beans in phase 2147483647
1878 [messageDrivenAdapter.container-1] WARN org.springframework.jms.listener.DefaultMessageListenerContainer - Execution of JMS message listener failed, and no ErrorHandler has been set.
1878 [main] INFO org.springframework.integration.jms.ChannelPublishingJmsMessageListener$GatewayDelegate - stopped org.springframework.integration.jms.ChannelPublishingJmsMessageListener$GatewayDelegate@c430e6c
1878 [main] INFO org.springframework.integration.jms.JmsMessageDrivenEndpoint - stopped messageDrivenAdapter
1878 [main] INFO org.springframework.context.support.DefaultLifecycleProcessor - Stopping beans in phase 1073741823
javax.jms.JMSException: Failed to build body from content. Serializable class not available to broker. Reason: java.lang.ClassNotFoundException: Forbidden class org.lba.spring4.integration.payload.EmployeeComplexPayload! This class is not trusted to be serialized as ObjectMessage payload. Please take a look at http://activemq.apache.org/objectmessage.html for more information on how to configure trusted classes.
	at org.apache.activemq.util.JMSExceptionSupport.create(JMSExceptionSupport.java:36)
	at org.apache.activemq.command.ActiveMQObjectMessage.getObject(ActiveMQObjectMessage.java:213)
	at org.springframework.jms.support.converter.SimpleMessageConverter.extractSerializableFromMessage(SimpleMessageConverter.java:218)
	at org.springframework.jms.support.converter.SimpleMessageConverter.fromMessage(SimpleMessageConverter.java:105)
	at org.springframework.integration.jms.ChannelPublishingJmsMessageListener.onMessage(ChannelPublishingJmsMessageListener.java:317)
	at org.springframework.jms.listener.AbstractMessageListenerContainer.doInvokeListener(AbstractMessageListenerContainer.java:721)
	at org.springframework.jms.listener.AbstractMessageListenerContainer.invokeListener(AbstractMessageListenerContainer.java:681)
	at org.springframework.jms.listener.AbstractMessageListenerContainer.doExecuteListener(AbstractMessageListenerContainer.java:651)
	at org.springframework.jms.listener.AbstractPollingMessageListenerContainer.doReceiveAndExecute(AbstractPollingMessageListenerContainer.java:317)
	at org.springframework.jms.listener.AbstractPollingMessageListenerContainer.receiveAndExecute(AbstractPollingMessageListenerContainer.java:255)
	at org.springframework.jms.listener.DefaultMessageListenerContainer$AsyncMessageListenerInvoker.invokeListener(DefaultMessageListenerContainer.java:1166)
	at org.springframework.jms.listener.DefaultMessageListenerContainer$AsyncMessageListenerInvoker.executeOngoingLoop(DefaultMessageListenerContainer.java:1158)
	at org.springframework.jms.listener.DefaultMessageListenerContainer$AsyncMessageListenerInvoker.run(DefaultMessageListenerContainer.java:1055)
	at java.lang.Thread.run(Thread.java:748)
Caused by: java.lang.ClassNotFoundException: Forbidden class org.lba.spring4.integration.payload.EmployeeComplexPayload! This class is not trusted to be serialized as ObjectMessage payload. Please take a look at http://activemq.apache.org/objectmessage.html for more information on how to configure trusted classes.
	at org.apache.activemq.util.ClassLoadingAwareObjectInputStream.checkSecurity(ClassLoadingAwareObjectInputStream.java:111)
	at org.apache.activemq.util.ClassLoadingAwareObjectInputStream.resolveClass(ClassLoadingAwareObjectInputStream.java:56)
	at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:1868)
	at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1751)
	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2042)
	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1573)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:431)
	at org.apache.activemq.command.ActiveMQObjectMessage.getObject(ActiveMQObjectMessage.java:211)
	... 12 more
1878 [main] INFO org.springframework.context.support.DefaultLifecycleProcessor - Stopping beans in phase 0
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Removing {jms:outbound-channel-adapter} as a subscriber to the 'activemq-topic-InputChannel' channel
1878 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 3 subscriber(s).
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - stopped org.springframework.integration.config.ConsumerEndpointFactoryBean#0
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Removing {service-activator:messageHandlerTopic} as a subscriber to the 'activemq-topic-InputChannel' channel
1878 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 2 subscriber(s).
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - stopped messageHandlerTopic
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Removing {message-handler:offeringmsg1} as a subscriber to the 'activemq-topic-InputChannel' channel
1878 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 1 subscriber(s).
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - stopped offeringmsg1
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Removing {message-handler:offeringmsg2} as a subscriber to the 'activemq-topic-InputChannel' channel
1878 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.activemq-topic-InputChannel' has 0 subscriber(s).
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - stopped offeringmsg2
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - Removing {logging-channel-adapter:_org.springframework.integration.errorLogger} as a subscriber to the 'errorChannel' channel
1878 [main] INFO org.springframework.integration.channel.PublishSubscribeChannel - Channel 'org.springframework.context.support.GenericXmlApplicationContext@2a33fae0.errorChannel' has 0 subscriber(s).
1878 [main] INFO org.springframework.integration.endpoint.EventDrivenConsumer - stopped _org.springframework.integration.errorLogger
6888 [messageDrivenAdapter.container-1] WARN org.springframework.jms.listener.DefaultMessageListenerContainer - Setup of JMS message listener invoker failed for destination 'activemq-springintegration-topic' - trying to recover. Cause: Failed to build body from content. Serializable class not available to broker. Reason: java.lang.ClassNotFoundException: Forbidden class org.lba.spring4.integration.payload.EmployeeComplexPayload! This class is not trusted to be serialized as ObjectMessage payload. Please take a look at http://activemq.apache.org/objectmessage.html for more information on how to configure trusted classes.
6895 [main] INFO org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler - Shutting down ExecutorService 'taskScheduler'


## Solution - 1

org.lba.spring4.springintegration.activemq.config.ActiveMqConnectionFactoryConfig

```
...
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
...

```