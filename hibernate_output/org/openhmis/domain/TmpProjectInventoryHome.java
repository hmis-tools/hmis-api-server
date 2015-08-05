package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:33 PM by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TmpProjectInventory.
 * @see org.openhmis.domain.TmpProjectInventory
 * @author Hibernate Tools
 */
@Stateless
public class TmpProjectInventoryHome {

	private static final Log log = LogFactory
			.getLog(TmpProjectInventoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TmpProjectInventory transientInstance) {
		log.debug("persisting TmpProjectInventory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TmpProjectInventory persistentInstance) {
		log.debug("removing TmpProjectInventory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TmpProjectInventory merge(TmpProjectInventory detachedInstance) {
		log.debug("merging TmpProjectInventory instance");
		try {
			TmpProjectInventory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TmpProjectInventory findById(Integer id) {
		log.debug("getting TmpProjectInventory instance with id: " + id);
		try {
			TmpProjectInventory instance = entityManager.find(
					TmpProjectInventory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
