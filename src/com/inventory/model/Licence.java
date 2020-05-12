package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LICENCE")
public class Licence {
	
	@Override
	public String toString(){
		return licenceName;
	}
	
	@Id @GeneratedValue
	@Column(name = "LICENCE_ID")
	private Integer licenceId;
	
	@Column(name = "LICENCE_NAME")
	private String licenceName;
	
	@Column(name = "OWNER_NAME")
	private String ownerName;
	
	@Column(name = "LICENCE_NUMBER")
	private String licenceNumber;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "LAND_LINE")
	private String landLine;
	
	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "WEBSITE")
	private String website;
	
	@Column(name = "GST_NUMBER")
	private String gstNumber;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;
	
	@OneToOne
	@JoinColumn(name="LICENCE_TYPE_ID")
	private LicenceType licenceType;
	
	@OneToOne
	@JoinColumn(name="STATE_ID")
	private State state;
	
	@OneToOne
	@JoinColumn(name="BANK_ID")
	private Bank bank;

	public Integer getLicenceId() {
		return licenceId;
	}

	public void setLicenceId(Integer licenceId) {
		this.licenceId = licenceId;
	}

	public String getLicenceName() {
		return licenceName;
	}

	public void setLicenceName(String licenceName) {
		this.licenceName = licenceName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandLine() {
		return landLine;
	}

	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public LicenceType getLicenceType() {
		return licenceType;
	}

	public void setLicenceType(LicenceType licenceType) {
		this.licenceType = licenceType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	
	

}
