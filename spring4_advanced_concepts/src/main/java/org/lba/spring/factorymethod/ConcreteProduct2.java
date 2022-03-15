package org.lba.spring.factorymethod;

import org.apache.log4j.Logger;
import org.lba.beans.interfaces.multiimpl.example.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ConcreteProduct2 implements Product{

	private String param1;
	private String param2;
	
	static final Logger LOGGER = Logger.getLogger(ConcreteProduct2.class);
	
	/**/
	@Autowired
	@Qualifier("sfCreateOperationHandler")
	private CRUDOperationHandler createOperationHandler;
	
	@Autowired
	@Qualifier("readOperationHandler")
	private CRUDOperationHandler readOperationHandler;
	
	@Autowired
	@Qualifier("updateOperationHandler")
	private CRUDOperationHandler updateOperationHandler;
	
	@Autowired
	@Qualifier("deleteOperationHandler")
	private CRUDOperationHandler deleteOperationHandler;
	/**/
	
	public String getParam1() {
		return param1;
	}

	@Override
	public void setParam1(String param1) {
		
		this.param1= param1;
		
	}
	
	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public void processOperationHandler(Employee employee) {
		LOGGER.debug("ConcreteProduct1 - processOperationHandler(Employee employee)  - [CALLED]");
		
		/**/
		String operationSelector = getParam1();
		/**/
		if(operationSelector==null) {
			LOGGER.error("[INVALID REQUEST - OPERATION HANDLER IS NULL]");
			return;
		}
		/**/
		operationSelector = operationSelector.toUpperCase();
		/**/
		switch (operationSelector) {
		
		case "CREATE":
			LOGGER.debug("processOperationHandler - PRODUCT1 - CREATE");
			/**/
			createOperationHandler.processWithParam(employee);
			/**/
			break;
			
		case "READ":
			LOGGER.debug("processOperationHandler - PRODUCT1 - READ");
			/**/
			readOperationHandler.processWithParam(employee);
			/**/
			break;
			
		case "UPDATE":
			LOGGER.debug("processOperationHandler - PRODUCT1 - UPDATE");
			/**/
			updateOperationHandler.processWithParam(employee);
			/**/
			break;
			
		case "DELETE":
			LOGGER.debug("processOperationHandler - PRODUCT_1 - DELETE");
			/**/
			deleteOperationHandler.processWithParam(employee);
			/**/
			break;

		default:
			throw new UnsupportedOperationException("No Handler implementation for operation: " + operationSelector);
		}
	}
}
