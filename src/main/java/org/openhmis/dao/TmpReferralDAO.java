package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpReferral;
import org.openhmis.dto.search.ReferralSearchDTO;
import org.openhmis.util.DateParser;

public class TmpReferralDAO extends BaseDAO {

	public TmpReferralDAO() {
	}

	public TmpReferral getTmpReferralById(Integer referralId)  {
		String queryString = "select referral " + 
			"from TmpReferral as referral " + 
			"where referral.referralId =:referralId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("referralId", referralId);
		queryObject.setMaxResults(1);
		
		List<TmpReferral> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpReferral)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpReferral> getTmpReferrals(ReferralSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpReferral.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpReferral> results = query.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpReferral> getTmpReferrals(Date updateDate) {
		String queryString = "select referral " + 
				"from TmpReferral as referral " + 
				"where referral.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpReferral> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpReferral> getTmpReferralsByEnrollmentId(Integer enrollmentId) {
		String queryString = "select referral " + 
				"from TmpReferral as referral " + 
				"where referral.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpReferral> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpReferral> getTmpReferralsByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select referral " + 
				"from TmpReferral as referral " + 
				"where referral.enrollmentId =:enrollmentId " + 
				"  and referral.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpReferral> results = queryObject.list();
		session.close();
		return results;
	}
}
