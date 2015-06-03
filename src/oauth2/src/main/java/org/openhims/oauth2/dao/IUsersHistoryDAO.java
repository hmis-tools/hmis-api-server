package org.openhims.oauth2.dao;

import java.util.List;

import org.openhims.oauth2.domain.UsersHistory;

/**
 * 
 * @author Ashaar Riaz
 */

public interface IUsersHistoryDAO {
	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IUsersHistoryDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHistory entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(UsersHistory entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IUsersHistoryDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHistory entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(UsersHistory entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IUsersHistoryDAO.update(entity);
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
	public UsersHistory update(UsersHistory entity);

	public UsersHistory findById(Integer id);

	/**
	 * Find all UsersHistory entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the UsersHistory property to query
	 * @param value
	 *            the property value to match
	 * @return List<UsersHistory> found by query
	 */
	public List<UsersHistory> findByProperty(String propertyName, Object value);

	public List<UsersHistory> findByEmail(Object email);

	public List<UsersHistory> findByPhone(Object phone);

	public List<UsersHistory> findByFax(Object fax);

	/**
	 * Find all UsersHistory entities.
	 * 
	 * @return List<UsersHistory> all UsersHistory entities
	 */
	public List<UsersHistory> findAll();
}