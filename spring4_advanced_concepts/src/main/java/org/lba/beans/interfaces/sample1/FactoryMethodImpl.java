package org.lba.beans.interfaces.sample1;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FactoryMethodImpl implements IFactoryMethod {

	static final Logger LOGGER = Logger.getLogger(FactoryMethodImpl.class);
	
	@Autowired
	@Qualifier("product1")
	private Product product1;
	
	@Autowired
	@Qualifier("product2")
	private Product product2;
	
	public FactoryMethodImpl() {
		// Implement if necessary
	}
	
	@Override
	public Product createProduct(String productSelector) {
		
		LOGGER.debug("createProduct(String productSelector): " + productSelector);
		productSelector = productSelector.toUpperCase();
		/**/
		switch (productSelector) {
		
		case "PRODUCT1":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_1");
			return product1;
			
		case "PRODUCT2":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_2");
			return product2;

		default:
			throw new UnsupportedOperationException("No Factory implementation for productSelector: " + productSelector);
		}
	}

	@Override
	public Product createProductWithParams(String productSelector, String param1, String param2) {
		
		LOGGER.debug("createProductWithParams(String productSelector, String params1, String params2)");
		LOGGER.debug("productSelector: " + productSelector);
		LOGGER.debug("params1: " + param1);
		LOGGER.debug("params2: " + param2);
		/**/
		productSelector = productSelector.toUpperCase();
		/**/
		switch (productSelector) {
		
		case "PRODUCT1":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_1");
			/**/
			product1.setParam1(param1);
			product1.setParam2(param2);
			/**/
			return product1;
			
		case "PRODUCT2":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_2");
			/**/
			product2.setParam1(param1);
			product2.setParam2(param2);
			/**/
			return product2;

		default:
			throw new UnsupportedOperationException("No Factory implementation for productSelector: " + productSelector);
		}
	}

	@Override
	public Product createProductWithObject(String productSelector, Object paramObject) {
		
		LOGGER.debug("createProductWithObject(String productSelector, Object paramObject)");
		LOGGER.debug("productSelector: " + productSelector);
		LOGGER.debug("paramObject: " + paramObject.toString());
		/**/
		productSelector = productSelector.toUpperCase();
		/**/
		switch (productSelector) {
		
		case "PRODUCT1":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_1");
			/**/
			product1.setEmployee((Employee)paramObject);
			/**/
			return product1;
			
		case "PRODUCT2":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_2");
			/**/
			product2.setEmployee((Employee)paramObject);
			/**/
			return product2;

		default:
			throw new UnsupportedOperationException("No Factory implementation for productSelector: " + productSelector);
		}
	}

}
