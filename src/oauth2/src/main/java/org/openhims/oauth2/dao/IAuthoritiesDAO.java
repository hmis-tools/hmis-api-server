package org.openhims.oauth2.dao;

import java.util.List;

import org.openhims.oauth2.domain.Authorities;

/**
 * 
 * @author Ashaar Riaz
 */

public interface IAuthoritiesDAO {
	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAuthoritiesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Authorities entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Authorities entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAuthoritiesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Authorities entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Authorities entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IAuthoritiesDAO.update(entity);
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
	public Authorities update(Authorities entity);

	public Authorities findById(Integer id);

	/**
	 * Find all Authorities entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Authorities property to query
	 * @param value
	 *            the property value to match
	 * @return List<Authorities> found by query
	 */
	public List<Authorities> findByProperty(String propertyName, Object value);

	public List<Authorities> findByAuthorityName(Object authorityName);

	/**
	 * Find all Authorities entities.
	 * 
	 * @return List<Authorities> all Authorities entities
	 */
	public List<Authorities> findAll();
}