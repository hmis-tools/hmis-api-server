package org.openhmis.domain;



// Generated Aug 5, 2015 10:00:15 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TMP_USER")
public class TmpUser implements java.io.Serializable {
	private Integer userId;
	private String externalId;
	private Integer canRead;
	private Integer canWrite;
	private Integer canAdmin;
	private Date dateCreated;
	private Date dateUpdated;

	public TmpUser() {
	}

	public TmpUser(Integer userId, String externalId,
			Integer canRead, Integer canWrite,
			Integer canAdmin,
			Date dateCreated, Date dateUpdated) {
		this.userId = userId;
		this.externalId = externalId;
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.canAdmin = canAdmin;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "externalId")
	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@Column(name = "canRead")
	public Integer getCanRead() {
		return this.canRead;
	}

	public void setCanRead(Integer canRead) {
		this.canRead = canRead;
	}

	@Column(name = "canWrite")
	public Integer getCanWrite() {
		return this.canWrite;
	}

	public void setCanWrite(Integer canWrite) {
		this.canWrite = canWrite;
	}

	@Column(name = "canAdmin")
	public Integer getCanAdmin() {
		return this.canAdmin;
	}

	public void setCanAdmin(Integer canAdmin) {
		this.canAdmin = canAdmin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreated", length = 10)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateUpdated", length = 10)
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
