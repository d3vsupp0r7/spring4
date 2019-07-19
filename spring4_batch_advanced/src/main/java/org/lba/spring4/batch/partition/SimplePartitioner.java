package org.lba.spring4.batch.partition;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class SimplePartitioner implements Partitioner {

	static final Logger logger = Logger.getLogger(SimplePartitioner.class);

	private String injectedPropertiesOne;

	private Properties properties;

	@PostConstruct
	protected final void init() throws IOException {

		logger.debug("*** FilePartitioner - PostConstruct - START ***");
		
		logger.debug("** Initial properties for SimplePartitioner");
		Enumeration<String> enums = (Enumeration<String>) properties.propertyNames();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement();
			String value = properties.getProperty(key);
			logger.debug(key + " : " + value);
		}
		
		logger.debug("*** FilePartitioner - PostConstruct -   END ***");
	}

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {

		logger.debug("*** FilePartitioner - partition - START ***");

		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

		logger.debug("*** FilePartitioner - partition -   END ***");

		return result;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void setInjectedPropertiesOne(String injectedPropertiesOne) {
		this.injectedPropertiesOne = injectedPropertiesOne;
	}

}
