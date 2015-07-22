package org.openhims.oauth2.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Authorities entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see org.openhims.oauth2.domain.Authorities
 * @author MyEclipse Persistence Tools
 */
public class AuthoritiesDAO implements IAuthoritiesDAO {
	// property constants
	public static final String AUTHORITY_NAME = "authorityName";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Authorities entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * AuthoritiesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Authorities entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Authorities entity) {
		EntityManagerHelper
				.log("saving Authorities instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Authorities entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * AuthoritiesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Authorities entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Authorities entity) {
		EntityManagerHelper.log("deleting Authorities instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Authorities.class,
					entity.getAuthoritiesId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Authorities entity and return it or a copy of
	 * it to the sender. A copy of the Authorities entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = AuthoritiesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Authorities entity to update
	 * @return Authorities the persisted Authorities entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Authorities update(Authorities entity) {
		EntityManagerHelper.log("updating Authorities instance", Level.INFO,
				null);
		try {
			Authorities result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Authorities findById(Integer id) {
		EntityManagerHelper.log("finding Authorities instance with id: " + id,
				Level.INFO, null);
		try {
			Authorities instance = getEntityManager().find(Authorities.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Authorities entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Authorities property to query
	 * @param value
	 *            the property value to match
	 * @return List<Authorities> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Authorities> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Authorities instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Authorities model where model."
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

	public List<Authorities> findByAuthorityName(Object authorityName) {
		return findByProperty(AUTHORITY_NAME, authorityName);
	}

	/**
	 * Find all Authorities entities.
	 * 
	 * @return List<Authorities> all Authorities entities
	 */
	@SuppressWarnings("unchecked")
	public List<Authorities> findAll() {
		EntityManagerHelper.log("finding all Authorities instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Authorities model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}