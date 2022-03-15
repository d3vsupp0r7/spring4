package org.lba.spring.gof.factorymethod;

/**
 * 
 *
 */
public interface CRUDOperationHandler {

	/**
	 * 
	 */
	public void process();
	
	/**
	 * 
	 * @param paramObject
	 */
	public void processWithParam(Object paramObject);
	
	/**
	 * 
	 * @return
	 */
	public Object processWithResult();
}
