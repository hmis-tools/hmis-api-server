package org.openhims.oauth2.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "users_history")
public class UsersHistory implements java.io.Serializable {

	// Fields

	private Integer usersHistoryId;
	private Users usersByLogUsersId;
	private Users usersByEntryUsersId;
	private Users usersByUsersId;
	private String email;
	private String phone;
	private String fax;
	private Timestamp entryDate;

	// Constructors

	/** default constructor */
	public UsersHistory() {
	}

	/** minimal constructor */
	public UsersHistory(Users usersByLogUsersId, Users usersByEntryUsersId,
			Users usersByUsersId, Timestamp entryDate) {
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.usersByUsersId = usersByUsersId;
		this.entryDate = entryDate;
	}

	/** full constructor */
	public UsersHistory(Users usersByLogUsersId, Users usersByEntryUsersId,
			Users usersByUsersId, String email, String phone, String fax,
			Timestamp entryDate) {
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.usersByUsersId = usersByUsersId;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
		this.entryDate = entryDate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "users_history_id", unique = true, nullable = false)
	public Integer getUsersHistoryId() {
		return this.usersHistoryId;
	}

	public void setUsersHistoryId(Integer usersHistoryId) {
		this.usersHistoryId = usersHistoryId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false)
	public Users getUsersByUsersId() {
		return this.usersByUsersId;
	}

	public void setUsersByUsersId(Users usersByUsersId) {
		this.usersByUsersId = usersByUsersId;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "fax")
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "entry_date", nullable = false, length = 19)
	public Timestamp getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

}