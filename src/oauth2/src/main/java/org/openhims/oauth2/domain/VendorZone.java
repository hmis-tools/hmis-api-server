package org.openhims.oauth2.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "vendor_zone")
public class VendorZone implements java.io.Serializable {

	// Fields

	private Integer vendorZoneId;
	private Users usersByLogUsersId;
	private Users usersByEntryUsersId;
	private String vendorName;
	private Timestamp entryDate;
	private Timestamp logDate;
	private Set<VendorIdentityProvider> vendorIdentityProviders = new HashSet<VendorIdentityProvider>(
			0);

	// Constructors

	/** default constructor */
	public VendorZone() {
	}

	/** minimal constructor */
	public VendorZone(Integer vendorZoneId, Users usersByLogUsersId,
			Users usersByEntryUsersId) {
		this.vendorZoneId = vendorZoneId;
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
	}

	/** full constructor */
	public VendorZone(Integer vendorZoneId, Users usersByLogUsersId,
			Users usersByEntryUsersId, String vendorName, Timestamp entryDate,
			Timestamp logDate,
			Set<VendorIdentityProvider> vendorIdentityProviders) {
		this.vendorZoneId = vendorZoneId;
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.vendorName = vendorName;
		this.entryDate = entryDate;
		this.logDate = logDate;
		this.vendorIdentityProviders = vendorIdentityProviders;
	}

	// Property accessors
	@Id
	@Column(name = "vendor_zone_id", unique = true, nullable = false)
	public Integer getVendorZoneId() {
		return this.vendorZoneId;
	}

	public void setVendorZoneId(Integer vendorZoneId) {
		this.vendorZoneId = vendorZoneId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "log_users_id", nullable = false)
	public Users getUsersByLogUsersId() {
		return this.usersByLogUsersId;
	}

	public void setUsersByLogUsersId(Users usersByLogUsersId) {
		this.usersByLogUsersId = usersByLogUsersId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_users_id", nullable = false)
	public Users getUsersByEntryUsersId() {
		return this.usersByEntryUsersId;
	}

	public void setUsersByEntryUsersId(Users usersByEntryUsersId) {
		this.usersByEntryUsersId = usersByEntryUsersId;
	}

	@Column(name = "vendor_name")
	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Column(name = "entry_date", length = 19)
	public Timestamp getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "log_date", length = 19)
	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vendorZone")
	public Set<VendorIdentityProvider> getVendorIdentityProviders() {
		return this.vendorIdentityProviders;
	}

	public void setVendorIdentityProviders(
			Set<VendorIdentityProvider> vendorIdentityProviders) {
		this.vendorIdentityProviders = vendorIdentityProviders;
	}

}