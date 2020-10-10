package org.lba.spring4.integration.serviceactivator.activemq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQSpringIntegrationServiceActivator {

	@ServiceActivator
	public void processMsg(String msg) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("*************"+ msg + " as of "+sdf.format(date)+" ***********  " );
	}

	@ServiceActivator
	public void processMsg( EmployeeComplexPayload complexPayload) {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("*************"+  complexPayload.toString() + " as of "+sdf.format(date)+" ***********  " );
	}

}
