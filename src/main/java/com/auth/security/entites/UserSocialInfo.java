package com.auth.security.entites;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_social_info")
public class UserSocialInfo {

	@Id
	@GeneratedValue
	@Column(name = "user_social_info_id", unique = true, nullable = false)
	private Long userSocialInfoId;

	@Column(name = "public_url")
	private String publicUrl;

	@Column(name = "friends_count")
	private Integer friendCount;

	@Column(name = "access_token")
	private String accessToken;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@Column(name = "account_type_id")
	private Integer accountTypeId;
	
	@Column(name = "social_id")
	private String socialId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "maiden_name")
	private String maidenName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "locale")
	private String locale;
	
	@Column(name = "timezone")
	private Timestamp timezone;
	
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
	

	public Long getUserSocialInfoId() {
		return userSocialInfoId;
	}

	public void setUserSocialInfoId(Long userSocialInfoId) {
		this.userSocialInfoId = userSocialInfoId;
	}

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public Integer getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(Integer friendCount) {
		this.friendCount = friendCount;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Timestamp getTimezone() {
		return timezone;
	}

	public void setTimezone(Timestamp timezone) {
		this.timezone = timezone;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	
	

}
