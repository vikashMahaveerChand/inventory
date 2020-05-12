package com.inventory.service;

import java.util.List;

import com.inventory.dao.MasterDAO;
import com.inventory.dao.MasterDAOImpl;
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

public class MasterServiceImpl implements MasterService{
	private static MasterServiceImpl myInstance = null;
	MasterDAO masterDAO = null;
	
	private MasterServiceImpl(){
		try{
			masterDAO = MasterDAOImpl.getInstace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static MasterServiceImpl getInstace(){
		if(myInstance == null){
			myInstance = new MasterServiceImpl();
		}
		return myInstance;
	}
	
	@Override
	public LicenceType getLicenceType(Integer licenceTypeId) {
		// TODO Auto-generated method stub
		return masterDAO.getLicenceType(licenceTypeId);
	}

	@Override
	public Integer saveOrUpdateLicence(Licence licence) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateLicence(licence);
	}

	@Override
	public List<Licence> getLicenceList() {
		// TODO Auto-generated method stub
		return masterDAO.getLicenceList();
	}

	@Override
	public List<LicenceType> getLicenceTypeList() {
		// TODO Auto-generated method stub
		return masterDAO.getLicenceTypeList();
	}

	@Override
	public Integer saveOrUpdateState(State state) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateState(state);
	}

	@Override
	public List<State> getStateList() {
		// TODO Auto-generated method stub
		return masterDAO.getStateList();
	}

	@Override
	public State getState(Integer stateId) {
		// TODO Auto-generated method stub
		return masterDAO.getState(stateId);
	}

	@Override
	public Integer saveOrUpdateBank(Bank bank) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateBank(bank);
	}

	@Override
	public List<Bank> getBankList() {
		// TODO Auto-generated method stub
		return masterDAO.getBankList();
	}

	@Override
	public Bank getBank(Integer bankId) {
		// TODO Auto-generated method stub
		return masterDAO.getBank(bankId);
	}

	@Override
	public Integer saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateUser(user);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return masterDAO.getUserList();
	}

	@Override
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		return masterDAO.getUser(userId);
	}

	@Override
	public Integer saveOrUpdateUserType(UserType userType) {
		// TODO Auto-generated method stub
		return saveOrUpdateUserType(userType);
	}

	@Override
	public List<UserType> getUserTypeList() {
		// TODO Auto-generated method stub
		return masterDAO.getUserTypeList();
	}

	@Override
	public UserType getUserType(Integer userTypeId) {
		// TODO Auto-generated method stub
		return masterDAO.getUserType(userTypeId);
	}

	@Override
	public User validateUser(String userName, String password) {
		// TODO Auto-generated method stub
		User user = null;
		try{
			List<User> userList = masterDAO.getUserList();
			
			if(userList!=null && userList.size()>0){
				for(User obj : userList){
					if(userName.equals(obj.getUserName()) && password.equals(obj.getPassword())){
						user = obj;
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public Licence getLicence(Integer licenceId) {
		// TODO Auto-generated method stub
		return masterDAO.getLicence(licenceId);
	}

	@Override
	public Integer saveOrUpdateMetal(Metal metal) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateMetal(metal);
	}

	@Override
	public List<Metal> getMetalList() {
		// TODO Auto-generated method stub
		return masterDAO.getMetalList();
	}

	@Override
	public Metal getMetal(String metalCode) {
		// TODO Auto-generated method stub
		return masterDAO.getMetal(metalCode);
	}

	@Override
	public Integer saveOrUpdateOrnament(Ornament ornament) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateOrnament(ornament);
	}

	@Override
	public List<Ornament> getOrnamentList(Integer licenceId) {
		// TODO Auto-generated method stub
		return masterDAO.getOrnamentList(licenceId);
	}

	@Override
	public Ornament getOrnament(Integer ornamentId) {
		// TODO Auto-generated method stub
		return masterDAO.getOrnament(ornamentId);
	}

	@Override
	public Integer saveOrUpdateEntryType(EntryType entryType) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateEntryType(entryType);
	}

	@Override
	public List<EntryType> getEntryTypeList() {
		// TODO Auto-generated method stub
		return masterDAO.getEntryTypeList();
	}

	@Override
	public EntryType getEntryType(String entryType) {
		// TODO Auto-generated method stub
		return masterDAO.getEntryType(entryType);
	}

	@Override
	public List<LicenceOpeningStockDetailsDTO> getLicenceOpeningStockDetailsList(String entryTypeCode,Integer licenceId) {
		// TODO Auto-generated method stub
		return masterDAO.getLicenceOpeningStockDetailsList(entryTypeCode,licenceId);
	}

	@Override
	public Integer saveOrUpdateLicenceOpeningStockDetails(
			LicenceOpeningStockDetails licenceOpeningStockDetails) {
		// TODO Auto-generated method stub
		return masterDAO.saveOrUpdateLicenceOpeningStockDetails(licenceOpeningStockDetails);
	}

	@Override
	public List<LicenceOpeningStockDetails> getLicenceOpeningStockDetailsList() {
		// TODO Auto-generated method stub
		return masterDAO.getLicenceOpeningStockDetailsList();
	}

	@Override
	public LicenceOpeningStockDetails getLicenceOpeningStockDetails(
			Integer licenceOpeningStockDetailsId) {
		// TODO Auto-generated method stub
		return masterDAO.getLicenceOpeningStockDetails(licenceOpeningStockDetailsId);
	}

}
