package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORNAMENT_GROUP")
public class OrnamentGroup {
	
	@Override
	public String toString(){
		return ornamentGroupName;
	}
	
	@Id @GeneratedValue
	@Column(name = "ORNAMENT_GROUP_ID")
	private Integer ornamentGroupId;
	
	@Column(name = "ORNAMENT_GROUP_NAME")
	private String ornamentGroupName;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;

	public Integer getOrnamentGroupId() {
		return ornamentGroupId;
	}

	public void setOrnamentGroupId(Integer ornamentGroupId) {
		this.ornamentGroupId = ornamentGroupId;
	}

	public String getOrnamentGroupName() {
		return ornamentGroupName;
	}

	public void setOrnamentGroupName(String ornamentGroupName) {
		this.ornamentGroupName = ornamentGroupName;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	

}
