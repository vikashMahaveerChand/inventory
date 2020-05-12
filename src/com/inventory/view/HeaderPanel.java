package com.inventory.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.inventory.components.MyLabel;
import com.inventory.components.MyPanel;
import com.inventory.controller.AppController;
import com.inventory.utility.ConstantUtils;
import com.inventory.utility.Session;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import net.miginfocom.swing.MigLayout;

public class HeaderPanel implements ActionListener,MouseListener{
	private static HeaderPanel myInstance=null;
    
    private HeaderPanel(){};
    
    public static HeaderPanel getInstance(){
        if(myInstance==null){
            myInstance = new HeaderPanel();
        }
        
        return myInstance;
    }
    
    JPanel panel;
    String licenceType;
    String userType;
    JMenuBar menuBar;  
    JMenu retailBilling,wholesaleBilling,purchaseBilling,reports,payment,bank,master;
    //Billing Related Menu Items Starts
    JMenuItem gstRetailBillGold,gstRetailBillSilver,nonGstRetailBillGold,nonGstRetailBillSilver,retailCustomer;
    JMenuItem gstWholesaleBillingGold,gstWholesaleBillingSilver,nonGstWholesaleBillingGold,nonGstWholesaleBillingSilver,wholesaleCustomer;
    JMenuItem gstPurchaseBillingGold,gstPurchaseBillingSilver,nonGstPurchaseBillingGold,nonGstPurchaseBillingSilver,purchaseCustomer;
    //Billing Related Menu Items Ends
    
    //Report Related Menu Items Starts
    JMenuItem gstRetailBillGoldReport,gstRetailBillSilverReport,nonGstRetailBillGoldReport,nonGstRetailBillSilverReport,retailCustomerReport;
    JMenuItem gstWholesaleBillingGoldReport,gstWholesaleBillingSilverReport,nonGstWholesaleBillingGoldReport,nonGstWholesaleBillingSilverReport,wholesaleCustomerReport;
    JMenuItem gstPurchaseBillingGoldReport,gstPurchaseBillingSilverReport,nonGstPurchaseBillingGoldReport,nonGstPurchaseBillingSilverReport,purchaseCustomerReport;
    
    JMenuItem gstGoldStockReport,gstSilverStockReport,nonGstGoldStockReport,nonGstSilverStockReport;
    JMenuItem gstCashReport,nonGstCashReport;
    JMenuItem gstGoldBalanceSheet,nonGstGoldBalanceSheet,gstSilverBalanceSheet,nonGstSilverBalanceSheet;
    //Report Related Menu Items Ends
    
    //Payment Menu Items Starts
    JMenuItem gstRetailGoldPayment,gstRetailSilverPayment,nonGstRetailGoldPayment,nonGstRetailSilverPayment;
    JMenuItem gstWholesaleGoldPayment,gstWholesaleSilverPayment,nonGstGoldWholesalePayment,nonGstSilverWholesalePayment;
    JMenuItem gstGoldPurchasePayment,gstSilverPurchasePayment,nonGstGoldPurchasePayment,nonGstSilverPurchasePayment;
    //Payment Menu Items Ends
    
    //Bank Menu Items Starts
    JMenuItem bankAccount,bankAccountEntry,bankAccountStatement;
    //Bank Menu Items Ends
    
    //Master Menu Starts
    JMenuItem productMaster,backup,licence,licenceListView,user,userList,goldOrnamentMaster,silverOrnamentMaster,ornamentList;
    //Master Menu Ends
    public JPanel getPanel(String licenceType,String userType){
    	this.licenceType = licenceType;
    	this.userType = userType;
        initcomponent();
        constructMenu();
        return panel;
    }
    
    private void initcomponent() {
    	try{
    		panel=new JPanel(new MigLayout());
    		MyPanel.setBackground(panel);
    		
    		menuBar =new JMenuBar();  
    	    retailBilling = new JMenu();    	    
    	    wholesaleBilling = new JMenu();
    	    purchaseBilling = new JMenu();
    	    reports = new JMenu();
    	    payment = new JMenu();
    	    bank = new JMenu();
    	    master = new JMenu();
    	    
    	  //Billing Related Menu Items Starts
    	    gstRetailBillGold=new JMenuItem();
    	    gstRetailBillSilver=new JMenuItem();
    	    nonGstRetailBillGold=new JMenuItem();
    	    nonGstRetailBillSilver=new JMenuItem();
    	    retailCustomer=new JMenuItem();
    	    
    	    gstWholesaleBillingGold=new JMenuItem();
    	    gstWholesaleBillingSilver=new JMenuItem();
    	    nonGstWholesaleBillingGold=new JMenuItem();
    	    nonGstWholesaleBillingSilver=new JMenuItem();
    	    wholesaleCustomer=new JMenuItem();
    	    
    	    gstPurchaseBillingGold=new JMenuItem();
    	    gstPurchaseBillingSilver=new JMenuItem();
    	    nonGstPurchaseBillingGold=new JMenuItem();
    	    nonGstPurchaseBillingSilver=new JMenuItem();
    	    purchaseCustomer=new JMenuItem();
    	    
    	    //Billing Related Menu Items Ends
    	    
    	    //Report Related Menu Items Starts
    	    gstRetailBillGoldReport=new JMenuItem();
    	    gstRetailBillSilverReport=new JMenuItem();
    	    nonGstRetailBillGoldReport=new JMenuItem();
    	    nonGstRetailBillSilverReport=new JMenuItem();
    	    retailCustomerReport=new JMenuItem();
    	    
    	    gstWholesaleBillingGoldReport=new JMenuItem();
    	    gstWholesaleBillingSilverReport=new JMenuItem();
    	    nonGstWholesaleBillingGoldReport=new JMenuItem();
    	    nonGstWholesaleBillingSilverReport=new JMenuItem();
    	    wholesaleCustomerReport=new JMenuItem();
    	    
    	    gstPurchaseBillingGoldReport=new JMenuItem();
    	    gstPurchaseBillingSilverReport=new JMenuItem();
    	    nonGstPurchaseBillingGoldReport=new JMenuItem();
    	    nonGstPurchaseBillingSilverReport=new JMenuItem();
    	    purchaseCustomerReport=new JMenuItem();
    	    
    	    
    	    gstGoldStockReport=new JMenuItem();
    	    gstSilverStockReport=new JMenuItem();
    	    nonGstGoldStockReport=new JMenuItem();
    	    nonGstSilverStockReport=new JMenuItem();
    	    
    	    gstCashReport=new JMenuItem();
    	    nonGstCashReport=new JMenuItem();
    	    
    	    gstGoldBalanceSheet=new JMenuItem();
    	    nonGstGoldBalanceSheet=new JMenuItem();
    	    gstSilverBalanceSheet=new JMenuItem();
    	    nonGstSilverBalanceSheet=new JMenuItem();
    	    
    	    //Report Related Menu Items Ends
    	    
    	    //Payment Menu Items Starts
    	    gstRetailGoldPayment=new JMenuItem();
    	    gstRetailSilverPayment=new JMenuItem();
    	    nonGstRetailGoldPayment=new JMenuItem();
    	    nonGstRetailSilverPayment=new JMenuItem();
    	    
    	    gstWholesaleGoldPayment=new JMenuItem();
    	    gstWholesaleSilverPayment=new JMenuItem();
    	    nonGstGoldWholesalePayment=new JMenuItem();
    	    nonGstSilverWholesalePayment=new JMenuItem();
    	    
    	    gstGoldPurchasePayment=new JMenuItem();
    	    gstSilverPurchasePayment=new JMenuItem();
    	    nonGstGoldPurchasePayment=new JMenuItem();
    	    nonGstSilverPurchasePayment=new JMenuItem();
    	    
    	    //Payment Menu Items Ends
    	    
    	    //Bank Menu Items Starts
    	    bankAccount=new JMenuItem();
    	    bankAccountEntry=new JMenuItem();
    	    bankAccountStatement=new JMenuItem();
    	    
    	    //Bank Menu Items Ends
    	    
    	    //Master Menu Starts
    	    productMaster=new JMenuItem();
    	    backup=new JMenuItem();
    	    licence=new JMenuItem();
    	    licenceListView = new JMenuItem();
    	    user = new JMenuItem();
    	    userList = new JMenuItem();
    	    goldOrnamentMaster = new JMenuItem();
    	    silverOrnamentMaster = new JMenuItem();
    	    ornamentList = new JMenuItem();
    	    //Master Menu Ends
    	    
    	    gstRetailBillGold.addActionListener(this);
    	    gstRetailBillSilver.addActionListener(this);
    	    nonGstRetailBillGold.addActionListener(this);
    	    nonGstRetailBillSilver.addActionListener(this);
    	    retailCustomer.addActionListener(this);
    	    gstWholesaleBillingGold.addActionListener(this);
    	    gstWholesaleBillingSilver.addActionListener(this);
    	    nonGstWholesaleBillingGold.addActionListener(this);
    	    nonGstWholesaleBillingSilver.addActionListener(this);
    	    wholesaleCustomer.addActionListener(this);
    	    gstPurchaseBillingGold.addActionListener(this);
    	    gstPurchaseBillingSilver.addActionListener(this);
    	    nonGstPurchaseBillingGold.addActionListener(this);
    	    nonGstPurchaseBillingSilver.addActionListener(this);
    	    purchaseCustomer.addActionListener(this);
    	    gstRetailBillGoldReport.addActionListener(this);
    	    gstRetailBillSilverReport.addActionListener(this);
    	    nonGstRetailBillGoldReport.addActionListener(this);
    	    nonGstRetailBillSilverReport.addActionListener(this);
    	    retailCustomerReport.addActionListener(this);
    	    gstWholesaleBillingGoldReport.addActionListener(this);
    	    gstWholesaleBillingSilverReport.addActionListener(this);
    	    nonGstWholesaleBillingGoldReport.addActionListener(this);
    	    nonGstWholesaleBillingSilverReport.addActionListener(this);
    	    wholesaleCustomerReport.addActionListener(this);
    	    gstPurchaseBillingGoldReport.addActionListener(this);
    	    gstPurchaseBillingSilverReport.addActionListener(this);
    	    nonGstPurchaseBillingGoldReport.addActionListener(this);
    	    nonGstPurchaseBillingSilverReport.addActionListener(this);
    	    purchaseCustomerReport.addActionListener(this);
    	    gstGoldStockReport.addActionListener(this);
    	    gstSilverStockReport.addActionListener(this);
    	    nonGstGoldStockReport.addActionListener(this);
    	    nonGstSilverStockReport.addActionListener(this);
    	    gstCashReport.addActionListener(this);
    	    nonGstCashReport.addActionListener(this);
    	    gstGoldBalanceSheet.addActionListener(this);
    	    nonGstGoldBalanceSheet.addActionListener(this);
    	    gstSilverBalanceSheet.addActionListener(this);
    	    nonGstSilverBalanceSheet.addActionListener(this);
    	    gstRetailGoldPayment.addActionListener(this);
    	    gstRetailSilverPayment.addActionListener(this);
    	    nonGstRetailGoldPayment.addActionListener(this);
    	    nonGstRetailSilverPayment.addActionListener(this);
    	    gstWholesaleGoldPayment.addActionListener(this);
    	    gstWholesaleSilverPayment.addActionListener(this);
    	    nonGstGoldWholesalePayment.addActionListener(this);
    	    nonGstSilverWholesalePayment.addActionListener(this);
    	    gstGoldPurchasePayment.addActionListener(this);
    	    gstSilverPurchasePayment.addActionListener(this);
    	    nonGstGoldPurchasePayment.addActionListener(this);
    	    nonGstSilverPurchasePayment.addActionListener(this);
    	    bankAccount.addActionListener(this);
    	    bankAccountEntry.addActionListener(this);
    	    bankAccountStatement.addActionListener(this);
    	    productMaster.addActionListener(this);
    	    backup.addActionListener(this);
    	    licence.addActionListener(this);
    	    licenceListView.addActionListener(this);
    	    user.addActionListener(this);
    	    userList.addActionListener(this);
    	    goldOrnamentMaster.addActionListener(this);
    	    silverOrnamentMaster.addActionListener(this);
    	    ornamentList.addActionListener(this);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructMenu(){
    	try{
    		if(licenceType.equalsIgnoreCase(ConstantUtils.DEFAULT) && userType.equalsIgnoreCase(ConstantUtils.DEFAULT)){
    			constructDefaultMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_SILVER_WHOLESALE) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_ADMIN)){
    			constructSilverAdminMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_SILVER_WHOLESALE) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_GST)){
    			constructSilverGSTMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_SILVER_WHOLESALE) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_NON_GST)){
    			constructSilverNONGSTMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_GOLD_WHOLESALE) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_ADMIN)){
    			constructGoldAdminMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_GOLD_WHOLESALE) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_GST)){
    			constructGoldGSTMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_GOLD_WHOLESALE) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_NON_GST)){
    			constructGoldNONGSTMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_JEWELLERY) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_ADMIN)){
    			constructJewelleryAdminMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_JEWELLERY) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_GST)){
    			constructJewelleryGSTMenu();
    		}else if(licenceType.equalsIgnoreCase(ConstantUtils.LICENCE_TYPE_JEWELLERY) && userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_NON_GST)){
    			constructJewelleryNONGSTMenu();
    		}
    		if(!licenceType.equalsIgnoreCase(ConstantUtils.DEFAULT) && !userType.equalsIgnoreCase(ConstantUtils.DEFAULT)){
    			panel.add(menuBar,"pushx,growx,wrap");
    		}
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    private void constructDefaultMenu(){
    	try{
    		panel.add(new MyLabel("Welcome"),"center,pushx,wrap,top");
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

    private void constructSilverAdminMenu(){
    	try{
    		wholesaleBilling.setText("Sales");
			purchaseBilling.setText("Purchase");
			reports.setText("Reports");
			payment.setText("Payment");
			bank.setText("Bank");
			master.setText("Master");
			
			//Sales Starts 
			gstWholesaleBillingSilver.setText("GST Billing");
			nonGstWholesaleBillingSilver.setText("NON GST Billing");
			wholesaleCustomer.setText("Customer");
			
			wholesaleBilling.add(gstWholesaleBillingSilver);
			wholesaleBilling.add(nonGstWholesaleBillingSilver);
			wholesaleBilling.add(wholesaleCustomer);
			//Sales Ends
			
			//purchase Starts
			gstPurchaseBillingSilver.setText("GST Purchase");
			nonGstPurchaseBillingSilver.setText("NON GST Purchase");
			purchaseCustomer.setText("Supplier");
			
			purchaseBilling.add(gstPurchaseBillingSilver);
			purchaseBilling.add(nonGstPurchaseBillingSilver);
			purchaseBilling.add(purchaseCustomer);
			//Purchase Ends
			
			//Payment Starts
			gstWholesaleSilverPayment.setText("GST Sales Payment");
			nonGstSilverWholesalePayment.setText("NON GST Sales Payments");
			gstSilverPurchasePayment.setText("GST Purchase Payment");
			nonGstSilverPurchasePayment.setText("NON GST Purchase Payment");
			
			payment.add(gstWholesaleSilverPayment);
			payment.add(nonGstSilverWholesalePayment);
			payment.add(gstSilverPurchasePayment);
			payment.add(nonGstSilverPurchasePayment);
			//Payment Ends
			
			//Reports Starts
			gstWholesaleBillingSilverReport.setText("GST Sales Report");
			nonGstWholesaleBillingSilverReport.setText("NONGST Sales Report");
			gstPurchaseBillingSilverReport.setText("GST Purchase Report");
			nonGstPurchaseBillingSilverReport.setText("NON GST Purchase Report");
			gstSilverStockReport.setText("GST Stock Report");
			
			
			
			reports.add(gstWholesaleBillingSilverReport);
			reports.add(nonGstWholesaleBillingSilverReport);
			reports.add(gstPurchaseBillingSilverReport);
			reports.add(nonGstPurchaseBillingSilverReport);
			//Reports Ends
			
			//Bank Starts
			bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
			//Bank Ends
		    
		    //Master Starts
		    //productMaster.setText("Ornament");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    silverOrnamentMaster.setText("Silver Ornament");
		    ornamentList.setText("Ornament Report");
		    
		    //master.add(productMaster);
		    master.add(silverOrnamentMaster);
		    master.add(ornamentList);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    //Master Ends
		    
			//Menu Starts
			menuBar.add(wholesaleBilling);
			menuBar.add(purchaseBilling);
			menuBar.add(reports);
			menuBar.add(payment);
			menuBar.add(bank);
			menuBar.add(master);
			//Menu Ends
			
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructSilverGSTMenu(){
    	try{
    		wholesaleBilling = new JMenu("Billing");
			purchaseBilling = new JMenu("Purchase");
			reports = new JMenu("Reports");
			payment = new JMenu("Payment");
			bank = new JMenu("Bank");
			master = new JMenu("Master");
			
			//Billing starts
			gstWholesaleBillingSilver.setText("Sales Bill");
			wholesaleCustomer.setText("Customer");
			
			//Billing Ends
			
			//Purchase Start
		    gstPurchaseBillingSilver.setText("Purchase Bill");    		    
		    purchaseCustomer.setText("Supplier");    		    
		    
		    //Purchase Ends
		    
		    //Report Start
		    gstWholesaleBillingSilverReport.setText("Sales Report");  
		    gstPurchaseBillingSilverReport.setText("Purchase Report");
		    gstSilverStockReport.setText("Stock Report");    		    
		    gstCashReport.setText("Cash Report");
		    gstSilverBalanceSheet.setText("Balance Sheet");
		    
		    reports.add(gstWholesaleBillingSilverReport);
		    reports.add(gstPurchaseBillingSilverReport);
		    reports.add(gstSilverStockReport);
		    reports.add(gstCashReport);
		    reports.add(gstSilverBalanceSheet);
		    
		    //Report Ends
		    
		    //Payment Starts
		    gstWholesaleSilverPayment.setText("Sales Payment");    		    
		    
		    gstSilverPurchasePayment.setText("Purchase Payment");    		    
		    
		    //Payment Ends
		    
		    //Bank Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    
		    //Bank Ends
		    
		    //Master Starts
		    productMaster.setText("Ornament");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    master.add(productMaster);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    //Master Ends
		    
		    
		    menuBar.add(wholesaleCustomer);
			menuBar.add(gstWholesaleBillingSilver);
			menuBar.add(gstWholesaleSilverPayment);
			
			menuBar.add(purchaseCustomer);
			menuBar.add(gstPurchaseBillingSilver);
			menuBar.add(gstSilverPurchasePayment);
		    menuBar.add(reports);    		    
		    menuBar.add(bank);
		    menuBar.add(master);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructSilverNONGSTMenu(){
    	try{
    		wholesaleBilling = new JMenu("Billing");
			purchaseBilling = new JMenu("Purchase");
			reports = new JMenu("Reports");
			payment = new JMenu("Payment");
			bank = new JMenu("Bank");
			master = new JMenu("Master");
			
			
			//Billing starts
			nonGstWholesaleBillingSilver.setText("Rough Estimate");
			wholesaleCustomer.setText("Customer");
			
			//Billing Ends
			
			//Purchase Start    		        		    
		    nonGstPurchaseBillingSilver.setText("Rough Estimate Purchase");    		    
		    purchaseCustomer.setText("Supplier");
		    
		    //Purchase Ends
		    
		    //Report Start
		    nonGstWholesaleBillingSilverReport.setText("Rough Estimate Report");    		    
		    nonGstPurchaseBillingSilverReport.setText("Rough Estimate Purchase Report");   		        		    
		    nonGstSilverStockReport.setText("Rough Stock Report");    		    
		    nonGstCashReport.setText("Rough Cash Report");    		    
		    nonGstSilverBalanceSheet.setText("Rough Balance Sheet");
		    
		    reports.add(nonGstWholesaleBillingSilverReport);
		    reports.add(nonGstPurchaseBillingSilverReport);
		    reports.add(nonGstSilverStockReport);
		    reports.add(nonGstCashReport);
		    reports.add(nonGstSilverBalanceSheet);
		    
		    //Report Ends
		    
		    //Payment Starts
		    nonGstSilverWholesalePayment.setText("Rough Payment");
		    
		    nonGstSilverPurchasePayment.setText("Rough Purchase Payment");
		    
		    //Payment Ends
		    
		    //Bank Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    
		    //Bank Ends
		    
		    //Master Starts
		    productMaster.setText("Ornament");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    master.add(productMaster);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    //Master Ends
		    
		    
		    menuBar.add(wholesaleCustomer);
		    menuBar.add(nonGstWholesaleBillingSilver);
		    menuBar.add(nonGstSilverWholesalePayment);    		    
		    menuBar.add(purchaseCustomer);
		    menuBar.add(nonGstPurchaseBillingSilver);    		        		    
		    menuBar.add(nonGstSilverPurchasePayment);
		    menuBar.add(reports);    		    
		    menuBar.add(master);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructGoldAdminMenu(){
    	try{
    		wholesaleBilling.setText("Billing");
			purchaseBilling.setText("Purchase");
			reports.setText("Reports");
			payment.setText("Payment");
			bank.setText("Bank");
			master.setText("Master");   			
			
			//Billing starts
			gstWholesaleBillingGold.setText("Sales Bill");
			nonGstWholesaleBillingGold.setText("Rough Estimate");
			wholesaleCustomer.setText("Customer");
			
			wholesaleBilling.add(gstWholesaleBillingGold);
			wholesaleBilling.add(nonGstWholesaleBillingGold);
			wholesaleBilling.add(wholesaleCustomer);
			
			//Billing Ends
			
			//Purchase Start
		    gstPurchaseBillingGold.setText("Purchase Bill");    		    
		    nonGstPurchaseBillingGold.setText("Rough Estimate Purchase");    		    
		    purchaseCustomer.setText("Supplier");    		    
		    
		    purchaseBilling.add(gstPurchaseBillingGold);
		    purchaseBilling.add(nonGstPurchaseBillingGold);
		    purchaseBilling.add(purchaseCustomer);
		    
		    //Purchase Ends
		    
		    //Report Start
		    gstWholesaleBillingGoldReport.setText("Sales Report");    		    
		    nonGstWholesaleBillingGoldReport.setText("Rough Estimate Report");
		    wholesaleCustomerReport.setText("Customer List");
		    
		    gstPurchaseBillingGoldReport.setText("Purchase Report");    		    
		    nonGstPurchaseBillingGoldReport.setText("Rough Estimate Purchase Report");    		    
		    purchaseCustomerReport.setText("Supplier List");
		    
		    gstGoldStockReport.setText("Stock Report");    		    
		    nonGstGoldStockReport.setText("Rough Stock Report");
		    
		    gstCashReport.setText("Cash Report");
		    nonGstCashReport.setText("Rough Cash Report");
		    
		    gstGoldBalanceSheet.setText("Balance Sheet");
		    nonGstGoldBalanceSheet.setText("Rough Balance Sheet");
		    
		    reports.add(gstWholesaleBillingGoldReport);
		    reports.add(nonGstWholesaleBillingGoldReport);
		    //reports.add(wholesaleCustomerReport);
		    reports.add(gstPurchaseBillingGoldReport);
		    reports.add(nonGstPurchaseBillingGoldReport);
		    //reports.add(purchaseCustomerReport);
		    reports.add(gstGoldStockReport);
		    reports.add(nonGstGoldStockReport);
		    reports.add(gstCashReport);
		    reports.add(nonGstCashReport);
		    reports.add(gstGoldBalanceSheet);
		    reports.add(nonGstGoldBalanceSheet);
		    
		    //Report Ends
		    
		    //Payment Starts
		    gstWholesaleGoldPayment.setText("Sales Payment");
		    nonGstGoldWholesalePayment.setText("Rough Payment");
		    
		    gstGoldPurchasePayment.setText("Purchase Payment");
		    nonGstGoldPurchasePayment.setText("Rough Purchase Payment");
		    
		    payment.add(gstWholesaleGoldPayment);
		    payment.add(nonGstGoldWholesalePayment);
		    payment.add(gstGoldPurchasePayment);
		    payment.add(nonGstGoldPurchasePayment);
		    
		    //Payment Ends
		    
		    //Bank Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    
		    //Bank Ends
		    
		    //Master Starts
		    //productMaster.setText("Product");
		    goldOrnamentMaster.setText("Gold Ornament");
		    ornamentList.setText("Ornament Report");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    productMaster.setText("Ornament");
		    
		    //master.add(productMaster);
		    master.add(goldOrnamentMaster);
		    master.add(ornamentList);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    //Master Ends
		    
		    
		    menuBar.add(wholesaleBilling);
		    menuBar.add(purchaseBilling);
		    menuBar.add(reports);
		    menuBar.add(payment);
		    menuBar.add(bank);
		    menuBar.add(master);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructGoldGSTMenu(){
    	try{
    		wholesaleBilling = new JMenu("Billing");
			purchaseBilling = new JMenu("Purchase");
			reports = new JMenu("Reports");
			payment = new JMenu("Payment");
			bank = new JMenu("Bank");
			master = new JMenu("Master");
			
			//Billing starts
			gstWholesaleBillingGold.setText("Sales Bill");
			wholesaleCustomer.setText("Customer");
			
			//Billing Ends
			
			//Purchase Start
		    gstPurchaseBillingGold.setText("Purchase Bill");    		    
		    purchaseCustomer.setText("Supplier");    		    
		    
		    //Purchase Ends
		    
		    //Report Start
		    gstWholesaleBillingGoldReport.setText("Sales Report");  
		    gstPurchaseBillingGoldReport.setText("Purchase Report");
		    gstGoldStockReport.setText("Stock Report");    		    
		    gstCashReport.setText("Cash Report");
		    gstGoldBalanceSheet.setText("Balance Sheet");
		    
		    reports.add(gstWholesaleBillingGoldReport);
		    reports.add(gstPurchaseBillingGoldReport);
		    reports.add(gstGoldStockReport);
		    reports.add(gstCashReport);
		    reports.add(gstGoldBalanceSheet);
		    
		    //Report Ends
		    
		    //Payment Starts
		    gstWholesaleGoldPayment.setText("Sales Payment");    		    
		    
		    gstGoldPurchasePayment.setText("Purchase Payment");    		    
		    
		    //Payment Ends
		    
		    //Bank Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    
		    //Bank Ends
		    
		    //Master Starts
		    productMaster.setText("Ornament");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    master.add(productMaster);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    //Master Ends
		    
		    
		    menuBar.add(wholesaleCustomer);
			menuBar.add(gstWholesaleBillingGold);
			//menuBar.add(gstWholesaleBillingGoldReport);
			menuBar.add(gstWholesaleGoldPayment);
			
			menuBar.add(purchaseCustomer);
			menuBar.add(gstPurchaseBillingGold);
			//menuBar.add(gstPurchaseBillingGoldReport);
			menuBar.add(gstGoldPurchasePayment);
		    menuBar.add(reports);    		    
		    menuBar.add(bank);
		    menuBar.add(master);
    		
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructGoldNONGSTMenu(){
    	try{
    		wholesaleBilling = new JMenu("Billing");
			purchaseBilling = new JMenu("Purchase");
			reports = new JMenu("Reports");
			payment = new JMenu("Payment");
			bank = new JMenu("Bank");
			master = new JMenu("Master");
			
			
			//Billing starts
			nonGstWholesaleBillingGold.setText("Rough Estimate");
			wholesaleCustomer.setText("Customer");
			
			//Billing Ends
			
			//Purchase Start    		        		    
		    nonGstPurchaseBillingGold.setText("Rough Estimate Purchase");    		    
		    purchaseCustomer.setText("Supplier");
		    
		    //Purchase Ends
		    
		    //Report Start
		    nonGstWholesaleBillingGoldReport.setText("Rough Estimate Report");    		    
		    nonGstPurchaseBillingGoldReport.setText("Rough Estimate Purchase Report");   		        		    
		    nonGstGoldStockReport.setText("Rough Stock Report");    		    
		    nonGstCashReport.setText("Rough Cash Report");    		    
		    nonGstGoldBalanceSheet.setText("Rough Balance Sheet");
		    
		    reports.add(nonGstWholesaleBillingGoldReport);
		    reports.add(nonGstPurchaseBillingGoldReport);
		    reports.add(nonGstGoldStockReport);
		    reports.add(nonGstCashReport);
		    reports.add(nonGstGoldBalanceSheet);
		    
		    //Report Ends
		    
		    //Payment Starts
		    nonGstGoldWholesalePayment.setText("Rough Payment");
		    
		    nonGstGoldPurchasePayment.setText("Rough Purchase Payment");
		    
		    //Payment Ends
		    
		    //Bank Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    
		    //Bank Ends
		    
		    //Master Starts
		    productMaster.setText("Ornament");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    master.add(productMaster);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    //Master Ends
		    
		    
		    menuBar.add(wholesaleCustomer);
		    menuBar.add(nonGstWholesaleBillingGold);
		    menuBar.add(nonGstGoldWholesalePayment);    		    
		    menuBar.add(purchaseCustomer);
		    menuBar.add(nonGstPurchaseBillingGold);    		        		    
		    menuBar.add(nonGstGoldPurchasePayment);
		    menuBar.add(reports);    		    
		    //menuBar.add(bank);
		    menuBar.add(master);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructJewelleryAdminMenu(){
    	try{
    		retailBilling.setText("Retail");
			purchaseBilling.setText("Purchase");
			reports.setText("Reports");
			payment.setText("Payment");
			bank.setText("Bank");
			master.setText("Master");
			
		    gstRetailBillGold.setText("Gold Billing");
		    gstRetailBillSilver.setText("Silver Billing");
		    nonGstRetailBillGold.setText("Gold Rough Estimate");
		    nonGstRetailBillSilver.setText("Silver Rough Estimate");
		    retailCustomer.setText("Customer");
		    
		    retailBilling.add(gstRetailBillGold);
		    retailBilling.add(gstRetailBillSilver);
		    retailBilling.add(nonGstRetailBillGold);
		    retailBilling.add(nonGstRetailBillSilver);
		    retailBilling.add(retailCustomer);
		    menuBar.add(retailBilling);
		    
		    gstPurchaseBillingGold.setText("Gold Purchase");
		    gstPurchaseBillingSilver.setText("Silver Purchase");
		    nonGstPurchaseBillingGold.setText("Gold Rough Estimate");
		    nonGstPurchaseBillingSilver.setText("Silver Rough Estimate");
		    purchaseCustomer.setText("Supplier");
		    
		    purchaseBilling.add(gstPurchaseBillingGold);
		    purchaseBilling.add(gstPurchaseBillingSilver);
		    purchaseBilling.add(nonGstPurchaseBillingGold);
		    purchaseBilling.add(nonGstPurchaseBillingSilver);
		    purchaseBilling.add(purchaseCustomer);
		    menuBar.add(purchaseBilling);
		    
		    
		    gstRetailBillGoldReport.setText("Gold Billing Report");
		    gstRetailBillSilverReport.setText("Silver Billing Report");
		    nonGstRetailBillGoldReport.setText("Gold Rough Estimate Report");
		    nonGstRetailBillSilverReport.setText("Silver Rough Estimate Report");
		    gstPurchaseBillingGoldReport.setText("Gold Purchase Report");
		    gstPurchaseBillingSilverReport.setText("Silver Purchase Report");
		    nonGstPurchaseBillingGoldReport.setText("Gold Rough Estimate Purchase Report");
		    nonGstPurchaseBillingSilverReport.setText("Silver Rough Estimate PurchaseReport");
		    
		    gstGoldStockReport.setText("Gold Stock");
		    gstSilverStockReport.setText("Silver Stock");
		    nonGstGoldStockReport.setText("Gold Rough Stock");
		    nonGstSilverStockReport.setText("Silver Rough Stock");
		    
		    gstCashReport.setText("Cash Report");
		    nonGstCashReport.setText("Rough Cash Report");
		    
		    gstGoldBalanceSheet.setText("Gold Balance Sheet");
		    gstSilverBalanceSheet.setText("Silver Balance Sheet");
		    nonGstGoldBalanceSheet.setText("Gold Rough Balance Sheet");
		    nonGstSilverBalanceSheet.setText("Silver Rough Balance Sheet");
		    
		    reports.add(gstRetailBillGoldReport);
		    reports.add(gstRetailBillSilverReport);
		    reports.add(nonGstRetailBillGoldReport);
		    reports.add(nonGstRetailBillSilverReport);
		    reports.add(gstPurchaseBillingGoldReport);
		    reports.add(gstPurchaseBillingSilverReport);
		    reports.add(nonGstPurchaseBillingGoldReport);
		    reports.add(nonGstPurchaseBillingSilverReport);
		    reports.add(gstGoldStockReport);
		    reports.add(gstSilverStockReport);
		    reports.add(nonGstGoldStockReport);
		    reports.add(nonGstSilverStockReport);
		    reports.add(gstCashReport);
		    reports.add(nonGstCashReport);
		    reports.add(gstGoldBalanceSheet);
		    reports.add(gstSilverBalanceSheet);
		    reports.add(nonGstGoldBalanceSheet);
		    reports.add(nonGstSilverBalanceSheet);
		    
		    menuBar.add(reports);
		    //Report Related Menu Items Ends
		    
		    //Payment Menu Items Starts
		    gstRetailGoldPayment.setText("Gold Sales Payment");
		    gstRetailSilverPayment.setText("Silver Sales Payment");
		    nonGstRetailGoldPayment.setText("Gold Rough Payment");
		    nonGstRetailSilverPayment.setText("Silver Rough Payment");
		    gstGoldPurchasePayment.setText("Gold Purchase Payment");
		    gstSilverPurchasePayment.setText("Silver Purchase Payment");
		    nonGstGoldPurchasePayment.setText("Gold Purchase Rough Payment");
		    nonGstSilverPurchasePayment.setText("Silver Purchase Rough Payment");
		    payment.add(gstRetailGoldPayment);
		    payment.add(gstRetailSilverPayment);
		    payment.add(nonGstRetailGoldPayment);
		    payment.add(nonGstRetailSilverPayment);
		    payment.add(gstGoldPurchasePayment);
		    payment.add(gstSilverPurchasePayment);
		    payment.add(nonGstGoldPurchasePayment);
		    payment.add(nonGstSilverPurchasePayment);
		    menuBar.add(payment);
		    
		    //Payment Menu Items Ends
		    
		    //Bank Menu Items Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    menuBar.add(bank);
		    //Bank Menu Items Ends
		    
		    //Master Menu Starts
		    //JMenuItem productMaster,backup,licence;
		    //productMaster.setText("Ornament");
		    goldOrnamentMaster.setText("Gold Ornament");
		    silverOrnamentMaster.setText("Silver Ornament");
		    ornamentList.setText("Ornament Report");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    //master.add(productMaster);
		    master.add(goldOrnamentMaster);
		    master.add(silverOrnamentMaster);
		    master.add(ornamentList);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    menuBar.add(master);
		    //Master Menu Ends
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructJewelleryGSTMenu(){
    	try{
    		retailBilling.setText("Retail");
			purchaseBilling.setText("Purchase");
			reports.setText("Reports");
			payment.setText("Payment");
			bank.setText("Bank");
			master.setText("Master");
			
		    gstRetailBillGold.setText("Gold Billing");
		    gstRetailBillSilver.setText("Silver Billing");    		    
		    retailCustomer.setText("Customer");    		    
		    
		    menuBar.add(retailCustomer);
		    menuBar.add(gstRetailBillGold);
		    menuBar.add(gstRetailBillSilver);
		    
		    
		    gstPurchaseBillingGold.setText("Gold Purchase");
		    gstPurchaseBillingSilver.setText("Silver Purchase");
		    purchaseCustomer.setText("Supplier");
		    
		    menuBar.add(gstPurchaseBillingGold);
		    menuBar.add(gstPurchaseBillingSilver);
		    menuBar.add(purchaseCustomer);
		    
		    gstRetailBillGoldReport.setText("Gold Billing Report");
		    gstRetailBillSilverReport.setText("Silver Billing Report");
		    gstPurchaseBillingGoldReport.setText("Gold Purchase Report");
		    gstPurchaseBillingSilverReport.setText("Silver Purchase Report");
		    
		    gstGoldStockReport.setText("Gold Stock");
		    gstSilverStockReport.setText("Silver Stock");
		    
		    gstCashReport.setText("Cash Report");
		    
		    gstGoldBalanceSheet.setText("Gold Balance Sheet");
		    gstSilverBalanceSheet.setText("Silver Balance Sheet");
		    
		    reports.add(gstRetailBillGoldReport);
		    reports.add(gstRetailBillSilverReport);
		    reports.add(gstPurchaseBillingGoldReport);
		    reports.add(gstPurchaseBillingSilverReport);
		    reports.add(gstGoldStockReport);
		    reports.add(gstSilverStockReport);
		    reports.add(gstCashReport);
		    reports.add(gstGoldBalanceSheet);
		    reports.add(gstSilverBalanceSheet);
		    
		    menuBar.add(reports);
		    //Report Related Menu Items Ends
		    
		    //Payment Menu Items Starts
		    gstRetailGoldPayment.setText("Gold Sales Payment");
		    gstRetailSilverPayment.setText("Silver Sales Payment");
		    gstGoldPurchasePayment.setText("Gold Purchase Payment");
		    gstSilverPurchasePayment.setText("Silver Purchase Payment");
		    payment.add(gstRetailGoldPayment);
		    payment.add(gstRetailSilverPayment);
		    payment.add(gstGoldPurchasePayment);
		    payment.add(gstSilverPurchasePayment);
		    menuBar.add(payment);
		    
		    //Payment Menu Items Ends
		    
		    //Bank Menu Items Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    menuBar.add(bank);
		    //Bank Menu Items Ends
		    
		    //Master Menu Starts
		    //JMenuItem productMaster,backup,licence;
		    productMaster.setText("Ornament");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    master.add(productMaster);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    menuBar.add(master);
		    //Master Menu Ends
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    private void constructJewelleryNONGSTMenu(){
    	try{
    		retailBilling.setText("Retail");
			purchaseBilling.setText("Purchase");
			reports.setText("Reports");
			payment.setText("Payment");
			bank.setText("Bank");
			master.setText("Master");
			
		    nonGstRetailBillGold.setText("Gold Rough Estimate");
		    nonGstRetailBillSilver.setText("Silver Rough Estimate");
		    retailCustomer.setText("Customer");
		    
		    menuBar.add(nonGstRetailBillGold);
		    menuBar.add(nonGstRetailBillSilver);
		    menuBar.add(retailCustomer);
		    
		    nonGstPurchaseBillingGold.setText("Gold Rough Estimate");
		    nonGstPurchaseBillingSilver.setText("Silver Rough Estimate");
		    purchaseCustomer.setText("Supplier");
		    
		    menuBar.add(nonGstPurchaseBillingGold);
		    menuBar.add(nonGstPurchaseBillingSilver);
		    menuBar.add(purchaseCustomer);
		    
		    
		    
		    nonGstRetailBillGoldReport.setText("Gold Rough Estimate Report");
		    nonGstRetailBillSilverReport.setText("Silver Rough Estimate Report");
		    nonGstPurchaseBillingGoldReport.setText("Gold Rough Estimate Purchase Report");
		    nonGstPurchaseBillingSilverReport.setText("Silver Rough Estimate PurchaseReport");
		    
		    nonGstGoldStockReport.setText("Gold Rough Stock");
		    nonGstSilverStockReport.setText("Silver Rough Stock");
		    
		    nonGstCashReport.setText("Rough Cash Report");
		    
		    nonGstGoldBalanceSheet.setText("Gold Rough Balance Sheet");
		    nonGstSilverBalanceSheet.setText("Silver Rough Balance Sheet");
		    
		    reports.add(nonGstRetailBillGoldReport);
		    reports.add(nonGstRetailBillSilverReport);
		    reports.add(nonGstPurchaseBillingGoldReport);
		    reports.add(nonGstPurchaseBillingSilverReport);
		    reports.add(nonGstGoldStockReport);
		    reports.add(nonGstSilverStockReport);
		    reports.add(nonGstCashReport);
		    reports.add(nonGstGoldBalanceSheet);
		    reports.add(nonGstSilverBalanceSheet);
		    
		    menuBar.add(reports);
		    //Report Related Menu Items Ends
		    
		    //Payment Menu Items Starts
		    nonGstRetailGoldPayment.setText("Gold Rough Payment");
		    nonGstRetailSilverPayment.setText("Silver Rough Payment");
		    nonGstGoldPurchasePayment.setText("Gold Purchase Rough Payment");
		    nonGstSilverPurchasePayment.setText("Silver Purchase Rough Payment");
		    
		    payment.add(nonGstRetailGoldPayment);
		    payment.add(nonGstRetailSilverPayment);
		    payment.add(nonGstGoldPurchasePayment);
		    payment.add(nonGstSilverPurchasePayment);
		    menuBar.add(payment);
		    
		    //Payment Menu Items Ends
		    
		    //Bank Menu Items Starts
		    bankAccount.setText("Account");
		    bankAccountEntry.setText("Account Entry");
		    bankAccountStatement.setText("Statement");
		    bank.add(bankAccount);
		    bank.add(bankAccountEntry);
		    bank.add(bankAccountStatement);
		    //menuBar.add(bank);
		    //Bank Menu Items Ends
		    
		    //Master Menu Starts
		    //JMenuItem productMaster,backup,licence;
		    productMaster.setText("Ornament");
		    backup.setText("Backup");
		    licence.setText("Licence");
		    licenceListView.setText("Licence View");
		    user.setText("User");
		    userList.setText("User Report");
		    
		    master.add(productMaster);
		    master.add(backup);
		    master.add(licence);
		    master.add(licenceListView);
		    master.add(user);
		    master.add(userList);
		    menuBar.add(master);
		    //Master Menu Ends
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		onClickEvent(e.getSource());
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		onClickEvent(e.getSource());
	}
	
	public void onClickEvent(Object evt){
		try{
			if(evt ==  licence){
				AppController.getInstance().addLicenceFormPage(ConstantUtils.MENU, 0,Session.user.getUserType().getUserType());
			}else if(evt ==  user){
				AppController.getInstance().addUserFormPage(ConstantUtils.MENU, 0,Session.user.getUserType().getUserType());
			}else if(evt == licenceListView){
				AppController.getInstance().addLicenceReportPage(Session.user.getUserType().getUserType());
			}else if(evt == userList){
				AppController.getInstance().addUserReportPage(Session.user.getUserType().getUserType());
			}else if(evt == goldOrnamentMaster){
				AppController.getInstance().addOrnamentFormPage(ConstantUtils.GOLD, 0, ConstantUtils.MENU, Session.user.getUserType().getUserType(), Session.licence.getLicenceId());
			}else if(evt == silverOrnamentMaster){
				AppController.getInstance().addOrnamentFormPage(ConstantUtils.SILVER, 0, ConstantUtils.MENU, Session.user.getUserType().getUserType(), Session.licence.getLicenceId());
			}else if(evt == ornamentList){
				AppController.getInstance().addOrnamentReportPage(Session.user.getUserType().getUserType(),ConstantUtils.MENU);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
