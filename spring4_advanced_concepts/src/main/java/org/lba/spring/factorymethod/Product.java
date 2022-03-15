package org.lba.spring.factorymethod;

import org.lba.beans.interfaces.multiimpl.example.Employee;

public interface Product {

	public void setParam1(String param1);
	
	public void setParam2(String param2);
	
	public void processOperationHandler(Employee employee);
}
