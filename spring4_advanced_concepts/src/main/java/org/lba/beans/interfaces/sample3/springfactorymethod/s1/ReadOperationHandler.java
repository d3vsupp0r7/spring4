package org.lba.beans.interfaces.sample3.springfactorymethod.s1;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("readOperationHandler")
public class ReadOperationHandler implements CRUDOperationHandler {

	static final Logger LOGGER = Logger.getLogger(ReadOperationHandler.class);
	
	@Override
	public void process() {
		LOGGER.debug("ReadOperationHandler - process - START");

	}

	@Override
	public void processWithParam(Object paramObject) {
		LOGGER.debug("ReadOperationHandler - processWithParam(Object paramObject) - START");


	}

	@Override
	public Object processWithResult() {
		LOGGER.debug("ReadOperationHandler - processWithResult - START\r\n");
		return null;
	}

}
