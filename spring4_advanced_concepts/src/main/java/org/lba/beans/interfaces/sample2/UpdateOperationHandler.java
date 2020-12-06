package org.lba.beans.interfaces.sample2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("updateOperationHandler")
public class UpdateOperationHandler implements CRUDOperationHandler {

	static final Logger LOGGER = Logger.getLogger(UpdateOperationHandler.class);
	
	@Override
	public void process() {
		LOGGER.debug("UpdateOperationHandler - process - START");

	}

	@Override
	public void processWithParam(Object paramObject) {
		LOGGER.debug("UpdateOperationHandler - processWithParam(Object paramObject) - START");


	}

	@Override
	public Object processWithResult() {
		LOGGER.debug("UpdateOperationHandler - processWithResult - START\r\n");
		return null;
	}

}
