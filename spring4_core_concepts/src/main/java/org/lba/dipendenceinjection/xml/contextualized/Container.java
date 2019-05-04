package org.lba.dipendenceinjection.xml.contextualized;

public interface Container {
	Object getDependency(String key);
}