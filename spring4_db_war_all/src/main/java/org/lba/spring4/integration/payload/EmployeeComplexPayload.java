package org.lba.spring4.integration.payload;

import java.io.Serializable;

public class EmployeeComplexPayload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8072447686539056862L;
	private CustomMetadata customMetadata;
	private EmployeeIntegrationPayload patientIntegrationPayload;
	
	public EmployeeComplexPayload() {
		// Implement if necessary
	}

	public CustomMetadata getCustomMetadata() {
		return customMetadata;
	}

	public void setCustomMetadata(CustomMetadata customMetadata) {
		this.customMetadata = customMetadata;
	}

	public EmployeeIntegrationPayload getPatientIntegrationPayload() {
		return patientIntegrationPayload;
	}

	public void setPatientIntegrationPayload(EmployeeIntegrationPayload patientIntegrationPayload) {
		this.patientIntegrationPayload = patientIntegrationPayload;
	}

	@Override
	public String toString() {
		return "PatientComplexPayload [customMetadata=" + customMetadata + ", patientIntegrationPayload="
				+ patientIntegrationPayload + "]";
	}
	
	
	
}
