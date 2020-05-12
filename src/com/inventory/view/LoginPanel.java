package com.inventory.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;

import com.inventory.components.MyButton;
import com.inventory.components.MyLabel;
import com.inventory.components.MyPanel;
import com.inventory.components.MyTextField;
import com.inventory.controller.AppController;
import com.inventory.controller.MasterController;
import com.inventory.model.Licence;
import com.inventory.model.LicenceType;
import com.inventory.model.User;
import com.inventory.utility.Session;

public class LoginPanel implements ActionListener,KeyListener{
	private static LoginPanel myInstance=null;
    
	MyLabel l_user_name,l_password;
    MyTextField user_name;
    JPasswordField password;
    MyButton login;
    JComboBox Licence;
    MyLabel photoview;
    
    private LoginPanel(){};
    
    public static LoginPanel getInstance(){
        if(myInstance==null){
            myInstance = new LoginPanel();
        }
        
        return myInstance;
    }
    
    JPanel panel;
    
    public JPanel getPanel(){
        initcomponent();
        return panel;
    }
    
    private void initcomponent(){
    	try{
    		panel=new JPanel(new MigLayout());
            MyPanel.setBorder("Login", panel);
            
            JPanel centerpanelMain=new JPanel(new MigLayout());
            JPanel centerpanel=new JPanel(new MigLayout());
            
            l_user_name=new MyLabel("User Name :");
            l_password=new MyLabel("Password :");
            
            user_name=new MyTextField(20);
            password=new JPasswordField(22);
            
            login=new MyButton("Login");
            
            Licence = new JComboBox();
            Licence.setSize(300, 10);
            List<Licence> LicenceList = MasterController.getInstace().getLicenceList();
            
            for(Licence obj:LicenceList){
                Licence.addItem(obj);
                //Licence.addItem(new LicenceItem(obj.getLicenceId(),obj.getLicencName(),obj.getAddress(),obj.getLicenceTypeName()));
            }
            
            centerpanel.add(l_user_name);        centerpanel.add(user_name,"wrap");
            centerpanel.add(l_password);        centerpanel.add(password,"wrap");
            centerpanel.add(new MyLabel("Licence :"));   centerpanel.add(Licence,"wrap");
                    
            centerpanel.add(login,"span2,center");
            
            centerpanelMain.add(centerpanel,"push, al center, wrap");
            
            photoview   =new MyLabel("");
            ImageIcon imageIcon = new ImageIcon("image/1Logo.jpg");
            photoview.setIcon(imageIcon);
            
            panel.add(photoview,"center,pushx,pushy,wrap");
            panel.add(centerpanelMain,"span,pushx,growx,wrap");
            
            login.addActionListener(this);
            Licence.addActionListener(this);
            password.addActionListener(this);
            
            login.addKeyListener(this);
            Licence.addKeyListener(this);
            password.addKeyListener(this);
            
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		onClickEvent(evt.getSource());
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
	
	private void onClickEvent(Object evt){
		if(evt == Licence || evt == password){
			((Component) evt).transferFocus();
			
		}else{
		//JOptionPane.showMessageDialog(null, "onclcik");
			if(evt == login){
				validatedUser();
			}
		}
	}
	
	private void validatedUser(){
		try{
			String userName = user_name.getText().trim();
			String psd = password.getText().trim();
			
			if(!userName.equalsIgnoreCase("") && !psd.equalsIgnoreCase("")){
				User userObj = MasterController.getInstace().validatedUser(userName, psd);
				if(userObj!=null){
					Session.user = userObj;
					Session.licence = (Licence)Licence.getSelectedItem();
					JOptionPane.showMessageDialog(null, "Validate User");
					AppController.getInstance().configureMenu();
				}else{
					JOptionPane.showMessageDialog(null, "In-Validate User");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Please Enter username and password!");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
