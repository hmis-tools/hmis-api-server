package org.openhmis.domain;



// Generated July 27, 2016 1:21:15 PM by cdonnelly

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
@Table(name = "TMP_TOKEN_CACHE")
public class TmpTokenCache implements java.io.Serializable {
        private Integer tokenCacheId;
	private String externalId;
        private String idToken;
	private Date dateCreated;
	private Date dateUpdated;

	public TmpTokenCache() {
	}

        public TmpTokenCache(Integer tokenCacheId, String externalId,
                         String idToken,
			Date dateCreated, Date dateUpdated) {
                this.tokenCacheId = tokenCacheId;
		this.externalId = externalId;
                this.idToken = idToken;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tokenCacheId", unique = true, nullable = false)
	public Integer getTokenCacheId() {
		return this.tokenCacheId;
	}

	public void setTokenCacheId(Integer tokenCacheId) {
		this.tokenCacheId = tokenCacheId;
	}

        @Column(name = "externalId")
	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

        @Column(name = "idToken")
	public String getIdToken() {
		return this.idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
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
