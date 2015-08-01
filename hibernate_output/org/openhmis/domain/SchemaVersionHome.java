package org.openhmis.domain;

// Generated Jul 29, 2015 7:36:07 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class SchemaVersion.
 * @see org.openhmis.domain.SchemaVersion
 * @author Hibernate Tools
 */
@Stateless
public class SchemaVersionHome {

	private static final Log log = LogFactory.getLog(SchemaVersionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SchemaVersion transientInstance) {
		log.debug("persisting SchemaVersion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SchemaVersion persistentInstance) {
		log.debug("removing SchemaVersion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SchemaVersion merge(SchemaVersion detachedInstance) {
		log.debug("merging SchemaVersion instance");
		try {
			SchemaVersion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SchemaVersion findById(String id) {
		log.debug("getting SchemaVersion instance with id: " + id);
		try {
			SchemaVersion instance = entityManager
					.find(SchemaVersion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
