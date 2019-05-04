package org.lba.dipendenceinjection.xml.constructor;

import org.lba.dipendenceinjection.xml.contextualized.Dependency;

public class ConstructorInjection {

	private Dependency dependency;
	
	public ConstructorInjection(Dependency dependency) {
		this.dependency = dependency;
	}

	@Override
	public String toString() {
		return dependency.toString();
	}
}
