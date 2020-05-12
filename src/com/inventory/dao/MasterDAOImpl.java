package com.inventory.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
import com.inventory.utility.ConstantUtils;
import com.inventory.utility.HibernateUtil;


public class MasterDAOImpl implements MasterDAO {
	
	private static MasterDAOImpl myInstance = null;
	SessionFactory factory = null;
	
	private MasterDAOImpl(){
		try{
		factory = HibernateUtil.getSessionFactory();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static MasterDAOImpl getInstace(){
		if(myInstance == null){
			myInstance = new MasterDAOImpl();
		}
		return myInstance;
	}

	@Override
	public LicenceType getLicenceType(Integer licenceTypeId) {
		// TODO Auto-generated method stub
		LicenceType licenceType = null;
		
		
		Session session = null;
		try{
			session = factory.openSession();
			
			licenceType = (LicenceType)session.get(LicenceType.class, licenceTypeId);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licenceType;
	}

	@Override
	public Integer saveOrUpdateLicence(Licence licence) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer licenceId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(licence);
		    licence = (Licence)session.merge(licence);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(licence!=null){
		    	licenceId = licence.getLicenceId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licenceId;
	}

	@Override
	public List<Licence> getLicenceList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Licence> licence = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Licence.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
			criteria.addOrder(Order.asc("licenceName"));
            licence = (List<Licence>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licence;
	}

	@Override
	public List<LicenceType> getLicenceTypeList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<LicenceType> licenceType = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(LicenceType.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
            licenceType = (List<LicenceType>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licenceType;
	}

	@Override
	public Integer saveOrUpdateState(State state) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer stateId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(state);
		    state = (State)session.merge(state);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(state!=null){
		    	stateId = state.getStateId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return stateId;
	}

	@Override
	public List<State> getStateList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<State> stateTypeList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(State.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
            stateTypeList = (List<State>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return stateTypeList;
	}

	@Override
	public State getState(Integer stateId) {
		// TODO Auto-generated method stub
		State state = null;
		
		
		Session session = null;
		try{
			session = factory.openSession();
			
			state = (State)session.get(State.class, stateId);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return state;
	}

	@Override
	public Integer saveOrUpdateBank(Bank bank) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer bankId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(bank);
		    bank = (Bank)session.merge(bank);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(bank!=null){
		    	bankId = bank.getBankId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return bankId;
	}

	@Override
	public List<Bank> getBankList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Bank> bankList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Bank.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
            bankList = (List<Bank>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return bankList;
	}

	@Override
	public Bank getBank(Integer bankId) {
		// TODO Auto-generated method stub
		Bank bank = null;
		
		
		Session session = null;
		try{
			session = factory.openSession();
			
			bank = (Bank)session.get(Bank.class, bankId);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return bank;
	}

	@Override
	public Integer saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer userId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(user);
		    user = (User)session.merge(user);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(user!=null){
		    	userId = user.getUserId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return userId;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<User> userList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
            userList = (List<User>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public User getUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = null;
		
		
		Session session = null;
		try{
			session = factory.openSession();
			
			user = (User)session.get(User.class, userId);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public Integer saveOrUpdateUserType(UserType userType) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer userTypeId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(userType);
		    userType = (UserType)session.merge(userType);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(userType!=null){
		    	userTypeId = userType.getUserTypeId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return userTypeId;
	}

	@Override
	public List<UserType> getUserTypeList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<UserType> userTypeList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(UserType.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
            userTypeList = (List<UserType>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return userTypeList;
	}

	@Override
	public UserType getUserType(Integer userTypeId) {
		// TODO Auto-generated method stub
		UserType userType = null;
		
		
		Session session = null;
		try{
			session = factory.openSession();
			
			userType = (UserType)session.get(UserType.class, userTypeId);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return userType;
	}

	@Override
	public Integer saveOrUpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer employeeId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    //session.saveOrUpdate(employee);
		    employee = (Employee)session.merge(employee);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(employee!=null){
		    	employeeId = employee.getEmployeeId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return employeeId;
	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Employee> employeeList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Employee.class);
			//criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
            employeeList = (List<Employee>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return employeeList;
	}

	@Override
	public Employee getEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee = null;
		
		
		Session session = null;
		try{
			session = factory.openSession();
			
			employee = (Employee)session.get(Employee.class, employeeId);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public Licence getLicence(Integer licenceId) {
		// TODO Auto-generated method stub
		Licence licence = null;
		
		
		Session session = null;
		try{
			session = factory.openSession();
			
			licence = (Licence)session.get(Licence.class, licenceId);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licence;
	}
	
	@Override
	public Integer saveOrUpdateMetal(Metal metal) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer metalId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(metal);
		    metal = (Metal)session.merge(metal);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(metal!=null){
		    	metalId = metal.getMetalId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return metalId;
	}

	@Override
	public List<Metal> getMetalList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Metal> metalList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Metal.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
            metalList = (List<Metal>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return metalList;
	}

	@Override
	public Metal getMetal(String metalCode) {
		// TODO Auto-generated method stub
		Metal metal = null;
		List<Metal> metalList = null;
		
		Session session = null;
		try{
			session = factory.openSession();
			
			//metal = (Metal)session.get(Metal.class, metalId);
			
			Criteria criteria = session.createCriteria(Metal.class);
			criteria.add(Restrictions.eq("metalCode", metalCode));
             
            metalList = (List<Metal>) criteria.list();
            
            if(metalList!=null && metalList.size()>0){
            	metal = metalList.get(0);
            }
            
            
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return metal;
	}
	
	@Override
	public Integer saveOrUpdateOrnament(Ornament ornament) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer ornamentId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(ornament);
		    ornament = (Ornament)session.merge(ornament);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(ornament!=null){
		    	ornamentId = ornament.getOrnamentId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return ornamentId;
	}

	@Override
	public List<Ornament> getOrnamentList(Integer licenceId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Ornament> ornamentList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Ornament.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
			criteria.add(Restrictions.eq("licenceId", licenceId));
			criteria.addOrder(Order.asc("ornamentName"));
			ornamentList = (List<Ornament>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return ornamentList;
	}

	@Override
	public Ornament getOrnament(Integer ornamentId) {
		// TODO Auto-generated method stub
		Ornament ornament = null;
		Session session = null;
		try{
			session = factory.openSession();
			
			ornament = (Ornament)session.get(Ornament.class, ornamentId);
			
            
            
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return ornament;
	}

	@Override
	public Integer saveOrUpdateEntryType(EntryType entryType) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer entryTypeId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(entryType);
		    entryType = (EntryType)session.merge(entryType);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(entryType!=null){
		    	entryTypeId = entryType.getEntryTypeId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return entryTypeId;
	}

	@Override
	public List<EntryType> getEntryTypeList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<EntryType> entryTypeList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(EntryType.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
			entryTypeList = (List<EntryType>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return entryTypeList;
	}

	@Override
	public EntryType getEntryType(String entryType) {
		// TODO Auto-generated method stub
		EntryType entryTypeObj = null;
		List<EntryType> entryTypeList = null;
		
		Session session = null;
		try{
			session = factory.openSession();
			
			Criteria criteria = session.createCriteria(EntryType.class);
			criteria.add(Restrictions.eq("entryType", entryType));
             
			entryTypeList = (List<EntryType>) criteria.list();
            
            if(entryTypeList!=null && entryTypeList.size()>0){
            	entryTypeObj = entryTypeList.get(0);
            }
            
            
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return entryTypeObj;
	}

	@Override
	public List<LicenceOpeningStockDetailsDTO> getLicenceOpeningStockDetailsList(String entryTypeCode,Integer licenceId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<Ornament> ornamentList = null;
		List<LicenceOpeningStockDetails> lornamentList = null;
		List<LicenceOpeningStockDetailsDTO> licenceOrnamentListDTO = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
//			Criteria criteria = session.createCriteria(Ornament.class,"ornament");
//			criteria.createAlias("ornament.licenceOpeningStockDetailsList", "licenceStock");
//			
//			criteria.add(Restrictions.eq("ornament.deletedFlag", ConstantUtils.CONSTANT_N));
//			criteria.add(Restrictions.eq("licenceStock.deletedFlag", ConstantUtils.CONSTANT_N));
//			
//			criteria.addOrder(Order.asc("ornament.ornamentName"));
//			ornamentList = (List<Ornament>) criteria.list();
//          tx.commit();
            
            
			Criteria criteria = session.createCriteria(Ornament.class,"ornament");
			criteria.createAlias("ornament.licenceOpeningStockDetailsList", "licenceStock");
			criteria.setFetchMode("issues.issuetracker", FetchMode.JOIN);
			criteria.add(Restrictions.eq("ornament.deletedFlag", ConstantUtils.CONSTANT_N));
			criteria.addOrder(Order.asc("ornament.ornamentName"));
			//ornamentList = (List<Ornament>) criteria.list();
			
//            Criteria c1 = session.createCriteria(Child.class);
//            c1.add(Restrictions.in("property", properties));
//            c1.setProjection( Projections.distinct( Projections.property( "parentId" ) ) );
//            List<Integer> parentIds = c1.list();
//
//            Criteria c2 = session.createCriteria(Parent.class);
//            c2.createAlias("children", "children");
//            c2.add(Restrictions.in("id", parentIds));
//            return c2.list();
            
				StringBuffer sqlQuery = new StringBuffer();
				/*sqlQuery.append("	");
				sqlQuery.append("	SELECT ORNAMENT.ORNAMENT_ID,ORNAMENT.ORNAMENT_NAME,ORNAMENT.ORNAMENT_KEY_CODE,	");
				//sqlQuery.append("	LICENCE_OPENING.LICENCE_OPENING_STOCK_DETAILS_ID,LICENCE_OPENING.GRAMS 	");
				sqlQuery.append("	CASE WHEN ENTRY.ENTRY_TYPE IS NULL THEN NULL	");
				sqlQuery.append("	WHEN ENTRY.ENTRY_TYPE = 'GST' THEN LICENCE_OPENING.GRAMS	");
				sqlQuery.append("	END GST_GRAMS,	");
				sqlQuery.append("	CASE WHEN ENTRY.ENTRY_TYPE IS NULL THEN NULL	");
				sqlQuery.append("	WHEN ENTRY.ENTRY_TYPE = 'GST' THEN LICENCE_OPENING.LICENCE_OPENING_STOCK_DETAILS_ID	");
				sqlQuery.append("	END GST_OPENING_STOCK_DETAILS_ID,	");
				sqlQuery.append("	CASE WHEN ENTRY.ENTRY_TYPE IS NULL THEN NULL	");
				sqlQuery.append("	WHEN ENTRY.ENTRY_TYPE = 'NON_GST' THEN LICENCE_OPENING.GRAMS	");
				sqlQuery.append("	END NONGST_GRAMS,	");
				sqlQuery.append("	CASE WHEN ENTRY.ENTRY_TYPE IS NULL THEN NULL	");
				sqlQuery.append("	WHEN ENTRY.ENTRY_TYPE = 'NON_GST' THEN LICENCE_OPENING.LICENCE_OPENING_STOCK_DETAILS_ID	");
				sqlQuery.append("	END NONGST_OPENING_STOCK_DETAILS_ID	");
				sqlQuery.append("	FROM ORNAMENT ORNAMENT LEFT JOIN  LICENCE_OPENING_STOCK_DETAILS LICENCE_OPENING	");
				sqlQuery.append("	ON LICENCE_OPENING.ORNAMENT_ID = ORNAMENT.ORNAMENT_ID	");
				sqlQuery.append("	LEFT JOIN ENTRY_TYPE ENTRY ON LICENCE_OPENING.ENTRY_TYPE_ID = ENTRY.ENTRY_TYPE_ID	");
				sqlQuery.append("	WHERE 0=0	");
				sqlQuery.append("	and (LICENCE_OPENING.DELETED_FLAG IS NULL OR LICENCE_OPENING.DELETED_FLAG= :deletedFlag1)	");
				sqlQuery.append("	AND (LICENCE_OPENING.LICENCE_ID IS NULL OR LICENCE_OPENING.LICENCE_ID= :licenceId1)	");
				sqlQuery.append("	AND ORNAMENT.DELETED_FLAG= :deletedFlag2 AND ORNAMENT.LICENCE_ID= :licenceId2	");
				sqlQuery.append("	ORDER BY ORNAMENT.ORNAMENT_NAME ASC	");
				
				SQLQuery query = session.createSQLQuery(sqlQuery.toString());
				System.out.println("getLicenceOpeningStockDetailsList sqlQuery - "+sqlQuery);
				query.setParameter("deletedFlag1", ConstantUtils.CONSTANT_N);
				query.setParameter("licenceId1", licenceId);
				query.setParameter("deletedFlag2", ConstantUtils.CONSTANT_N);
				query.setParameter("licenceId2", licenceId);
				List<Object[]> results = query.list();*/
				
				
				sqlQuery.append("	SELECT ORNAMENT.ORNAMENT_ID,ORNAMENT.ORNAMENT_NAME,ORNAMENT.ORNAMENT_KEY_CODE,	");
				sqlQuery.append("	LICENCE_OPENING.LICENCE_OPENING_STOCK_DETAILS_ID,	");
				sqlQuery.append("	LICENCE_OPENING.GST_GRAMS,LICENCE_OPENING.NONGST_GRAMS	");
				sqlQuery.append("	FROM ORNAMENT ORNAMENT LEFT OUTER JOIN  LICENCE_OPENING_STOCK_DETAILS LICENCE_OPENING	");
				sqlQuery.append("	ON LICENCE_OPENING.ORNAMENT_ID = ORNAMENT.ORNAMENT_ID	");
				sqlQuery.append("	WHERE 0=0	");
				sqlQuery.append("	and (LICENCE_OPENING.DELETED_FLAG IS NULL OR LICENCE_OPENING.DELETED_FLAG= :deletedFlag1)	");
				sqlQuery.append("	AND (LICENCE_OPENING.LICENCE_ID IS NULL OR LICENCE_OPENING.LICENCE_ID= :licenceId1)	");
				sqlQuery.append("		AND ORNAMENT.DELETED_FLAG= :deletedFlag2 AND ORNAMENT.LICENCE_ID= :licenceId2	");
				
				SQLQuery query = session.createSQLQuery(sqlQuery.toString());
				query.setParameter("deletedFlag1", ConstantUtils.CONSTANT_N);
				query.setParameter("licenceId1", licenceId);
				query.setParameter("deletedFlag2", ConstantUtils.CONSTANT_N);
				query.setParameter("licenceId2", licenceId);
				
				List<Object[]> results = query.list();
				
				if(results!=null){
					System.out.println(results.size());
					licenceOrnamentListDTO = new ArrayList<LicenceOpeningStockDetailsDTO>();
					for(Object[] obj:results){
						int i=-1;
						
						LicenceOpeningStockDetailsDTO dto = new LicenceOpeningStockDetailsDTO();
						
						if(obj[++i]!=null){
							dto.setOrnamentId((Integer)obj[i]);
						}
						if(obj[++i]!=null){
							dto.setOrnamentName((String)obj[i]);
						}
						
						if(obj[++i]!=null){
							dto.setOrnamentKeyCode((String)obj[i]);
						}
						
						if(obj[++i]!=null){
							//dto.setLicenceOpeningStockDetailsId(((BigInteger)obj[i]).intValue());
							dto.setLicenceOpeningStockDetailsId(((Integer)obj[i]));
						}
						
						if(obj[++i]!=null){
							dto.setGstGrams((Double)obj[i]);
						}
						
						if(obj[++i]!=null){
							dto.setNonGstGrams((Double)obj[i]);
						}
						
						
						licenceOrnamentListDTO.add(dto);
						
					}
				}
				
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licenceOrnamentListDTO;
	}
	
	@Override
	public Integer saveOrUpdateLicenceOpeningStockDetails(LicenceOpeningStockDetails licenceOpeningStockDetails) {
		// TODO Auto-generated method stub
		Session session = null;
		Integer liceneOpeningStockDetailsId = null;
		try{
			session = factory.openSession();
			
			Transaction t = session.beginTransaction();   
		        
		    session.saveOrUpdate(licenceOpeningStockDetails);
		    licenceOpeningStockDetails = (LicenceOpeningStockDetails)session.merge(licenceOpeningStockDetails);
		    
 		    t.commit();  
		    System.out.println("successfully saved");    
		    
		    if(licenceOpeningStockDetails!=null){
		    	liceneOpeningStockDetailsId = licenceOpeningStockDetails.getLicenceOpeningStockDetailsId();
		    	
		    }
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return liceneOpeningStockDetailsId;
	}

	@Override
	public List<LicenceOpeningStockDetails> getLicenceOpeningStockDetailsList() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<LicenceOpeningStockDetails> licenceOpeningStockList = null;
		try{
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Criteria criteria = session.createCriteria(LicenceOpeningStockDetails.class);
			criteria.add(Restrictions.eq("deletedFlag", ConstantUtils.CONSTANT_N));
             
			licenceOpeningStockList = (List<LicenceOpeningStockDetails>) criteria.list();
            tx.commit();
            
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licenceOpeningStockList;
	}

	@Override
	public LicenceOpeningStockDetails getLicenceOpeningStockDetails(Integer licenceOpeningStockDetailsId) {
		// TODO Auto-generated method stub
		LicenceOpeningStockDetails licenceOpeningStockDetailsObj = null;
		List<LicenceOpeningStockDetails> licenceOpeningStockDetailsList = null;
		
		Session session = null;
		try{
			session = factory.openSession();
			
			Criteria criteria = session.createCriteria(LicenceOpeningStockDetails.class);
			criteria.add(Restrictions.eq("licenceOpeningStockDetailsId", licenceOpeningStockDetailsId));
             
			licenceOpeningStockDetailsList = (List<LicenceOpeningStockDetails>) criteria.list();
            
            if(licenceOpeningStockDetailsList!=null && licenceOpeningStockDetailsList.size()>0){
            	licenceOpeningStockDetailsObj = licenceOpeningStockDetailsList.get(0);
            }
            
            
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				session.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return licenceOpeningStockDetailsObj;
	}
	
}


