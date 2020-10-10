package org.lba.spring4.controller.azure.servicebus.queue.producer;

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
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;

@Profile("azureServiceBus")
@RestController
@RequestMapping("/azureservicebus/obj")
public class AzureServiceBusMessageObjectController {

	static final Logger logger = Logger.getLogger(AzureServiceBusMessageObjectController.class);
	
	@Autowired
	JmsProducer producer;

	@PostMapping("/message")
	public ResponseEntity<String> publish(@RequestBody AzureEmployeeDBModel employee){

		try {
			
			QueueClient sendClient = new QueueClient(new ConnectionStringBuilder(getConnectionString(), "myqueue"), ReceiveMode.PEEKLOCK);
			/**/
			Gson gson = new Gson();
			String jsonInString = gson.toJson(employee);
			logger.debug("Converted obj: " + jsonInString);
			/**/
			Message m = new Message(jsonInString);
			m.setContentType("application/json");
			m.setLabel("Test Employee message");
			m.setMessageId(Integer.toString(1));
			/**/
			sendClient.send(m);
			/**/
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceBusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		String message = "Message sent to AzureServiceBus queue";
		return new ResponseEntity(message , HttpStatus.OK);
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
		logger.debug("Connection string AzureSeviceBus: " + result);
		/**/
		return result;

	}
}
