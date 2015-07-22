package org.openhims.oauth2.dao.impl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.openhims.oauth2.dao.IVendorIdentityProviderDAO;
import org.openhims.oauth2.domain.VendorIdentityProvider;
import org.openhims.oauth2.domain.VendorIdentityProviderId;
import org.openhims.oauth2.util.EntityManagerHelper;

/**
 *@author Ashaar Riaz 
 */
public class VendorIdentityProviderDAO implements IVendorIdentityProviderDAO {
	// property constants
	public static final String SESSION_TIMEOUT = "sessionTimeout";
	public static final String VENDOR_WEBSITE = "vendorWebsite";
	public static final String VENDOR_REGISTERED = "vendorRegistered";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VendorIdentityProviderDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorIdentityProvider entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VendorIdentityProvider entity) {
		EntityManagerHelper.log("saving VendorIdentityProvider instance",
				Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VendorIdentityProviderDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VendorIdentityProvider entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VendorIdentityProvider entity) {
		EntityManagerHelper.log("deleting VendorIdentityProvider instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					VendorIdentityProvider.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = VendorIdentityProviderDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorIdentityProvider entity to update
	 * @return VendorIdentityProvider the persisted VendorIdentityProvider
	 *         entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VendorIdentityProvider update(VendorIdentityProvider entity) {
		EntityManagerHelper.log("updating VendorIdentityProvider instance",
				Level.INFO, null);
		try {
			VendorIdentityProvider result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public VendorIdentityProvider findById(VendorIdentityProviderId id) {
		EntityManagerHelper.log(
				"finding VendorIdentityProvider instance with id: " + id,
				Level.INFO, null);
		try {
			VendorIdentityProvider instance = getEntityManager().find(
					VendorIdentityProvider.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all VendorIdentityProvider entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VendorIdentityProvider property to query
	 * @param value
	 *            the property value to match
	 * @return List<VendorIdentityProvider> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<VendorIdentityProvider> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding VendorIdentityProvider instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from VendorIdentityProvider model where model."
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

	public List<VendorIdentityProvider> findBySessionTimeout(
			Object sessionTimeout) {
		return findByProperty(SESSION_TIMEOUT, sessionTimeout);
	}

	public List<VendorIdentityProvider> findByVendorWebsite(Object vendorWebsite) {
		return findByProperty(VENDOR_WEBSITE, vendorWebsite);
	}

	public List<VendorIdentityProvider> findByVendorRegistered(
			Object vendorRegistered) {
		return findByProperty(VENDOR_REGISTERED, vendorRegistered);
	}

	/**
	 * Find all VendorIdentityProvider entities.
	 * 
	 * @return List<VendorIdentityProvider> all VendorIdentityProvider entities
	 */
	@SuppressWarnings("unchecked")
	public List<VendorIdentityProvider> findAll() {
		EntityManagerHelper.log("finding all VendorIdentityProvider instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from VendorIdentityProvider model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}