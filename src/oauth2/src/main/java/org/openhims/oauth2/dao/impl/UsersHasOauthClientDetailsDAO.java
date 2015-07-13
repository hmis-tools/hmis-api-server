package org.openhims.oauth2.dao.impl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.openhims.oauth2.dao.IUsersHasOauthClientDetailsDAO;
import org.openhims.oauth2.domain.UsersHasOauthClientDetails;
import org.openhims.oauth2.domain.UsersHasOauthClientDetailsId;
import org.openhims.oauth2.util.EntityManagerHelper;

/**
 * 
 * @author Ashaar Riaz
 */
public class UsersHasOauthClientDetailsDAO implements
		IUsersHasOauthClientDetailsDAO {
	// property constants
	public static final String SCOPE = "scope";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * UsersHasOauthClientDetailsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHasOauthClientDetails entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(UsersHasOauthClientDetails entity) {
		EntityManagerHelper.log("saving UsersHasOauthClientDetails instance",
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
	 * UsersHasOauthClientDetailsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHasOauthClientDetails entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(UsersHasOauthClientDetails entity) {
		EntityManagerHelper.log("deleting UsersHasOauthClientDetails instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					UsersHasOauthClientDetails.class, entity.getId());
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
	 * entity = UsersHasOauthClientDetailsDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHasOauthClientDetails entity to update
	 * @return UsersHasOauthClientDetails the persisted
	 *         UsersHasOauthClientDetails entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public UsersHasOauthClientDetails update(UsersHasOauthClientDetails entity) {
		EntityManagerHelper.log("updating UsersHasOauthClientDetails instance",
				Level.INFO, null);
		try {
			UsersHasOauthClientDetails result = getEntityManager()
					.merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public UsersHasOauthClientDetails findById(UsersHasOauthClientDetailsId id) {
		EntityManagerHelper.log(
				"finding UsersHasOauthClientDetails instance with id: " + id,
				Level.INFO, null);
		try {
			UsersHasOauthClientDetails instance = getEntityManager().find(
					UsersHasOauthClientDetails.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all UsersHasOauthClientDetails entities with a specific property
	 * value.
	 * 
	 * @param propertyName
	 *            the name of the UsersHasOauthClientDetails property to query
	 * @param value
	 *            the property value to match
	 * @return List<UsersHasOauthClientDetails> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<UsersHasOauthClientDetails> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding UsersHasOauthClientDetails instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from UsersHasOauthClientDetails model where model."
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

	public List<UsersHasOauthClientDetails> findByScope(Object scope) {
		return findByProperty(SCOPE, scope);
	}

	public List<UsersHasOauthClientDetails> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * Find all UsersHasOauthClientDetails entities.
	 * 
	 * @return List<UsersHasOauthClientDetails> all UsersHasOauthClientDetails
	 *         entities
	 */
	@SuppressWarnings("unchecked")
	public List<UsersHasOauthClientDetails> findAll() {
		EntityManagerHelper.log(
				"finding all UsersHasOauthClientDetails instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from UsersHasOauthClientDetails model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}