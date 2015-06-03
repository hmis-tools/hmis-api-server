package org.openhims.oauth2.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for UsersHasOauthClientDetailsDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IUsersHasOauthClientDetailsDAO {
	/**
	 * Perform an initial save of a previously unsaved
	 * UsersHasOauthClientDetails entity. All subsequent persist actions of this
	 * entity should use the #update() method. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently saved to the persistence store, i.e., database. This method
	 * uses the {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IUsersHasOauthClientDetailsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHasOauthClientDetails entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(UsersHasOauthClientDetails entity);

	/**
	 * Delete a persistent UsersHasOauthClientDetails entity. This operation
	 * must be performed within the a database transaction context for the
	 * entity's data to be permanently deleted from the persistence store, i.e.,
	 * database. This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IUsersHasOauthClientDetailsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            UsersHasOauthClientDetails entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(UsersHasOauthClientDetails entity);

	/**
	 * Persist a previously saved UsersHasOauthClientDetails entity and return
	 * it or a copy of it to the sender. A copy of the
	 * UsersHasOauthClientDetails entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IUsersHasOauthClientDetailsDAO.update(entity);
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
	public UsersHasOauthClientDetails update(UsersHasOauthClientDetails entity);

	public UsersHasOauthClientDetails findById(UsersHasOauthClientDetailsId id);

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
	public List<UsersHasOauthClientDetails> findByProperty(String propertyName,
			Object value);

	public List<UsersHasOauthClientDetails> findByScope(Object scope);

	public List<UsersHasOauthClientDetails> findByStatus(Object status);

	/**
	 * Find all UsersHasOauthClientDetails entities.
	 * 
	 * @return List<UsersHasOauthClientDetails> all UsersHasOauthClientDetails
	 *         entities
	 */
	public List<UsersHasOauthClientDetails> findAll();
}