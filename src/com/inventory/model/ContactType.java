package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_TYPE")
public class ContactType {
	
	@Override
	public String toString(){
		return contactTypeName;
	}
	
	@Id @GeneratedValue
	@Column(name = "CONTACT_ID")
	private Integer contactTypeId;
	
	@Column(name = "CONTACT_TYPE_NAME")
	private String contactTypeName;
	
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;


	public Integer getContactTypeId() {
		return contactTypeId;
	}


	public void setContactTypeId(Integer contactTypeId) {
		this.contactTypeId = contactTypeId;
	}


	public String getContactTypeName() {
		return contactTypeName;
	}


	public void setContactTypeName(String contactTypeName) {
		this.contactTypeName = contactTypeName;
	}


	public String getDeletedFlag() {
		return deletedFlag;
	}


	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	
	

}
