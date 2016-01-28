package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ProjectCompletionStatus (2014, 4.37.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientProjectCompletionStatus implements BaseCode {
	COMPLETED (1, "Completed project"),
	LEFT (2, "Youth voluntarily left early"),
	EXPELLED (3, "Youth was expelled or otherwise involuntarily discharged from project"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientProjectCompletionStatus(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	// Enable lookups by code
	private static final CodeLookup<ClientProjectCompletionStatus> enhancer = new CodeLookup<ClientProjectCompletionStatus>(values());	

	@JsonCreator
	public static ClientProjectCompletionStatus valueByCode(Integer code) {
		ClientProjectCompletionStatus value = enhancer.valueByCode(code); 
		return (value == null)?ClientProjectCompletionStatus.NOT_COLLECTED:value;
	}
}