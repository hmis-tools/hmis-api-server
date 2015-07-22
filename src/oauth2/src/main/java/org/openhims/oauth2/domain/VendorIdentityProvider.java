package org.openhims.oauth2.domain;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "vendor_identity_provider")
public class VendorIdentityProvider implements java.io.Serializable {

	// Fields

	private VendorIdentityProviderId id;
	private Users usersByLogUsersId;
	private VendorZone vendorZone;
	private Users usersByEntryUsersId;
	private Integer sessionTimeout;
	private String vendorWebsite;
	private Boolean vendorRegistered;
	private Timestamp entryDate;
	private Timestamp logDate;

	// Constructors

	/** default constructor */
	public VendorIdentityProvider() {
	}

	/** minimal constructor */
	public VendorIdentityProvider(VendorIdentityProviderId id,
			Users usersByLogUsersId, VendorZone vendorZone,
			Users usersByEntryUsersId, Timestamp entryDate, Timestamp logDate) {
		this.id = id;
		this.usersByLogUsersId = usersByLogUsersId;
		this.vendorZone = vendorZone;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.entryDate = entryDate;
		this.logDate = logDate;
	}

	/** full constructor */
	public VendorIdentityProvider(VendorIdentityProviderId id,
			Users usersByLogUsersId, VendorZone vendorZone,
			Users usersByEntryUsersId, Integer sessionTimeout,
			String vendorWebsite, Boolean vendorRegistered,
			Timestamp entryDate, Timestamp logDate) {
		this.id = id;
		this.usersByLogUsersId = usersByLogUsersId;
		this.vendorZone = vendorZone;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.sessionTimeout = sessionTimeout;
		this.vendorWebsite = vendorWebsite;
		this.vendorRegistered = vendorRegistered;
		this.entryDate = entryDate;
		this.logDate = logDate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "vendorIdentityProviderId", column = @Column(name = "vendor_identity_provider_id", nullable = false)),
			@AttributeOverride(name = "vendorZoneId", column = @Column(name = "vendor_zone_id", nullable = false)) })
	public VendorIdentityProviderId getId() {
		return this.id;
	}

	public void setId(VendorIdentityProviderId id) {
		this.id = id;
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
	@JoinColumn(name = "vendor_zone_id", nullable = false, insertable = false, updatable = false)
	public VendorZone getVendorZone() {
		return this.vendorZone;
	}

	public void setVendorZone(VendorZone vendorZone) {
		this.vendorZone = vendorZone;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_users_id", nullable = false)
	public Users getUsersByEntryUsersId() {
		return this.usersByEntryUsersId;
	}

	public void setUsersByEntryUsersId(Users usersByEntryUsersId) {
		this.usersByEntryUsersId = usersByEntryUsersId;
	}

	@Column(name = "session_timeout")
	public Integer getSessionTimeout() {
		return this.sessionTimeout;
	}

	public void setSessionTimeout(Integer sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	@Column(name = "vendor_website", length = 1024)
	public String getVendorWebsite() {
		return this.vendorWebsite;
	}

	public void setVendorWebsite(String vendorWebsite) {
		this.vendorWebsite = vendorWebsite;
	}

	@Column(name = "vendor_registered")
	public Boolean getVendorRegistered() {
		return this.vendorRegistered;
	}

	public void setVendorRegistered(Boolean vendorRegistered) {
		this.vendorRegistered = vendorRegistered;
	}

	@Column(name = "entry_date", nullable = false, length = 19)
	public Timestamp getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "log_date", nullable = false, length = 19)
	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

}