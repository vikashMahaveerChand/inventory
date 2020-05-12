package com.inventory.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.miginfocom.swing.MigLayout;

import com.inventory.components.MyButton;
import com.inventory.components.MyLabel;
import com.inventory.components.MyPanel;
import com.inventory.components.MyTextField;
import com.inventory.controller.AppController;
import com.inventory.controller.MasterController;
import com.inventory.model.Bank;
import com.inventory.model.Licence;
import com.inventory.model.LicenceType;
import com.inventory.model.State;
import com.inventory.utility.ConstantUtils;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class LicenceForm implements DocumentListener, ActionListener, KeyListener, MouseListener{
	private static LicenceForm myInstance = null;
	Licence licenceObj = null;

	private LicenceForm() {
	}

	public static LicenceForm getInstance() {
		if (myInstance == null) {
			myInstance = new LicenceForm();
		}

		return myInstance;
	}

	JPanel panel;
	String calledFrom;
	Integer licenceId;
	String userType;
	
	MyTextField licenceName, address, ownerName, landLine, mobile, email, website, gstNumber;
	JComboBox licenceType,state,bank;
	MyButton save;	
	
	List<LicenceType> LicenceTypeList = null;
	List<State> stateList = null;
	List<Bank> bankList = null;
	
	public JPanel getPanel(String calledFrom,Integer licenceId,String userType){
		this.calledFrom = calledFrom;
		this.licenceId = licenceId;
		this.userType = userType;
		initComponent();
		constructLicenceForm();
		if(licenceId>0){
			loadLicence();
		}
		return panel;
	}
	
	private void initComponent() {
		try {
			panel = new JPanel(new MigLayout());
			
			licenceName=new MyTextField(20); 
			address=new MyTextField(20);
			ownerName=new MyTextField(20);
			landLine=new MyTextField(20);
			mobile=new MyTextField(20);
			email=new MyTextField(20);
			website=new MyTextField(20);
			gstNumber=new MyTextField(20);
			
			save = new MyButton("Save");
			
			licenceType = new JComboBox();
			licenceType.setSize(300, 10);
			
			LicenceTypeList = MasterController.getInstace().getLicenceTypeList();
            
            for(LicenceType obj:LicenceTypeList){
            	licenceType.addItem(obj);
            }
            
            state = new JComboBox();
			state.setSize(300, 10);
			stateList = MasterController.getInstace().getStateList();
            
            for(State obj:stateList){
            	state.addItem(obj);
            }
            
            bank = new JComboBox();
            bank.setSize(300, 10);
			bankList = MasterController.getInstace().getBankList();
			bank.addItem(ConstantUtils.SELECT_BANK);
            for(Bank obj:bankList){
            	bank.addItem(obj);
            }
			save.addActionListener(this);
			licenceType.addActionListener(this);
			state.addActionListener(this);
			bank.addActionListener(this);
			
			save.addKeyListener(this);
			licenceType.addKeyListener(this);
			state.addKeyListener(this);
			bank.addKeyListener(this);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void constructLicenceForm(){
		try{
			MyPanel.setBorder("Licence Form", panel);
			
			if(userType.equalsIgnoreCase(ConstantUtils.BLANK) || userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_GST) || userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_ADMIN)){
				constructGSTLicenceForm();
			}else if(userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_NON_GST)){
				constructNONGSTLicenceForm();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void constructGSTLicenceForm(){
		try{
			MyPanel.setBorder("Licence Form", panel);
			
			panel.add(new MyLabel("Licence Name : "));
			panel.add(licenceName, "wrap");

			panel.add(new MyLabel("Address : "));
			panel.add(address, "wrap");

			panel.add(new MyLabel("Licence Holder Name : "));
			panel.add(ownerName, "wrap");

			panel.add(new MyLabel("LandLine : "));
			panel.add(landLine, "wrap");

			panel.add(new MyLabel("Email Id : "));
			panel.add(email, "wrap");

			panel.add(new MyLabel("Website : "));
			panel.add(website, "wrap");

			panel.add(new MyLabel("GST No : "));
			panel.add(gstNumber, "wrap");

			panel.add(new MyLabel("State : "));
			panel.add(state, "wrap");
			
			panel.add(new MyLabel("Bank : "));
			panel.add(bank, "wrap");
			
			if(LicenceTypeList!=null && LicenceTypeList.size()>1){
				panel.add(new MyLabel("Licence Type : "));
				panel.add(licenceType, "wrap");
			}
			
			panel.add(save);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void constructNONGSTLicenceForm(){
		try{
			MyPanel.setBorder("Licence Form", panel);
			
			panel.add(new MyLabel("Licence Name : "));
			panel.add(licenceName, "wrap");

			if(LicenceTypeList!=null && LicenceTypeList.size()>1){		
				panel.add(new MyLabel("Licence Type : "));
				panel.add(licenceType, "wrap");
			}
			panel.add(save);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void loadLicence(){
		try{
			Licence licenceLoad = MasterController.getInstace().getLicence(licenceId);
			
			if(licenceLoad!=null){
				if(licenceLoad.getLicenceName()!=null){
					licenceName.setText(licenceLoad.getLicenceName()); 
				}
				if(licenceLoad.getAddress()!=null){
					address.setText(licenceLoad.getAddress());
				}
				if(licenceLoad.getOwnerName()!=null){
					ownerName.setText(licenceLoad.getOwnerName());
				}
				if(licenceLoad.getLandLine()!=null){
					landLine.setText(licenceLoad.getLandLine());
				}
				if(licenceLoad.getMobile()!=null){
					mobile.setText(licenceLoad.getMobile());
				}
				if(licenceLoad.getEmail()!=null){
					email.setText(licenceLoad.getEmail());
				}
				if(licenceLoad.getWebsite()!=null){
					website.setText(licenceLoad.getWebsite());
				}
				if(licenceLoad.getGstNumber()!=null){
					gstNumber.setText(licenceLoad.getGstNumber());
				}
				
				//JComboBox licenceType,state,bank;
				
				if(licenceLoad.getBank()!=null){
					int bankIndex = 0;
					if(bankList!=null && bankList.size()>0){
						for(Bank bank : bankList){
							bankIndex++;
							if(bank.getBankId().equals(licenceLoad.getBank().getBankId())){
								break;
							}
						}
					}
					if(bankIndex>-1){
						bank.setSelectedIndex(bankIndex);
					}
				}
				
				if(licenceLoad.getState()!=null){
					int stateIndex = -1;
					if(stateList!=null && stateList.size()>0){
						for(State state : stateList){
							stateIndex++;
							if(state.getStateId().equals(licenceLoad.getState().getStateId())){
								break;
							}
						}
					}
					if(stateIndex>-1){
						state.setSelectedIndex(stateIndex);
					}
				}
				
				if(licenceLoad.getLicenceType()!=null){
					int licenceTypeIndex = -1;
					if(LicenceTypeList!=null && LicenceTypeList.size()>0){
						for(LicenceType licenceType : LicenceTypeList){
							licenceTypeIndex++;
							if(licenceType.getLicenceTypeId().equals(licenceLoad.getLicenceType().getLicenceTypeId())){
								break;
							}
						}
					}
					if(licenceTypeIndex>-1){
						licenceType.setSelectedIndex(licenceTypeIndex);
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			onClickEvent(evt.getSource());
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		onClickEvent(evt.getSource());
		
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void onClickEvent(Object evt){
		if(evt == licenceType || evt == state || evt == bank){
			((Component) evt).transferFocus();
			if(evt == bank){
				System.out.println("bank"+bank.getSelectedItem().toString());
			}
		}else{
		//JOptionPane.showMessageDialog(null, "onclcik");
			if(evt == save){
				saveOrUpdateLicence();
			}
		}
	}
	
	private void saveOrUpdateLicence(){
		try{
			//licenceName, address, ownerName, landLine, mobile, email, website, gstNumber
			licenceObj = new Licence();
			
			if(licenceId!=null && licenceId >0){
				licenceObj.setLicenceId(licenceId);
			}
			
			if(!licenceName.getText().trim().equals("")){
				licenceObj.setLicenceName(licenceName.getText().trim());
			}
			
			if(!address.getText().trim().equals("")){
				licenceObj.setAddress(address.getText().trim());
			}
			
			if(!ownerName.getText().trim().equals("")){
				licenceObj.setOwnerName(ownerName.getText().trim());
			}
			
			if(!landLine.getText().trim().equals("")){
				licenceObj.setLandLine(landLine.getText().trim());
			}
			if(!mobile.getText().trim().equals("")){
				licenceObj.setMobile(mobile.getText().trim());
			}
			if(!email.getText().trim().equals("")){
				licenceObj.setEmail(email.getText().trim());
			}
			if(!website.getText().trim().equals("")){
				licenceObj.setWebsite(website.getText().trim());
			}
			if(!gstNumber.getText().trim().equals("")){
				licenceObj.setGstNumber(gstNumber.getText().trim());
			}
			if(licenceType.getSelectedItem()!=null){
				licenceObj.setLicenceType((LicenceType)licenceType.getSelectedItem());
			}
			if(state.getSelectedItem()!=null){
				licenceObj.setState((State)state.getSelectedItem());
			}
			
			if(bank.getSelectedItem()!=null && !bank.getSelectedItem().toString().equalsIgnoreCase(ConstantUtils.SELECT_BANK)){
				licenceObj.setBank((Bank)bank.getSelectedItem());
			}
			licenceObj.setDeletedFlag(ConstantUtils.CONSTANT_N);
			licenceId = MasterController.getInstace().saveOrUpdateLicence(licenceObj);
			if(licenceId!=null && licenceId>0){
				JOptionPane.showMessageDialog(null, "Licence Saved!!");
				if(calledFrom.equalsIgnoreCase(ConstantUtils.MENU)){
					AppController.getInstance().addLicenceFormPage(ConstantUtils.MENU, 0,userType);
				}else if(calledFrom.equalsIgnoreCase(ConstantUtils.LOGIN_PAGE)){
					AppController.getInstance().addLoginPage();
				}else if(calledFrom.equalsIgnoreCase(ConstantUtils.LICENCE_REPORT)){
					AppController.getInstance().addLicenceReportPage(userType);
				}
			}
		}catch(Exception ex){
			
		}
	}

}
