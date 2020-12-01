package org.lba.spring4.integration.payload;

import java.io.Serializable;

public class CustomMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4672179028947001658L;
	private int maxMessages;
	private String channelName;
	
	public CustomMetadata() {
		// Implement if necessary
	}

	public int getMaxMessages() {
		return maxMessages;
	}

	public void setMaxMessages(int maxMessages) {
		this.maxMessages = maxMessages;
	}
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	@Override
	public String toString() {
		return "CustomMetadata [maxMessages=" + maxMessages + ", channelName=" + channelName + "]";
	}
	
}
