package org.lba.dipendenceinjection.xml.contextualized;

import org.springframework.beans.factory.annotation.Value;

public class Dependency {

	@Value("${dependency.constructor.name}")
	private static String dependencyName;
	
	public Dependency() {
		// Implement if necessary
	}
	
	public Dependency(String dependencyName) {
		super();
		this.dependencyName = dependencyName;
	}
 
	public String getDependencyName() {
		return dependencyName;
	}

	@Override
	public String toString() {
		return "Dependency [dependencyName=" + dependencyName + "]";
	}
	
}
