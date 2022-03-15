package org.lba.spring.factorymethod;


public interface IFactoryMethod {

	public Product createProduct(String productSelector);
	
	public Product createProductWithParams(String productSelector, String param1, String param2);
	
	public Product createProductWithObject(String productSelector, Object paramObject);
}
