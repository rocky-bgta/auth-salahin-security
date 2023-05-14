package com.auth.security.entites;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "is_adminuser_active")
	private Boolean isAdminUserActive;
	
	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email_verify")
	private Boolean emailVerify;

	@Column(name = "mobile_no_verify")
	private Boolean mobileNoVerify;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;
	
	@Column(name = "last_access_date")
	private Date lastAccessDate;
	
	@Column(name = "is_ops_user")
	private Boolean is_ops_user;
	
	@Column(name = "is_otop_enabled")
	private Boolean isOtopEnabled;
	
	@Column(name = "is_otop_setup")
	private Boolean isOtopSetup;
	
	@Column(name = "secretKey")
	private String secretKey;
	
	@Column(name = "login_failed_attempt")
	private Integer loginFailedAttempt;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> UserRole = new HashSet<UserRole>(0);

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
	private UserSocialInfo userSocialInfo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdminUserActive() {
		return isAdminUserActive;
	}

	public void setIsAdminUserActive(Boolean isAdminUserActive) {
		this.isAdminUserActive = isAdminUserActive;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Boolean getEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(Boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public Boolean getMobileNoVerify() {
		return mobileNoVerify;
	}

	public void setMobileNoVerify(Boolean mobileNoVerify) {
		this.mobileNoVerify = mobileNoVerify;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<UserRole> getUserRole() {
		return UserRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		UserRole = userRole;
	}

	public UserSocialInfo getUserSocialInfo() {
		return userSocialInfo;
	}

	public void setUserSocialInfo(UserSocialInfo userSocialInfo) {
		this.userSocialInfo = userSocialInfo;
	}

	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}
	

	public Boolean getIs_ops_user() {
		return is_ops_user;
	}

	public void setIs_ops_user(Boolean is_ops_user) {
		this.is_ops_user = is_ops_user;
	}

	public Boolean getIsOtopEnabled() {
		return (isOtopEnabled == null ? false : isOtopEnabled) ;
	}
	public void setIsOtopEnabled(Boolean isOtpEnabled) {
		this.isOtopEnabled = isOtpEnabled;
	}

	public Boolean getIsOtopSetup() {
		return (isOtopSetup == null ? false : isOtopSetup) ;
	}

	public void setIsOtopSetup(Boolean isOtopSetup) {
		this.isOtopSetup = isOtopSetup;
	}
	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Integer getLoginFailedAttempt() {
		return (loginFailedAttempt != null) ? loginFailedAttempt : 0;
	}

	public void setLoginFailedAttempt(Integer loginFailedAttempt) {
		this.loginFailedAttempt = loginFailedAttempt;
	}
	
	
	
}
