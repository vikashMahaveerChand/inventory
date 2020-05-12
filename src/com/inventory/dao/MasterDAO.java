package com.inventory.dao;

import java.util.List;

import com.inventory.dto.LicenceOpeningStockDetailsDTO;
import com.inventory.model.Bank;
import com.inventory.model.Employee;
import com.inventory.model.EntryType;
import com.inventory.model.Licence;
import com.inventory.model.LicenceOpeningStockDetails;
import com.inventory.model.LicenceType;
import com.inventory.model.Metal;
import com.inventory.model.Ornament;
import com.inventory.model.State;
import com.inventory.model.User;
import com.inventory.model.UserType;

public interface MasterDAO {
	public LicenceType getLicenceType(Integer licenceTypeId);
	public List<LicenceType> getLicenceTypeList();
	
	public Integer saveOrUpdateLicence(Licence licence);
	public List<Licence> getLicenceList();
	public Licence getLicence(Integer licenceId);
	
	public Integer saveOrUpdateState(State state);
	public List<State> getStateList();
	public State getState(Integer stateId);
	
	public Integer saveOrUpdateBank(Bank bank);
	public List<Bank> getBankList();
	public Bank getBank(Integer bankId);
	
	public Integer saveOrUpdateUser(User user);
	public List<User> getUserList();
	public User getUser(Integer userId);
	
	public Integer saveOrUpdateUserType(UserType userType);
	public List<UserType> getUserTypeList();
	public UserType getUserType(Integer userTypeId);
	
	public Integer saveOrUpdateEmployee(Employee employee);
	public List<Employee> getEmployeeList();
	public Employee getEmployee(Integer employeeId);

	public Integer saveOrUpdateMetal(Metal metal);
	public List<Metal> getMetalList();
	public Metal getMetal(String metalCode);
	
	public Integer saveOrUpdateOrnament(Ornament ornament);
	public List<Ornament> getOrnamentList(Integer licenceId);
	public Ornament getOrnament(Integer ornamentId);
	public List<LicenceOpeningStockDetailsDTO> getLicenceOpeningStockDetailsList(String entryTypeCode,Integer licenceId);
	
	
	public Integer saveOrUpdateEntryType(EntryType entryType);
	public List<EntryType> getEntryTypeList();
	public EntryType getEntryType(String entryType);
	
	
	public Integer saveOrUpdateLicenceOpeningStockDetails(LicenceOpeningStockDetails licenceOpeningStockDetails);
	public List<LicenceOpeningStockDetails> getLicenceOpeningStockDetailsList();
	public LicenceOpeningStockDetails getLicenceOpeningStockDetails(Integer licenceOpeningStockDetailsId);
}
