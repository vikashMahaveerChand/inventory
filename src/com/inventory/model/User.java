package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	@Override
	public String toString(){
		return userName;
	}
	
	@Id @GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;
	
	@OneToOne
	@JoinColumn(name="USER_TYPE_ID")
	private UserType userType;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
