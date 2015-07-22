package org.openhims.oauth2.dao.impl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.openhims.oauth2.dao.IUsersHistoryDAO;
import org.openhims.oauth2.domain.UsersHistory;
import org.openhims.oauth2.util.EntityManagerHelper;

/**
 * 
 * @author Ashaar Riaz
 */
public class UsersHistoryDAO implements IUsersHistoryDAO {
	// property constants
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String FAX = "fax";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * UsersHistoryDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHistory entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(UsersHistory entity) {
		EntityManagerHelper.log("saving UsersHistory instance", Level.INFO,
				null);
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
	 * UsersHistoryDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHistory entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(UsersHistory entity) {
		EntityManagerHelper.log("deleting UsersHistory instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(UsersHistory.class,
					entity.getUsersHistoryId());
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
	 * entity = UsersHistoryDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHistory entity to update
	 * @return UsersHistory the persisted UsersHistory entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public UsersHistory update(UsersHistory entity) {
		EntityManagerHelper.log("updating UsersHistory instance", Level.INFO,
				null);
		try {
			UsersHistory result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public UsersHistory findById(Integer id) {
		EntityManagerHelper.log("finding UsersHistory instance with id: " + id,
				Level.INFO, null);
		try {
			UsersHistory instance = getEntityManager().find(UsersHistory.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all UsersHistory entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the UsersHistory property to query
	 * @param value
	 *            the property value to match
	 * @return List<UsersHistory> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<UsersHistory> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding UsersHistory instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from UsersHistory model where model."
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

	public List<UsersHistory> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<UsersHistory> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<UsersHistory> findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	/**
	 * Find all UsersHistory entities.
	 * 
	 * @return List<UsersHistory> all UsersHistory entities
	 */
	@SuppressWarnings("unchecked")
	public List<UsersHistory> findAll() {
		EntityManagerHelper.log("finding all UsersHistory instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from UsersHistory model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}