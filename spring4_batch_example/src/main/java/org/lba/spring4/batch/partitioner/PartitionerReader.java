package org.lba.spring4.batch.partitioner;

import java.util.List;

public interface PartitionerReader {

	  public List<String> getGroupedData() throws Exception;
}
