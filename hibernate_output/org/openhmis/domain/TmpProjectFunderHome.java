package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TmpProjectFunder.
 * @see org.openhmis.domain.TmpProjectFunder
 * @author Hibernate Tools
 */
@Stateless
public class TmpProjectFunderHome {

	private static final Log log = LogFactory
			.getLog(TmpProjectFunderHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TmpProjectFunder transientInstance) {
		log.debug("persisting TmpProjectFunder instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TmpProjectFunder persistentInstance) {
		log.debug("removing TmpProjectFunder instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TmpProjectFunder merge(TmpProjectFunder detachedInstance) {
		log.debug("merging TmpProjectFunder instance");
		try {
			TmpProjectFunder result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpProjectFunder findById(Integer id) {
		log.debug("getting TmpProjectFunder instance with id: " + id);
		try {
			TmpProjectFunder instance = entityManager.find(
					TmpProjectFunder.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
