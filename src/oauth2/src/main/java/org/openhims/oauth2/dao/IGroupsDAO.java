package org.openhims.oauth2.dao;

import java.util.List;

import org.openhims.oauth2.domain.Groups;

/**
 * 
 * @author Ashaar Riaz
 */

public interface IGroupsDAO {
	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IGroupsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Groups entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Groups entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IGroupsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Groups entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Groups entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IGroupsDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Groups entity to update
	 * @return Groups the persisted Groups entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Groups update(Groups entity);

	public Groups findById(Integer id);

	/**
	 * Find all Groups entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Groups property to query
	 * @param value
	 *            the property value to match
	 * @return List<Groups> found by query
	 */
	public List<Groups> findByProperty(String propertyName, Object value);

	public List<Groups> findByGroupName(Object groupName);

	/**
	 * Find all Groups entities.
	 * 
	 * @return List<Groups> all Groups entities
	 */
	public List<Groups> findAll();
}