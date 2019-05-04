package org.lba.factorybean;

public abstract class MyBean {

	private String param;

	protected MyBean(String aParam) {
		this.param = aParam;
	}

	public static MyBean getInstance(String aParam) {

		if(aParam.equals("a")) {
			return new MyBeanA(aParam);
		} else if (aParam.equals("b")) {
			return new MyBeanB(aParam);
		}else throw new IllegalArgumentException("Invalid param: " + aParam);

	}

	public String getParam() {
		return param;
	}



}
