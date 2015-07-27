package org.openhmis.code;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Military Branch (2014, 4.41.11)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientMilitaryBranch implements BaseCode {
	ARMY (1, "Army"),
	AIR_FORCE (2, "Air Force"),
	NAVY (3, "Navy"),
	MARINES (4, "Marines"),
	COAST_GUARD (6, "Coast Guard"),
	UNKNOWN (8, "Client doesn’t know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientMilitaryBranch(final Integer code, final String description) {
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
	private static final CodeLookup<ClientMilitaryBranch> enhancer = new CodeLookup<ClientMilitaryBranch>(values());	
	public static ClientMilitaryBranch valueByCode(Integer code) {
		return enhancer.valueByCode(code);
	}
}