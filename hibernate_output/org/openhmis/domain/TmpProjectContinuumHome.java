package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TmpProjectContinuum.
 * @see org.openhmis.domain.TmpProjectContinuum
 * @author Hibernate Tools
 */
@Stateless
public class TmpProjectContinuumHome {

	private static final Log log = LogFactory
			.getLog(TmpProjectContinuumHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TmpProjectContinuum transientInstance) {
		log.debug("persisting TmpProjectContinuum instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TmpProjectContinuum persistentInstance) {
		log.debug("removing TmpProjectContinuum instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TmpProjectContinuum merge(TmpProjectContinuum detachedInstance) {
		log.debug("merging TmpProjectContinuum instance");
		try {
			TmpProjectContinuum result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpProjectContinuum findById(Integer id) {
		log.debug("getting TmpProjectContinuum instance with id: " + id);
		try {
			TmpProjectContinuum instance = entityManager.find(
					TmpProjectContinuum.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
