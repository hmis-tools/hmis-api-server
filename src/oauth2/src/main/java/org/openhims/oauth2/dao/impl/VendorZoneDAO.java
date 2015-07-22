package org.openhims.oauth2.domain;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * VendorZone entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see org.openhims.oauth2.domain.VendorZone
 * @author MyEclipse Persistence Tools
 */
public class VendorZoneDAO implements IVendorZoneDAO {
	// property constants
	public static final String VENDOR_NAME = "vendorName";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved VendorZone entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VendorZoneDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorZone entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VendorZone entity) {
		EntityManagerHelper.log("saving VendorZone instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent VendorZone entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VendorZoneDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VendorZone entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VendorZone entity) {
		EntityManagerHelper.log("deleting VendorZone instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(VendorZone.class,
					entity.getVendorZoneId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved VendorZone entity and return it or a copy of
	 * it to the sender. A copy of the VendorZone entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VendorZoneDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorZone entity to update
	 * @return VendorZone the persisted VendorZone entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VendorZone update(VendorZone entity) {
		EntityManagerHelper.log("updating VendorZone instance", Level.INFO,
				null);
		try {
			VendorZone result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VendorZone findById(Integer id) {
		EntityManagerHelper.log("finding VendorZone instance with id: " + id,
				Level.INFO, null);
		try {
			VendorZone instance = getEntityManager().find(VendorZone.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VendorZone entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VendorZone property to query
	 * @param value
	 *            the property value to match
	 * @return List<VendorZone> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VendorZone> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding VendorZone instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VendorZone model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<VendorZone> findByVendorName(Object vendorName) {
		return findByProperty(VENDOR_NAME, vendorName);
	}

	/**
	 * Find all VendorZone entities.
	 * 
	 * @return List<VendorZone> all VendorZone entities
	 */
	@SuppressWarnings("unchecked")
	public List<VendorZone> findAll() {
		EntityManagerHelper.log("finding all VendorZone instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from VendorZone model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}