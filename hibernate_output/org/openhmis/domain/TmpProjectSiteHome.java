package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TmpProjectSite.
 * @see org.openhmis.domain.TmpProjectSite
 * @author Hibernate Tools
 */
@Stateless
public class TmpProjectSiteHome {

	private static final Log log = LogFactory.getLog(TmpProjectSiteHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TmpProjectSite transientInstance) {
		log.debug("persisting TmpProjectSite instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TmpProjectSite persistentInstance) {
		log.debug("removing TmpProjectSite instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TmpProjectSite merge(TmpProjectSite detachedInstance) {
		log.debug("merging TmpProjectSite instance");
		try {
			TmpProjectSite result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpProjectSite findById(Integer id) {
		log.debug("getting TmpProjectSite instance with id: " + id);
		try {
			TmpProjectSite instance = entityManager.find(TmpProjectSite.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
