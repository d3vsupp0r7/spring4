package org.lba.beans.interfaces.sample3.springfactorymethod.example;

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
