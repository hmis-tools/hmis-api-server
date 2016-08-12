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
		String queryString = "SELECT consentField.fieldCode as fieldCode, " +
			" 						 consentField.requestTypeCode as requesTypeCode, " + 
			" 						 consent.clientId as clientId, " +
			"                   FROM TmpConsentField as consentField " +
			"                   JOIN TmpConsent as consent ON consentField.consentId = consent.consentId " + 
			"              LEFT JOIN TmpConsentCoC as consentCoC ON consentCoC.consentId = consent.consentId " +
			"              LEFT JOIN TmpConsentOrganization as consentOrganization ON consentOrganization.consentId = consent.consentId " + 
			"                  WHERE consent.clientId =:clientId " +
			"                    AND consent.approvalStatusCode =:approvedStatusCode " + 
			"                    AND (consentCoC.coCId == :coCId " +
			"                      OR consentOrganization.organizationId == :organizationId) " + 
			"               GROUP BY fieldCode, clientId " + 
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
			Integer consentClientId = (Integer) result[2]; // Client Id
			
			// Look up the client's map, or create it
			Dictionary<ConsentField, Boolean> consentMap = consentMaps.get(consentClientId);
			if(consentMap == null)
				consentMap = new Hashtable<ConsentField, Boolean>();
			
			// Log this field for this client's map
			consentMap.put(consentField, requestType == ConsentRequestType.SHARE);
			
			// Store the client's map back
			consentMaps.put(consentClientId, consentMap);			
		}
		
		consentProfile.setConsentMaps(consentMaps);
		return consentProfile;
	}
	
	// TODO: Make it possible to get a consent profile from a list of client Ids
	
	// TODO: Consider making it possible to get a complete consent profile (all clients) for a given CoC / org combo
	
}