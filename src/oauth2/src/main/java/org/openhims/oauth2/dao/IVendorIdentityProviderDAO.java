package org.openhims.oauth2.dao;

import java.util.List;

import org.openhims.oauth2.domain.VendorIdentityProvider;
import org.openhims.oauth2.domain.VendorIdentityProviderId;

/**
 * 
 * @author Ashaar Riaz
 */

public interface IVendorIdentityProviderDAO {
	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVendorIdentityProviderDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorIdentityProvider entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VendorIdentityProvider entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVendorIdentityProviderDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VendorIdentityProvider entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VendorIdentityProvider entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVendorIdentityProviderDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorIdentityProvider entity to update
	 * @return VendorIdentityProvider the persisted VendorIdentityProvider
	 *         entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VendorIdentityProvider update(VendorIdentityProvider entity);

	public VendorIdentityProvider findById(VendorIdentityProviderId id);

	/**
	 * Find all VendorIdentityProvider entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VendorIdentityProvider property to query
	 * @param value
	 *            the property value to match
	 * @return List<VendorIdentityProvider> found by query
	 */
	public List<VendorIdentityProvider> findByProperty(String propertyName,
			Object value);

	public List<VendorIdentityProvider> findBySessionTimeout(
			Object sessionTimeout);

	public List<VendorIdentityProvider> findByVendorWebsite(Object vendorWebsite);

	public List<VendorIdentityProvider> findByVendorRegistered(
			Object vendorRegistered);

	/**
	 * Find all VendorIdentityProvider entities.
	 * 
	 * @return List<VendorIdentityProvider> all VendorIdentityProvider entities
	 */
	public List<VendorIdentityProvider> findAll();
}