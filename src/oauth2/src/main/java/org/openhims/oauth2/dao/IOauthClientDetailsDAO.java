package org.openhims.oauth2.dao;

import java.util.List;

import org.openhims.oauth2.domain.OauthClientDetails;

/**
 * 
 * @author Ashaar Riaz
 */

public interface IOauthClientDetailsDAO {
	
	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOauthClientDetailsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OauthClientDetails entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OauthClientDetails entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOauthClientDetailsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OauthClientDetails entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OauthClientDetails entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IOauthClientDetailsDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OauthClientDetails entity to update
	 * @return OauthClientDetails the persisted OauthClientDetails entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public OauthClientDetails update(OauthClientDetails entity);

	public OauthClientDetails findById(Integer id);

	/**
	 * Find all OauthClientDetails entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OauthClientDetails property to query
	 * @param value
	 *            the property value to match
	 * @return List<OauthClientDetails> found by query
	 */
	public List<OauthClientDetails> findByProperty(String propertyName,
			Object value);

	public List<OauthClientDetails> findByResourcesId(Object resourcesId);

	public List<OauthClientDetails> findByClientSecret(Object clientSecret);

	public List<OauthClientDetails> findByScope(Object scope);

	public List<OauthClientDetails> findByAuthorizedGrantsTypes(
			Object authorizedGrantsTypes);

	public List<OauthClientDetails> findByWebServerRedirectUri(
			Object webServerRedirectUri);

	public List<OauthClientDetails> findByAuthorities(Object authorities);

	public List<OauthClientDetails> findByAccesTokenValidity(
			Object accesTokenValidity);

	public List<OauthClientDetails> findByRefreshTokenValidity(
			Object refreshTokenValidity);

	public List<OauthClientDetails> findByAdditionalInformation(
			Object additionalInformation);

	/**
	 * Find all OauthClientDetails entities.
	 * 
	 * @return List<OauthClientDetails> all OauthClientDetails entities
	 */
	public List<OauthClientDetails> findAll();
}