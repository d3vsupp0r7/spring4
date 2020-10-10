package org.lba.spring4.integration.payload;

import java.io.Serializable;

public class CustomMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4672179028947001658L;
	private int maxMessages;
	
	public CustomMetadata() {
		// Implement if necessary
	}

	public int getMaxMessages() {
		return maxMessages;
	}

	public void setMaxMessages(int maxMessages) {
		this.maxMessages = maxMessages;
	}

	@Override
	public String toString() {
		return "CustomMetadata [maxMessages=" + maxMessages + "]";
	}
	
	
}
