package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TmpProject.
 * @see org.openhmis.domain.TmpProject
 * @author Hibernate Tools
 */
@Stateless
public class TmpProjectHome {

	private static final Log log = LogFactory.getLog(TmpProjectHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TmpProject transientInstance) {
		log.debug("persisting TmpProject instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TmpProject persistentInstance) {
		log.debug("removing TmpProject instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TmpProject merge(TmpProject detachedInstance) {
		log.debug("merging TmpProject instance");
		try {
			TmpProject result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpProject findById(Integer id) {
		log.debug("getting TmpProject instance with id: " + id);
		try {
			TmpProject instance = entityManager.find(TmpProject.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
