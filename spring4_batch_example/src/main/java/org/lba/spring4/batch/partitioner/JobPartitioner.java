package org.lba.spring4.batch.partitioner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class JobPartitioner implements Partitioner {

	static final  Logger LOGGER = Logger.getLogger(JobPartitioner.class);
	
	private PartitionerReader partitionReader;
	
	public static final String PROPERTY_NAME = "propertyName_";

	public static final String NAME_CHUNK = "nameChunk";
	
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		LOGGER.debug("*** PARTITIONER - START ***");
		/*1*/
		Map<String, ExecutionContext> result = new HashMap<>();
		/*2*/
		List<String> fieldPartitionDataLists = null;
		/*3*/
		try {
			fieldPartitionDataLists = partitionReader.getGroupedData();
		} catch (Exception e) {
			LOGGER.error("Error: ", e);
		}
		/**/
		fillChunks(result, fieldPartitionDataLists);
		/**/
		LOGGER.debug("*** PARTITIONER -   END ***");
		/**/
		return result;
	}

	/**
	 * 
	 * @param result
	 * @param partitionedList
	 */
	private void fillChunks(Map<String, ExecutionContext> result, List<String> partitionedList) {

		LOGGER.debug("*** PARTITIONER - fillChunks - START ***");
		
		if (partitionedList == null) {
			return;
		}

		for (String storeMsgType : partitionedList) {
			
			ExecutionContext executionContext = new ExecutionContext();
			result.put(PROPERTY_NAME + storeMsgType, executionContext);
			executionContext.put(NAME_CHUNK, storeMsgType);
		}

		LOGGER.debug("*Number of partitions: " + partitionedList.size());
		LOGGER.debug("*** PARTITIONER - fillChunks -   END ***");
	}
	
	/*****************/
	public PartitionerReader getPartitionReader() {
		return partitionReader;
	}

	public void setPartitionReader(PartitionerReader partitionReader) {
		this.partitionReader = partitionReader;
	}
	
}
