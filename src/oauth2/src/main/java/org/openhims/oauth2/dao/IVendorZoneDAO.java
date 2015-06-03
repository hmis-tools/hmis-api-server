package org.openhims.oauth2.dao;

import java.util.List;

import org.openhims.oauth2.domain.VendorZone;

/**
 * 
 * @author Ashaar Riaz
 */

public interface IVendorZoneDAO {
	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVendorZoneDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorZone entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(VendorZone entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVendorZoneDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            VendorZone entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(VendorZone entity);

	/**
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVendorZoneDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            VendorZone entity to update
	 * @return VendorZone the persisted VendorZone entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public VendorZone update(VendorZone entity);

	public VendorZone findById(Integer id);

	/**
	 * Find all VendorZone entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the VendorZone property to query
	 * @param value
	 *            the property value to match
	 * @return List<VendorZone> found by query
	 */
	public List<VendorZone> findByProperty(String propertyName, Object value);

	public List<VendorZone> findByVendorName(Object vendorName);

	/**
	 * Find all VendorZone entities.
	 * 
	 * @return List<VendorZone> all VendorZone entities
	 */
	public List<VendorZone> findAll();
}