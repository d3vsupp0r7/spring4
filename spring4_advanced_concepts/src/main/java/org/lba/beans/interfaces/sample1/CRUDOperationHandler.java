package org.lba.beans.interfaces.sample1;

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
