package org.lba.beans.interfaces.sample3.springfactorymethod.example;

import org.apache.log4j.Logger;


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
		LOGGER.debug("UpdateOperationHandler - processWithResult - START");
		return null;
	}

}
