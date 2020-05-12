package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TYPE")
public class UserType {
	
	@Override
	public String toString(){
		return userType;
	}
	
	@Id @GeneratedValue
	@Column(name = "USER_TYPE_ID")
	private Integer userTypeId;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

}
