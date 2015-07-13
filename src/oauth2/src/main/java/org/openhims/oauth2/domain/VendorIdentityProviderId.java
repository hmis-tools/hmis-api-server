package org.openhims.oauth2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Embeddable
public class VendorIdentityProviderId implements java.io.Serializable {

	// Fields

	private Integer vendorIdentityProviderId;
	private Integer vendorZoneId;

	// Constructors

	/** default constructor */
	public VendorIdentityProviderId() {
	}

	/** full constructor */
	public VendorIdentityProviderId(Integer vendorIdentityProviderId,
			Integer vendorZoneId) {
		this.vendorIdentityProviderId = vendorIdentityProviderId;
		this.vendorZoneId = vendorZoneId;
	}

	// Property accessors

	@Column(name = "vendor_identity_provider_id", nullable = false)
	public Integer getVendorIdentityProviderId() {
		return this.vendorIdentityProviderId;
	}

	public void setVendorIdentityProviderId(Integer vendorIdentityProviderId) {
		this.vendorIdentityProviderId = vendorIdentityProviderId;
	}

	@Column(name = "vendor_zone_id", nullable = false)
	public Integer getVendorZoneId() {
		return this.vendorZoneId;
	}

	public void setVendorZoneId(Integer vendorZoneId) {
		this.vendorZoneId = vendorZoneId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VendorIdentityProviderId))
			return false;
		VendorIdentityProviderId castOther = (VendorIdentityProviderId) other;

		return ((this.getVendorIdentityProviderId() == castOther
				.getVendorIdentityProviderId()) || (this
				.getVendorIdentityProviderId() != null
				&& castOther.getVendorIdentityProviderId() != null && this
				.getVendorIdentityProviderId().equals(
						castOther.getVendorIdentityProviderId())))
				&& ((this.getVendorZoneId() == castOther.getVendorZoneId()) || (this
						.getVendorZoneId() != null
						&& castOther.getVendorZoneId() != null && this
						.getVendorZoneId().equals(castOther.getVendorZoneId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getVendorIdentityProviderId() == null ? 0 : this
						.getVendorIdentityProviderId().hashCode());
		result = 37
				* result
				+ (getVendorZoneId() == null ? 0 : this.getVendorZoneId()
						.hashCode());
		return result;
	}

}