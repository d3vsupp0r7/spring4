package org.lba.dipendenceinjection.xml.contextualized.spring;

import org.springframework.beans.factory.BeanFactory;

public interface ManagedComponentServiceLookup {
	void performLookup(BeanFactory aFactoryContainer);
}
