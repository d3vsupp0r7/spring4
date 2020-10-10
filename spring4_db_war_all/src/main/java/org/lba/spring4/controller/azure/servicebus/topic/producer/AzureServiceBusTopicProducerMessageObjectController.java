package org.lba.spring4.controller.azure.servicebus.topic.producer;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.AzureEmployeeDBModel;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

@Profile("azureServiceBus")
@RestController
@RequestMapping("/azureservicebus/topic/obj")
public class AzureServiceBusTopicProducerMessageObjectController {

	static final Logger logger = Logger.getLogger(AzureServiceBusTopicProducerMessageObjectController.class);

	static final Gson GSON = new Gson();

	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody AzureEmployeeDBModel company){
		try {

			logger.debug("** PRODUCER  - CONTROLLER - START **");
			TopicClient sendClient;

			/**/
			sendClient = new TopicClient(new ConnectionStringBuilder(getAzureTopicConnectionString(), "mytopic"));
			/**/
			Gson gson = new Gson();
			String jsonInString = gson.toJson(company);
			logger.debug("Converted object from Request : " + jsonInString);

			Message message = new Message(jsonInString);
			message.setContentType("application/json");
			message.setLabel("Topic Employee Test");
			message.setMessageId("1");
			message.setTimeToLive(Duration.ofMinutes(2));
			/**/
			sendClient.send(message);
			logger.debug("SEND EXECUTED ON TOPIC");


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceBusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String message = "Message sent to Azure Service Bus TOPIC";
		logger.debug("** PRODUCER  - CONTROLLER - END **");
		return new ResponseEntity(message , HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
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
