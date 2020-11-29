package org.lba.spring4.integration.router.basic.serviceactivator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.lba.spring4.integration.payload.EmployeeComplexPayload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class ManagerBasicRoutingServiceActivator {
	
	static final Logger logger = Logger.getLogger(ManagerBasicRoutingServiceActivator.class);
	
	@ServiceActivator
	public void processMsg(String msg) {
		logger.debug("************* ManagerRoutingServiceActivator RECEIVED PAYLOAD - START ************* ");
		logger.debug("** ManagerRoutingServiceActivator - processMsg - String Processor - START  **");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("************* RECEIVED PAYLOAD ************* ");
		logger.debug(msg);
		logger.debug("MSG received date: " + sdf.format(date) );
		logger.debug("** ManagerRoutingServiceActivator - processMsg - String Processor - END  **");
		logger.debug("************* ManagerRoutingServiceActivator RECEIVED PAYLOAD - END ************* ");
	}

	@ServiceActivator
	public void processMsg( EmployeeComplexPayload complexPayload) {
		logger.debug("************* ManagerRoutingServiceActivator RECEIVED PAYLOAD - START ************* ");
		logger.debug("** ManagerRoutingServiceActivator - processMsg - Object Processor - START  **");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		logger.debug("************* RECEIVED PAYLOAD ************* ");
		logger.debug(complexPayload.toString() );
		logger.debug("MSG received date: " + sdf.format(date) );
		logger.debug("** ManagerRoutingServiceActivator - processMsg - Object Processor - END  **");
		logger.debug("************* ManagerRoutingServiceActivator RECEIVED PAYLOAD - END ************* ");
	}
}
