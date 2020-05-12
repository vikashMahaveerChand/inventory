package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LICENCE_TYPE")
public class LicenceType {
	
	@Override
	public String toString(){
		return licenceTypeName;
	}

	@Id @GeneratedValue
	@Column(name = "LICENCE_TYPE_ID")
	private Integer licenceTypeId;
	
	@Column(name = "LICENCE_TYPE_NAME")
	private String licenceTypeName;

	@Column(name = "DELETED_FLAG")
	private String deletedFlag;

	public Integer getLicenceTypeId() {
		return licenceTypeId;
	}

	public void setLicenceTypeId(Integer licenceTypeId) {
		this.licenceTypeId = licenceTypeId;
	}

	public String getLicenceTypeName() {
		return licenceTypeName;
	}

	public void setLicenceTypeName(String licenceTypeName) {
		this.licenceTypeName = licenceTypeName;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

}
