package org.lba.dipendenceinjection.xml.contextualized.spring;

public class DefaultDependency implements Dependency {

	@Override
	public void execute() {
		System.out.println("DefaultDependency - instantiated by Lookup");
		
	}

}
