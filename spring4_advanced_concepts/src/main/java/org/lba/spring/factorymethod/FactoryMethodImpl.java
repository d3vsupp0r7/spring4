package org.lba.spring.factorymethod;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FactoryMethodImpl implements IFactoryMethod {

	private static final String ERR_NO_FACTORY_IMPLEMENTATION_FOR_PRODUCT_SELECTOR = "No Factory implementation for productSelector: ";

	private static final String FACTORY_MSG_CREATE_PRODUCT_2 = "createProduct(String productSelector) - PRODUCT_2";

	private static final String FACTORY_MSG_CREATE_PRODUCT_1 = "createProduct(String productSelector) - PRODUCT_1";

	private static final String PRODUCT2 = "PRODUCT2";

	private static final String PRODUCT1 = "PRODUCT1";

	static final Logger LOGGER = Logger.getLogger(FactoryMethodImpl.class);

	/*Save products created with factory-method approach */
	@Autowired
	@Qualifier("product1SFM")
	private Product product1SpringBean;
	
	@Autowired
	@Qualifier("product2SFM")
	private Product product2SpringBean;

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

		case PRODUCT1:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_1);
			return new ConcreteProduct1();

		case PRODUCT2:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_2);
			return  new ConcreteProduct2();

		default:
			throw new UnsupportedOperationException(ERR_NO_FACTORY_IMPLEMENTATION_FOR_PRODUCT_SELECTOR + productSelector);
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

		case PRODUCT1:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_1);
			/**/
			product1SpringBean.setParam1(param1);
			product1SpringBean.setParam2(param2);
			/**/
			return product1SpringBean;

		case PRODUCT2:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_2);
			/**/
			product2SpringBean.setParam1(param1);
			/**/
			return product2SpringBean;

		default:
			throw new UnsupportedOperationException(ERR_NO_FACTORY_IMPLEMENTATION_FOR_PRODUCT_SELECTOR + productSelector);
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

		case PRODUCT1:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_1);
			/**/

			/**/
			return null;

		case PRODUCT2:
			LOGGER.debug(FACTORY_MSG_CREATE_PRODUCT_2);
			/**/
			/**/
			return null;

		default:
			throw new UnsupportedOperationException(ERR_NO_FACTORY_IMPLEMENTATION_FOR_PRODUCT_SELECTOR + productSelector);
		}
	}
}
