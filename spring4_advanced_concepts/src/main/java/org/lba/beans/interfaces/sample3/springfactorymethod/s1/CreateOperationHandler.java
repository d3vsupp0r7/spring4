package org.lba.beans.interfaces.sample3.springfactorymethod.s1;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("createOperationHandler")
public class CreateOperationHandler implements CRUDOperationHandler {

	static final Logger LOGGER = Logger.getLogger(CreateOperationHandler.class);
	
	@Override
	public void process() {
		LOGGER.debug("CreateOperationHandler - process - START");

	}

	@Override
	public void processWithParam(Object paramObject) {
		LOGGER.debug("CreateOperationHandler - processWithParam(Object paramObject) - START");


	}

	@Override
	public Object processWithResult() {
		LOGGER.debug("CreateOperationHandler - processWithResult - START\r\n");
		return null;
	}

}
