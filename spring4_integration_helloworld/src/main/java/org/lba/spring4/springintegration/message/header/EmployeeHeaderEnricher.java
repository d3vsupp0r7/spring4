package org.lba.spring4.springintegration.message.header;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class EmployeeHeaderEnricher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4886700249075725720L;
	
	private int msgId;
	private String headerVersion;
	
	public EmployeeHeaderEnricher() {
		// Implement if necessary
	}

	public EmployeeHeaderEnricher(int msgId, String headerVersion) {
		super();
		this.msgId = msgId;
		this.headerVersion = headerVersion;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getHeaderVersion() {
		return headerVersion;
	}

	public void setHeaderVersion(String headerVersion) {
		this.headerVersion = headerVersion;
	}
	
	public String appendTime() throws InterruptedException {
        return String.valueOf(System.currentTimeMillis());
    }

}
