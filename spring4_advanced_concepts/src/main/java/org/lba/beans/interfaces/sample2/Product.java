package org.lba.beans.interfaces.sample2;

/**
 * Product interface
 *
 */
public interface Product {

	/**
	 * 
	 * @param param1
	 */
	public void setParam1(String param1);
	
	/**
	 * 
	 * @param param2
	 */
	public void setParam2(String param2);
	
	/**
	 * 
	 * @param employee
	 */
	public void setEmployee(Employee employee);
	
	/*Operation Handler*/
	/**
	 * 
	 */
	public void processOperationHandler();
	
	/**
	 * 
	 * @param employee
	 */
	public void processOperationHandler(Employee employee);
}
