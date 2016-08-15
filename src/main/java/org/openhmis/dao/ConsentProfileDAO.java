package org.openhmis.dao;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.code.ConsentApprovalStatus;
import org.openhmis.code.ConsentField;
import org.openhmis.code.ConsentRequestType;
import org.openhmis.domain.ConsentProfile;


public class ConsentProfileDAO extends BaseDAO{
	public ConsentProfileDAO() { }

	public ConsentProfile getConsentProfileByClientKey(Integer clientId, Integer coCId, Integer organizationId)  {
		
		// Collect a summarized consent map for this client
		String queryString = "SELECT consentField.fieldCode, " +
			" 						 consentField.requestTypeCode, " + 
			" 						 consent.client.clientKey " +
			"                   FROM TmpConsent as consent " +
			"                   JOIN consent.consentFields as consentField " + 
			"              LEFT JOIN consent.consentCoCs as consentCoC " +
			"              LEFT JOIN consent.consentOrganizations as consentOrganization " + 
			"                  WHERE consent.client.clientKey = :clientId " +
			"                    AND consent.approvalStatusCode = :approvedStatusCode " + 
			"                    AND (consentCoC.coC.coCId = :coCId " +
			"                      OR consentOrganization.organization.organizationId = :organizationId) " + 
			"               ORDER BY consent.dateCreated DESC";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("clientId", clientId);
		queryObject.setParameter("approvedStatusCode", ConsentApprovalStatus.APPROVED.getCode());
		queryObject.setParameter("coCId", (coCId != null?coCId:0));
		queryObject.setParameter("organizationId", (organizationId != null?organizationId:0));
		
		List<Object[]> results = queryObject.list();
		session.close();

		// Go through the results and convert it to a profile
		ConsentProfile consentProfile = new ConsentProfile();
		
		Dictionary<Integer, Dictionary<ConsentField, Boolean>> consentMaps = new Hashtable<Integer, Dictionary<ConsentField, Boolean>>();
		
		for ( Object[] result : results ) {
			ConsentField consentField = ConsentField.valueByCode((Integer) result[0]); // Field Code 
			ConsentRequestType requestType = ConsentRequestType.valueByCode((Integer) result[1]); // Request Type Code
			Integer consentClientKey = (Integer) result[2]; // Client Key
			
			// Look up the client's map, or create it
			Dictionary<ConsentField, Boolean> consentMap = consentMaps.get(consentClientKey);
			if(consentMap == null)
				consentMap = new Hashtable<ConsentField, Boolean>();
			
			// Log this field for this client's map
			consentMap.put(consentField, requestType == ConsentRequestType.SHARE);
			
			// Store the client's map back
			consentMaps.put(consentClientKey, consentMap);			
		}
		
		consentProfile.setConsentMaps(consentMaps);
		return consentProfile;
	}
	
	// TODO: Make it possible to get a consent profile from a list of client Ids
	
	// TODO: Consider making it possible to get a complete consent profile (all clients) for a given CoC / org combo
	
}