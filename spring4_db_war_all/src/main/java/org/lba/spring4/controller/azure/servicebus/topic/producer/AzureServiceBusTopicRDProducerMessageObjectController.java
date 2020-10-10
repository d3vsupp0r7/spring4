package org.lba.spring4.controller.azure.servicebus.topic.producer;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.lba.spring4.config.activemq.JmsProducer;
import org.lba.spring4.db.model.AzureEmployeeDBModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.SubscriptionClient;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

@Profile("azureServiceBus")
@RestController
@RequestMapping("/azureservicebus/topic/rd/obj")
public class AzureServiceBusTopicRDProducerMessageObjectController {

	static final Logger logger = Logger.getLogger(AzureServiceBusTopicRDProducerMessageObjectController.class);

	@Autowired
	JmsProducer producer;

	static final Gson GSON = new Gson();

	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody AzureEmployeeDBModel company){
		try {

			TopicClient sendClient;
			SubscriptionClient subscription1Client;
			SubscriptionClient subscription2Client;

			/**/
			subscription1Client = new SubscriptionClient(new ConnectionStringBuilder(getAzureTopicConnectionString(), "mytopic/subscriptions/subscription1"), ReceiveMode.PEEKLOCK);
			subscription2Client = new SubscriptionClient(new ConnectionStringBuilder(getAzureTopicConnectionString(), "mytopic/subscriptions/subscription2"), ReceiveMode.PEEKLOCK);
			/**/
			sendClient = new TopicClient(new ConnectionStringBuilder(getAzureTopicConnectionString(), "mytopic"));
			/**/
			Gson gson = new Gson();
			String jsonInString = gson.toJson(company);
			logger.debug("Converted obj: " + jsonInString);
			
			Message message = new Message(jsonInString);
			message.setContentType("application/json");
			message.setLabel("Topic Employee Test");
			message.setMessageId("1");
			message.setTimeToLive(Duration.ofMinutes(2));
			/**/
			sendClient.send(message);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceBusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String message = "Message sent to Azure Service Bus queue";
		return new ResponseEntity(message , HttpStatus.OK);
	}

	public String getAzureTopicConnectionString() {

		String result=null;
		/**/
		String namespace = "YOUR_AZURE_NAMESPACE_IS_SERVICEBUS_NAME";
		String entityPath = "YOUR_AZURE_SERVICEBUS_TOPIC_NAME";
		String sakn = "YOUR_SERVICE_BUS_SHARED_ACCESS_KEY_NAME";
		String sasKey = "YOUR_SERVICE_BUS_SHARED_KEY_VALUE";
		/**/
		ConnectionStringBuilder connStr = new ConnectionStringBuilder(namespace,entityPath,sakn,sasKey);
		result = connStr.toString();
		logger.debug("Connection string AzureSeviceBus: " + result);
		/**/
		return result;

	}
}
