package org.lba.spring4.integration.payload;

import java.io.Serializable;

public class EmployeeComplexPayload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8072447686539056862L;
	private CustomMetadata customMetadata;
	private EmployeeIntegrationPayload employeeIntegrationPayload;
	
	public EmployeeComplexPayload() {
		// Implement if necessary
	}

	public CustomMetadata getCustomMetadata() {
		return customMetadata;
	}

	public void setCustomMetadata(CustomMetadata customMetadata) {
		this.customMetadata = customMetadata;
	}

	public EmployeeIntegrationPayload getEmployeeIntegrationPayload() {
		return employeeIntegrationPayload;
	}

	public void setEmployeeIntegrationPayload(EmployeeIntegrationPayload employeeIntegrationPayload) {
		this.employeeIntegrationPayload = employeeIntegrationPayload;
	}

	@Override
	public String toString() {
		return "EmployeeComplexPayload [customMetadata=" + customMetadata + ", employeeIntegrationPayload="
				+ employeeIntegrationPayload + "]";
	}
	
}
