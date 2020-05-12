package com.inventory.controller;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import com.inventory.model.Licence;
import com.inventory.model.User;
import com.inventory.utility.ConstantUtils;
import com.inventory.utility.Session;
import com.inventory.view.FooterPanel;
import com.inventory.view.HeaderPanel;
import com.inventory.view.LicenceForm;
import com.inventory.view.LicenceReport;
import com.inventory.view.LoginPanel;
import com.inventory.view.OrnamentForm;
import com.inventory.view.OrnamentReport;
import com.inventory.view.UserForm;
import com.inventory.view.UserReport;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class AppController {
	public JFrame frame;
    public JPanel header,center,footer;
    
    private static AppController myInstance;

    private AppController(){

    }
    public static AppController getInstance(){
        
        if(myInstance==null){
            myInstance =new AppController();
        }
        
        return myInstance;
    }
    
    public void start(){
        initcomponent();
    }
    
    public void initcomponent(){
    	try{
    		frame=new JFrame();
            frame.setLayout(new BorderLayout());
            //frame.setLayout(new MigLayout());
            
            header=new JPanel(new BorderLayout());
            center=new JPanel(new BorderLayout());
            footer=new JPanel(new BorderLayout());
            
            frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            frame.setLocationRelativeTo(null);
            frame.setTitle("Vikash - 994-133-6844");
            ImageIcon img = new ImageIcon("image/Logo.jpg");
            frame.setIconImage(img.getImage());
            
            frame.add(header,BorderLayout.NORTH);
            frame.add(center,BorderLayout.CENTER);
            frame.add(footer,BorderLayout.SOUTH);
            
            /*frame.add(header,"pushx,growx,pushy,growy,wrap");
            frame.add(center,"center,pushx,growx,pushy,growy,wrap");
            frame.add(footer,"pushx,growx,pushy,growy,wrap");*/
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
    		
            addHeaderPanel(ConstantUtils.DEFAULT,ConstantUtils.DEFAULT);
            addLoginPage();
            addFooterPanel();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	
    }
    
    public void addToHeaderPanel(JPanel content){
        
        header.removeAll();
        header.add(content);
        header.revalidate();
        header.repaint();
        //page.asComponent().requestFocus();
    
    }
    public void addToFooterPanel(JPanel content){
        
    	footer.removeAll();
    	footer.add(content);
    	footer.revalidate();
    	footer.repaint();
        //page.asComponent().requestFocus();
    
    }
    public void addToCenterPanel(JPanel content){
    
        center.removeAll();
        center.add(content);
        center.revalidate();
        center.repaint();
    
    }
    
    public void addHeaderPanel(String licenceType,String userType){
        addToHeaderPanel(HeaderPanel.getInstance().getPanel(licenceType,userType));
    }
    
    public void addFooterPanel(){
    	addToFooterPanel(FooterPanel.getInstance().getPanel());
    }
    
    public void addLoginPage(){
    	List<Licence> LicenceList = MasterController.getInstace().getLicenceList();
    	List<User> userList = MasterController.getInstace().getUserList();
    	
    	if((LicenceList!=null && LicenceList.size()>0) && (userList !=null && userList.size()>0)){
    		addToCenterPanel(LoginPanel.getInstance().getPanel());
    	}else if(userList==null || userList.size()<=0){
    		addUserFormPage(ConstantUtils.LOGIN_PAGE,0,ConstantUtils.BLANK);
    	}else if(LicenceList==null || LicenceList.size()<=0){
    		addLicenceFormPage(ConstantUtils.LOGIN_PAGE,0,ConstantUtils.BLANK);
    	}
    }
    
    public void addLicenceFormPage(String calledFrom,Integer licenceId,String userType){
    	addToCenterPanel(LicenceForm.getInstance().getPanel(calledFrom, licenceId,userType));
    }
    public void addLicenceReportPage(String userType){
    	addToCenterPanel(LicenceReport.getInstance().getPanel(userType));
    }
    
    public void addUserFormPage(String calledFrom,Integer userId,String userType){
    	addToCenterPanel(UserForm.getInstance().getPanel(calledFrom, userId,userType));
    }
    public void addUserReportPage(String userType){
    	addToCenterPanel(UserReport.getInstance().getPanel(userType));
    }
    
    public void addOrnamentFormPage(String metalCode,Integer ornamentId,String calledFrom,String userType,Integer licenceId){
    	addToCenterPanel(OrnamentForm.getInstance().getPanel(metalCode, ornamentId, calledFrom, userType, licenceId));
    }
    public void addOrnamentReportPage(String userType,String calledFrom){
    	addToCenterPanel(OrnamentReport.getInstance().getPanel(userType,calledFrom));
    }
    public void configureMenu(){
    	try{
    		User user = Session.user;
    		Licence licence = Session.licence;
    		String userType ="";
    		String licenceType ="";
    		String licenceName="";
    		
    		if(user!=null){
    			userType = user.getUserType().getUserType();
    		}

    		if(licence!=null){
    			licenceType = licence.getLicenceType().getLicenceTypeName();
    			licenceName = licence.getLicenceName();
    		}
    		addHeaderPanel(licenceType,userType);
    		frame.setTitle(licenceName + " - "+userType);
    		
    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

}
