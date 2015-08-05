package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class PathClient.
 * @see org.openhmis.domain.PathClient
 * @author Hibernate Tools
 */
@Stateless
public class PathClientHome {

	private static final Log log = LogFactory.getLog(PathClientHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PathClient transientInstance) {
		log.debug("persisting PathClient instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PathClient persistentInstance) {
		log.debug("removing PathClient instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PathClient merge(PathClient detachedInstance) {
		log.debug("merging PathClient instance");
		try {
			PathClient result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PathClient findById(Integer id) {
		log.debug("getting PathClient instance with id: " + id);
		try {
			PathClient instance = entityManager.find(PathClient.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
