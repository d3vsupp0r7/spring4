package org.lba.beans.interfaces.sample3.springfactorymethod.s1;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("product1")
public class ConcreteProduct1 implements Product {

	static final Logger LOGGER = Logger.getLogger(ConcreteProduct1.class);
	
	private String param1;
	private String param2;
	/**/
	private Employee employee;
	/**/
	@Autowired
	@Qualifier("createOperationHandler")
	private CRUDOperationHandler createOperatioHandler;
	
	@Autowired
	@Qualifier("readOperationHandler")
	private CRUDOperationHandler readOperatioHandler;
	
	@Autowired
	@Qualifier("updateOperationHandler")
	private CRUDOperationHandler updateOperatioHandler;
	
	@Autowired
	@Qualifier("deleteOperationHandler")
	private CRUDOperationHandler deleteOperatioHandler;
	
	public ConcreteProduct1() {
		// Implement if necessary
	}
	
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

	@Override
	public void setParam2(String param2) {

		this.param2 = param2;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ConcreteProduct1 [param1=" + param1 + ", param2=" + param2 + ", employee=" + employee + "]";
	}

	
	@Override
	/**
	 * 
	 */
	public void processOperationHandler() {
		LOGGER.debug("ConcreteProduct1 - processOperationHandler()  - [CALLED]");
		
	}

	@Override
	/**
	 * 
	 */
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
			createOperatioHandler.processWithParam(employee);
			/**/
			break;
			
		case "READ":
			LOGGER.debug("processOperationHandler - PRODUCT1 - READ");
			/**/
			readOperatioHandler.processWithParam(employee);
			/**/
			break;
			
		case "UPDATE":
			LOGGER.debug("processOperationHandler - PRODUCT1 - UPDATE");
			/**/
			updateOperatioHandler.processWithParam(employee);
			/**/
			break;
			
		case "DELETE":
			LOGGER.debug("processOperationHandler - PRODUCT_1 - DELETE");
			/**/
			deleteOperatioHandler.processWithParam(employee);
			/**/
			break;

		default:
			throw new UnsupportedOperationException("No Handler implementation for operation: " + operationSelector);
		}
	}
	
	
}
