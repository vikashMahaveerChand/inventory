package com.inventory.controller;

import java.util.List;

import com.inventory.dto.LicenceOpeningStockDetailsDTO;
import com.inventory.model.Bank;
import com.inventory.model.EntryType;
import com.inventory.model.Licence;
import com.inventory.model.LicenceOpeningStockDetails;
import com.inventory.model.LicenceType;
import com.inventory.model.Metal;
import com.inventory.model.Ornament;
import com.inventory.model.State;
import com.inventory.model.User;
import com.inventory.model.UserType;
import com.inventory.service.MasterService;
import com.inventory.service.MasterServiceImpl;

public class MasterController {
	private static MasterController myInstance = null;
	MasterService masterService = null;
	
	private MasterController(){
		try{
			masterService = MasterServiceImpl.getInstace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static MasterController getInstace(){
		if(myInstance == null){
			myInstance = new MasterController();
		}
		return myInstance;
	}
	
	public LicenceType getLicenceType(Integer licenceTypeId){
		return masterService.getLicenceType(licenceTypeId);
	}
	
	public Integer saveOrUpdateLicence(Licence licence){
		return masterService.saveOrUpdateLicence(licence);
	}
	public List<Licence> getLicenceList(){
		return masterService.getLicenceList();
	}
	public List<LicenceType> getLicenceTypeList(){
		return masterService.getLicenceTypeList();
	}
	
	public Integer saveOrUpdateState(State state){
		return masterService.saveOrUpdateState(state);
	}
	public List<State> getStateList(){
		return masterService.getStateList();
	}
	public State getState(Integer stateId){
		return masterService.getState(stateId);
	}
	
	public Integer saveOrUpdateBank(Bank bank){
		return masterService.saveOrUpdateBank(bank);
	}
	public List<Bank> getBankList(){
		return masterService.getBankList();
	}
	public Bank getBank(Integer bankId){
		return masterService.getBank(bankId);
	}
	
	public Integer saveOrUpdateUser(User user){
		return masterService.saveOrUpdateUser(user);
	}
	public List<User> getUserList(){
		return masterService.getUserList();
	}
	public User getUser(Integer userId){
		return masterService.getUser(userId);
	}
	
	public Integer saveOrUpdateUserType(UserType userType){
		return masterService.saveOrUpdateUserType(userType);
	}
	public List<UserType> getUserTypeList(){
		return masterService.getUserTypeList();
	}
	public UserType getUserType(Integer userTypeId){
		return masterService.getUserType(userTypeId);
	}
	
	public User validatedUser(String userName,String password){
		return masterService.validateUser(userName, password);
	}
	public Licence getLicence(Integer licenceId){
		return masterService.getLicence(licenceId);
	}
	
	public Integer saveOrUpdateMetal(Metal metal){
		return masterService.saveOrUpdateMetal(metal);
	}
	public List<Metal> getMetalList(){
		return masterService.getMetalList();
	}
	public Metal getMetal(String metalCode){
		return masterService.getMetal(metalCode);
	}
	
	public Integer saveOrUpdateOrnament(Ornament ornament){
		return masterService.saveOrUpdateOrnament(ornament);
	}
	public List<Ornament> getOrnamentList(Integer licenceId){
		return masterService.getOrnamentList(licenceId);
	}
	public Ornament getOrnament(Integer ornamentId){
		return masterService.getOrnament(ornamentId);
	}
	
	public Integer saveOrUpdateEntryType(EntryType entryType){
		return masterService.saveOrUpdateEntryType(entryType);
	}
	public List<EntryType> getEntryTypeList(){
		return masterService.getEntryTypeList();
	}
	public EntryType getEntryType(String entryType){
		return masterService.getEntryType(entryType);
	}
	
	public List<LicenceOpeningStockDetailsDTO> getLicenceOpeningStockDetailsList(String entryTypeCode,Integer licenceId){
		return masterService.getLicenceOpeningStockDetailsList(entryTypeCode,licenceId);
	}
	
	public Integer saveOrUpdateLicenceOpeningStockDetails(LicenceOpeningStockDetails licenceOpeningStockDetails){
		return masterService.saveOrUpdateLicenceOpeningStockDetails(licenceOpeningStockDetails);
	}
	public List<LicenceOpeningStockDetails> getLicenceOpeningStockDetailsList(){
		return masterService.getLicenceOpeningStockDetailsList();
	}
	public LicenceOpeningStockDetails getLicenceOpeningStockDetails(Integer licenceOpeningStockDetailsId){
		return masterService.getLicenceOpeningStockDetails(licenceOpeningStockDetailsId);
	}

}
