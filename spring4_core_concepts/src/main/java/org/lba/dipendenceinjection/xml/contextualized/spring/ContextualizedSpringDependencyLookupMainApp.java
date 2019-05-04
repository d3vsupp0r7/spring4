package org.lba.dipendenceinjection.xml.contextualized.spring;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class ContextualizedSpringDependencyLookupMainApp {

	public static void main(String[] args) {

		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
		reader.loadBeanDefinitions(new ClassPathResource("context.properties"));
		
		ManagedComponentServiceLookupImpl mscl = new ManagedComponentServiceLookupImpl();
		registerComponent(mscl);
		allowComponentsToLookup(bf);
		mscl.businessMethod();
	}

	private static Set<ManagedComponentServiceLookup> components = new HashSet<ManagedComponentServiceLookup>();

	  private static void allowComponentsToLookup(BeanFactory bf) {
	    for (ManagedComponentServiceLookup component : components) {
	      component.performLookup(bf);
	    }
	  }

	  private static void registerComponent(ManagedComponentServiceLookup managedComponent) {
	    components.add(managedComponent);
	  }
}
