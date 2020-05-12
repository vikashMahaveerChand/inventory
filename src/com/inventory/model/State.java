package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATE")
public class State {
	
	@Override
	public String toString(){
		return stateName;
	}
	
	@Id @GeneratedValue
	@Column(name = "STATE_ID")
	private Integer stateId;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

}
