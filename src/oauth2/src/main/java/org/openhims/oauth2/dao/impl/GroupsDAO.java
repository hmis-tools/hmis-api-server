package org.openhims.oauth2.dao.impl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.openhims.oauth2.dao.IGroupsDAO;
import org.openhims.oauth2.domain.Groups;
import org.openhims.oauth2.util.EntityManagerHelper;

/**
 * 
 * @author Ashaar Riaz
 */
public class GroupsDAO implements IGroupsDAO {
	// property constants
	public static final String GROUP_NAME = "groupName";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * GroupsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Groups entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Groups entity) {
		EntityManagerHelper.log("saving Groups instance", Level.INFO, null);
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
	 * GroupsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Groups entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Groups entity) {
		EntityManagerHelper.log("deleting Groups instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Groups.class,
					entity.getGroupsId());
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
	 * entity = GroupsDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Groups entity to update
	 * @return Groups the persisted Groups entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Groups update(Groups entity) {
		EntityManagerHelper.log("updating Groups instance", Level.INFO, null);
		try {
			Groups result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Groups findById(Integer id) {
		EntityManagerHelper.log("finding Groups instance with id: " + id,
				Level.INFO, null);
		try {
			Groups instance = getEntityManager().find(Groups.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Groups entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Groups property to query
	 * @param value
	 *            the property value to match
	 * @return List<Groups> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Groups> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Groups instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Groups model where model."
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

	public List<Groups> findByGroupName(Object groupName) {
		return findByProperty(GROUP_NAME, groupName);
	}

	/**
	 * Find all Groups entities.
	 * 
	 * @return List<Groups> all Groups entities
	 */
	@SuppressWarnings("unchecked")
	public List<Groups> findAll() {
		EntityManagerHelper.log("finding all Groups instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Groups model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}
}