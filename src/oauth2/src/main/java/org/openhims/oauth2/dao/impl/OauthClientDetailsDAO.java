package org.openhims.oauth2.dao.impl;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.openhims.oauth2.dao.IOauthClientDetailsDAO;
import org.openhims.oauth2.domain.OauthClientDetails;
import org.openhims.oauth2.util.EntityManagerHelper;

/**
 *@author Ashaar Riaz
 */
public class OauthClientDetailsDAO implements IOauthClientDetailsDAO {
	// property constants
	public static final String RESOURCES_ID = "resourcesId";
	public static final String CLIENT_SECRET = "clientSecret";
	public static final String SCOPE = "scope";
	public static final String AUTHORIZED_GRANTS_TYPES = "authorizedGrantsTypes";
	public static final String WEB_SERVER_REDIRECT_URI = "webServerRedirectUri";
	public static final String AUTHORITIES = "authorities";
	public static final String ACCES_TOKEN_VALIDITY = "accesTokenValidity";
	public static final String REFRESH_TOKEN_VALIDITY = "refreshTokenValidity";
	public static final String ADDITIONAL_INFORMATION = "additionalInformation";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OauthClientDetailsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            OauthClientDetails entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(OauthClientDetails entity) {
		EntityManagerHelper.log("saving OauthClientDetails instance",
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
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OauthClientDetailsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            OauthClientDetails entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(OauthClientDetails entity) {
		EntityManagerHelper.log("deleting OauthClientDetails instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(OauthClientDetails.class,
					entity.getClientId());
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
	 * entity = OauthClientDetailsDAO.update(entity);
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
	public OauthClientDetails update(OauthClientDetails entity) {
		EntityManagerHelper.log("updating OauthClientDetails instance",
				Level.INFO, null);
		try {
			OauthClientDetails result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public OauthClientDetails findById(Integer id) {
		EntityManagerHelper.log("finding OauthClientDetails instance with id: "
				+ id, Level.INFO, null);
		try {
			OauthClientDetails instance = getEntityManager().find(
					OauthClientDetails.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all OauthClientDetails entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the OauthClientDetails property to query
	 * @param value
	 *            the property value to match
	 * @return List<OauthClientDetails> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<OauthClientDetails> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding OauthClientDetails instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from OauthClientDetails model where model."
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

	public List<OauthClientDetails> findByResourcesId(Object resourcesId) {
		return findByProperty(RESOURCES_ID, resourcesId);
	}

	public List<OauthClientDetails> findByClientSecret(Object clientSecret) {
		return findByProperty(CLIENT_SECRET, clientSecret);
	}

	public List<OauthClientDetails> findByScope(Object scope) {
		return findByProperty(SCOPE, scope);
	}

	public List<OauthClientDetails> findByAuthorizedGrantsTypes(
			Object authorizedGrantsTypes) {
		return findByProperty(AUTHORIZED_GRANTS_TYPES, authorizedGrantsTypes);
	}

	public List<OauthClientDetails> findByWebServerRedirectUri(
			Object webServerRedirectUri) {
		return findByProperty(WEB_SERVER_REDIRECT_URI, webServerRedirectUri);
	}

	public List<OauthClientDetails> findByAuthorities(Object authorities) {
		return findByProperty(AUTHORITIES, authorities);
	}

	public List<OauthClientDetails> findByAccesTokenValidity(
			Object accesTokenValidity) {
		return findByProperty(ACCES_TOKEN_VALIDITY, accesTokenValidity);
	}

	public List<OauthClientDetails> findByRefreshTokenValidity(
			Object refreshTokenValidity) {
		return findByProperty(REFRESH_TOKEN_VALIDITY, refreshTokenValidity);
	}

	public List<OauthClientDetails> findByAdditionalInformation(
			Object additionalInformation) {
		return findByProperty(ADDITIONAL_INFORMATION, additionalInformation);
	}

	/**
	 * Find all OauthClientDetails entities.
	 * 
	 * @return List<OauthClientDetails> all OauthClientDetails entities
	 */
	@SuppressWarnings("unchecked")
	public List<OauthClientDetails> findAll() {
		EntityManagerHelper.log("finding all OauthClientDetails instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from OauthClientDetails model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}