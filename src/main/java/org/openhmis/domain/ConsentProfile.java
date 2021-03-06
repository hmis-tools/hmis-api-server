package org.openhmis.domain;

import org.openhmis.code.ConsentField;
import org.openhmis.util.Authentication;

import java.util.Dictionary;

// This is a summary of consent rules associated with various clients
// It stores a dictionary of consent maps associated with various clients

public class ConsentProfile {

	Dictionary<Integer, Dictionary<ConsentField, Boolean>> consentMaps;

	public ConsentProfile() {
	}
	
	public void addConsentMap(Integer clientId, Dictionary<ConsentField, Boolean> clientConsentMap) {
		consentMaps.put(clientId, clientConsentMap);
	}
	
	public void setConsentMaps(Dictionary<Integer, Dictionary<ConsentField, Boolean>> consentMaps) {
		this.consentMaps = consentMaps;
	}
	public Dictionary<Integer, Dictionary<ConsentField, Boolean>> getConsentMaps() {
		return this.consentMaps;
	}
	
	public boolean hasFieldConsent(Integer clientId, ConsentField field) {
		// If authentication is disabled, everyone has consent for everything
		if(Authentication.getAuthEnabled() == false)
			return true;
		
		Dictionary<ConsentField, Boolean> consentMap = consentMaps.get(clientId);
		if(consentMap == null)
			return false;
		
		Boolean consentValue = consentMap.get(field);
		
		if(consentValue == null)
			return false;
		
		return consentValue.booleanValue();
	}

}
