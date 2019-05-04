package org.lba.dipendenceinjection.xml.contextualized;

public class ContextualizedDependencyLookupMainApp {

	public static void main(String[] args) {

		Container container = new DefaultContainer();

		ManagedComponent managedComponent = new ContextualizedDependencyLookup();
		managedComponent.performLookup(container);

		System.out.println(managedComponent);
	}

}
