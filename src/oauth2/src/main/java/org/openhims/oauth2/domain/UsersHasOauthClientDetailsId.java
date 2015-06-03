package org.openhims.oauth2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Embeddable
public class UsersHasOauthClientDetailsId implements java.io.Serializable {

	// Fields

	private Integer usersId;
	private Integer clientId;

	// Constructors

	/** default constructor */
	public UsersHasOauthClientDetailsId() {
	}

	/** full constructor */
	public UsersHasOauthClientDetailsId(Integer usersId, Integer clientId) {
		this.usersId = usersId;
		this.clientId = clientId;
	}

	// Property accessors

	@Column(name = "users_id", nullable = false)
	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	@Column(name = "client_id", nullable = false)
	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsersHasOauthClientDetailsId))
			return false;
		UsersHasOauthClientDetailsId castOther = (UsersHasOauthClientDetailsId) other;

		return ((this.getUsersId() == castOther.getUsersId()) || (this
				.getUsersId() != null && castOther.getUsersId() != null && this
				.getUsersId().equals(castOther.getUsersId())))
				&& ((this.getClientId() == castOther.getClientId()) || (this
						.getClientId() != null
						&& castOther.getClientId() != null && this
						.getClientId().equals(castOther.getClientId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsersId() == null ? 0 : this.getUsersId().hashCode());
		result = 37 * result
				+ (getClientId() == null ? 0 : this.getClientId().hashCode());
		return result;
	}

}