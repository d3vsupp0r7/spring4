package org.lba.spring4.business.example;

public interface IBusiness {

	/**
	 * Business method 1.
	 */
	public void businessMethod1();
	
	public void businessMethod1(IClassTwo param1);
	
	/**
	 * Business method 2.
	 *
	 * @param param1 the param 1
	 */
	public void businessMethod2(IClassOne param1);
	
	/**
	 * Business method 2.
	 *
	 * @param param1 the param 1
	 * @param param2 the param 2
	 */
	public void businessMethod2(IClassTwo param1, IClassThree param2);
	
	/**
	 * Business method 3.
	 *
	 * @param param1 the param 1
	 */
	public void businessMethod3(IClassThree param1);
}
