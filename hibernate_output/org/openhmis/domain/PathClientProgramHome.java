package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class PathClientProgram.
 * @see org.openhmis.domain.PathClientProgram
 * @author Hibernate Tools
 */
@Stateless
public class PathClientProgramHome {

	private static final Log log = LogFactory
			.getLog(PathClientProgramHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PathClientProgram transientInstance) {
		log.debug("persisting PathClientProgram instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PathClientProgram persistentInstance) {
		log.debug("removing PathClientProgram instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PathClientProgram merge(PathClientProgram detachedInstance) {
		log.debug("merging PathClientProgram instance");
		try {
			PathClientProgram result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PathClientProgram findById(Integer id) {
		log.debug("getting PathClientProgram instance with id: " + id);
		try {
			PathClientProgram instance = entityManager.find(
					PathClientProgram.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
