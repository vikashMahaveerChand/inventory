package com.inventory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ORNAMENT")
public class Ornament {
	
	@Override
	public String toString(){
		return ornamentName;
	}
	
	@Id @GeneratedValue
	@Column(name = "ORNAMENT_ID")
	private Integer ornamentId;
	
	@OneToOne
	@JoinColumn(name="METAL_ID")
	private Metal metalId;
	
	@OneToOne
	@JoinColumn(name="ORNAMENT_GROUP_ID")
	private OrnamentGroup ornamentGroupId;
	
	@OneToOne
	@JoinColumn(name="ORNAMENT_SUB_GROUP_ID")
	private OrnamentSubGroup ornamentSubGroupId;
	
	@Column(name = "ORNAMENT_NAME")
	private String ornamentName;
	
	@Column(name = "ORNAMENT_KEY_CODE")
	private String ornamentKeyCode;
	
	@Column(name = "GST_PERCENTAGE")
	private Double gstPercentage;
	
	@Column(name = "DELETED_FLAG")
	private String deletedFlag;
	
	@Column(name = "LICENCE_ID")
	private Integer licenceId;
	
	/*@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="ORNAMENT_ID")
    private List<LicenceOpeningStockDetails> licenceOpeningStockDetailsList;*/

	public Integer getOrnamentId() {
		return ornamentId;
	}

	public void setOrnamentId(Integer ornamentId) {
		this.ornamentId = ornamentId;
	}

	public Metal getMetalId() {
		return metalId;
	}

	public void setMetalId(Metal metalId) {
		this.metalId = metalId;
	}

	public OrnamentGroup getOrnamentGroupId() {
		return ornamentGroupId;
	}

	public void setOrnamentGroupId(OrnamentGroup ornamentGroupId) {
		this.ornamentGroupId = ornamentGroupId;
	}

	public OrnamentSubGroup getOrnamentSubGroupId() {
		return ornamentSubGroupId;
	}

	public void setOrnamentSubGroupId(OrnamentSubGroup ornamentSubGroupId) {
		this.ornamentSubGroupId = ornamentSubGroupId;
	}

	public String getOrnamentName() {
		return ornamentName;
	}

	public void setOrnamentName(String ornamentName) {
		this.ornamentName = ornamentName;
	}

	public String getOrnamentKeyCode() {
		return ornamentKeyCode;
	}

	public void setOrnamentKeyCode(String ornamentKeyCode) {
		this.ornamentKeyCode = ornamentKeyCode;
	}

	public Double getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(Double gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public Integer getLicenceId() {
		return licenceId;
	}

	public void setLicenceId(Integer licenceId) {
		this.licenceId = licenceId;
	}

	/*public List<LicenceOpeningStockDetails> getLicenceOpeningStockDetailsList() {
		return licenceOpeningStockDetailsList;
	}

	public void setLicenceOpeningStockDetailsList(
			List<LicenceOpeningStockDetails> licenceOpeningStockDetailsList) {
		this.licenceOpeningStockDetailsList = licenceOpeningStockDetailsList;
	}*/
	

}
