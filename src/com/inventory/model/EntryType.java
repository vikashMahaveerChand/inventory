package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTRY_TYPE")
public class EntryType {
	
	@Override
	public String toString(){
		return entryType;
	}
	
	@Id @GeneratedValue
	@Column(name = "ENTRY_TYPE_ID")
	private Integer entryTypeId;
	
	@Column(name = "ENTRY_TYPE")
	private String entryType;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;

	public Integer getEntryTypeId() {
		return entryTypeId;
	}

	public void setEntryTypeId(Integer entryTypeId) {
		this.entryTypeId = entryTypeId;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	

}
