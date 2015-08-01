package org.openhmis.domain;

// Generated Jul 29, 2015 7:36:07 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class PathClientRace.
 * @see org.openhmis.domain.PathClientRace
 * @author Hibernate Tools
 */
@Stateless
public class PathClientRaceHome {

	private static final Log log = LogFactory.getLog(PathClientRaceHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PathClientRace transientInstance) {
		log.debug("persisting PathClientRace instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PathClientRace persistentInstance) {
		log.debug("removing PathClientRace instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PathClientRace merge(PathClientRace detachedInstance) {
		log.debug("merging PathClientRace instance");
		try {
			PathClientRace result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PathClientRace findById(Integer id) {
		log.debug("getting PathClientRace instance with id: " + id);
		try {
			PathClientRace instance = entityManager.find(PathClientRace.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
