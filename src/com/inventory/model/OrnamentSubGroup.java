package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORNAMENT_GROUP")
public class OrnamentSubGroup {
	
	@Override
	public String toString(){
		return ornamentSubGroupName;
	}
	
	@Id @GeneratedValue
	@Column(name = "ORNAMENT_SUB_GROUP_ID")
	private Integer ornamentSubGroupId;
	
	@Column(name = "ORNAMENT_SUB_GROUP_NAME")
	private String ornamentSubGroupName;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;

	public Integer getOrnamentSubGroupId() {
		return ornamentSubGroupId;
	}

	public void setOrnamentSubGroupId(Integer ornamentSubGroupId) {
		this.ornamentSubGroupId = ornamentSubGroupId;
	}

	public String getOrnamentSubGroupName() {
		return ornamentSubGroupName;
	}

	public void setOrnamentSubGroupName(String ornamentSubGroupName) {
		this.ornamentSubGroupName = ornamentSubGroupName;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
}
