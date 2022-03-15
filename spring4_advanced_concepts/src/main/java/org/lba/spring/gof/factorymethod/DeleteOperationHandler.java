package org.lba.spring.gof.factorymethod;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("deleteOperationHandler")
public class DeleteOperationHandler implements CRUDOperationHandler {

	static final Logger LOGGER = Logger.getLogger(DeleteOperationHandler.class);
	
	@Override
	public void process() {
		LOGGER.debug("DeleteOperationHandler - process - START");

	}

	@Override
	public void processWithParam(Object paramObject) {
		LOGGER.debug("DeleteOperationHandler - processWithParam(Object paramObject) - START");


	}

	@Override
	public Object processWithResult() {
		LOGGER.debug("DeleteOperationHandler - processWithResult - START\r\n");
		return null;
	}

}
