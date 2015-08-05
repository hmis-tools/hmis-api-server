package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class PathClientVeteranInfo.
 * @see org.openhmis.domain.PathClientVeteranInfo
 * @author Hibernate Tools
 */
@Stateless
public class PathClientVeteranInfoHome {

	private static final Log log = LogFactory
			.getLog(PathClientVeteranInfoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PathClientVeteranInfo transientInstance) {
		log.debug("persisting PathClientVeteranInfo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PathClientVeteranInfo persistentInstance) {
		log.debug("removing PathClientVeteranInfo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PathClientVeteranInfo merge(PathClientVeteranInfo detachedInstance) {
		log.debug("merging PathClientVeteranInfo instance");
		try {
			PathClientVeteranInfo result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PathClientVeteranInfo findById(Integer id) {
		log.debug("getting PathClientVeteranInfo instance with id: " + id);
		try {
			PathClientVeteranInfo instance = entityManager.find(
					PathClientVeteranInfo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
