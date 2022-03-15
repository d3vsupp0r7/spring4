package org.lba.beans.interfaces.multiimpl.example;

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
