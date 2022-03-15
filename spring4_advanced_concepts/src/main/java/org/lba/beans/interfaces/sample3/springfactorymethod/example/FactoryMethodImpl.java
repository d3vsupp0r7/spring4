package org.lba.beans.interfaces.sample3.springfactorymethod.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FactoryMethodImpl implements IFactoryMethod {

	static final Logger LOGGER = Logger.getLogger(FactoryMethodImpl.class);

	/*Save products created with factory-method approach to */
	@Autowired
	@Qualifier("product1SFM")
	private Product product1;
	
	@Autowired
	@Qualifier("product2SFM")
	private Product product2;

	/**
	 * Create products - factory method
	 * @param productSelector
	 * @return
	 */
	public Product createProduct(String productSelector) {

		LOGGER.debug("createProduct(String productSelector): " + productSelector);
		productSelector = productSelector.toUpperCase();
		/**/
		switch (productSelector) {

		case "PRODUCT1":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_1");
			return new ConcreteProduct1();

		case "PRODUCT2":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_2");
			return  new ConcreteProduct2();

		default:
			throw new UnsupportedOperationException("No Factory implementation for productSelector: " + productSelector);
		}
	}

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
			/**/
			return product2;

		default:
			throw new UnsupportedOperationException("No Factory implementation for productSelector: " + productSelector);
		}
	}

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

			/**/
			return null;

		case "PRODUCT2":
			LOGGER.debug("createProduct(String productSelector) - PRODUCT_2");
			/**/
			/**/
			return null;

		default:
			throw new UnsupportedOperationException("No Factory implementation for productSelector: " + productSelector);
		}
	}
}
