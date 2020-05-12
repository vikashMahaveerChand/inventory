package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STREET")
public class Street {
	
	@Override
	public String toString(){
		return streetName;
	}
	
	@Id @GeneratedValue
	@Column(name = "STREET_ID")
	private Integer streetId;
	
	@Column(name = "STREET_NAME")
	private String streetName;
	
	@OneToOne
	@JoinColumn(name="AREA_ID")
	private Area area;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	
	

}
