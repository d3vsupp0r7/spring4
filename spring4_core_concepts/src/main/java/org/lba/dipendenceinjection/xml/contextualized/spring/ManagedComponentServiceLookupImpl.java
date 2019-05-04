package org.lba.dipendenceinjection.xml.contextualized.spring;

import org.springframework.beans.factory.BeanFactory;

/**
 * Lookup 
 *
 */
public class ManagedComponentServiceLookupImpl implements ManagedComponentServiceLookup{

	private Dependency dependency;
	
	@Override
	public void performLookup(BeanFactory aFactoryContainer) {

		this.dependency = (Dependency)aFactoryContainer.getBean("service");
	}
	
	public void businessMethod() {
		this.dependency.execute();
	}

}
