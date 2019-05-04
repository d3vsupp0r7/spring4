package org.lba.dipendenceinjection.xml.setter;

import org.lba.dipendenceinjection.xml.contextualized.Dependency;

public class SetterInjection {

	private Dependency dependency;
	
	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
	@Override
	public String toString() {
		return dependency.toString();
	}

}
