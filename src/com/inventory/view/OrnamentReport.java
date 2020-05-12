package com.inventory.view;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

import com.inventory.common.FilterJtable;
import com.inventory.components.EvenOddTableRenderer;
import com.inventory.components.MyButton;
import com.inventory.components.MyLabel;
import com.inventory.components.MyPanel;
import com.inventory.components.MyTextField;
import com.inventory.controller.AppController;
import com.inventory.controller.MasterController;
import com.inventory.dto.LicenceOpeningStockDetailsDTO;
import com.inventory.model.LicenceOpeningStockDetails;
import com.inventory.model.Ornament;
import com.inventory.utility.ConstantUtils;
import com.inventory.utility.Session;

public class OrnamentReport  implements ActionListener{
	
	private static OrnamentReport myInstance=null;
	
	private OrnamentReport(){}
	
	public static OrnamentReport getInstance(){
		if(myInstance ==null){
			myInstance = new OrnamentReport();
		}
		
		return myInstance;
	}

	JPanel panel;
	JPanel firstPanel,secondPanel,thirdPanel;
	MyTextField searchTextField = null;
	
	JTable reportTable=null;
    DefaultTableModel reportModel =null;
    JScrollPane scrollPane;
    
    private JPopupMenu popupMenu;
    private JMenuItem editRecord,deleteRecord,addEditStock,removeStock;
    String userType,calledFrom;
    JDialog dialog = null;
    
    MyTextField stockGSTGrams,stockNONGSTGrams;
	MyButton addStock;
	JPanel licenceStockEntryPanel = null;
	
    public JPanel getPanel(String userType,String calledFrom){
    	try{
		this.userType = userType;
		this.calledFrom = calledFrom;
		initComponent();
		if(calledFrom.equalsIgnoreCase(ConstantUtils.MENU)){
			constructOrnamentReport();
			fetchOrnamentList();
		}else if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK) || calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
			constructLicenceOrnamentReport();
			fetchLicenceOrnamentList();
		}
		FilterJtable.setFilterJtable(reportTable, searchTextField);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		return panel;
	}
    
    private void initComponent(){
    	try{
    		panel = new JPanel(new MigLayout());
    		licenceStockEntryPanel = new JPanel(new MigLayout());
    		
			firstPanel = new JPanel(new MigLayout());
			secondPanel = new JPanel(new MigLayout());
			thirdPanel = new JPanel(new MigLayout());
			
			searchTextField = new MyTextField(20);
			
			MyPanel.setBorder("Ornament", panel);
			MyPanel.setBackground(firstPanel);
			MyPanel.setBackground(secondPanel);
			MyPanel.setBackground(thirdPanel);
			
			reportTable = new JTable();
                
			dialog = new JDialog();
			Window parentWindow = SwingUtilities.getWindowAncestor(panel);
			dialog = new JDialog(parentWindow, ModalityType.APPLICATION_MODAL);
			
			stockGSTGrams = new MyTextField(10);
			stockNONGSTGrams = new MyTextField(10);
			addStock = new MyButton("Add Stock");
			
			
            popupMenu = new JPopupMenu();
            editRecord = new JMenuItem();
            deleteRecord = new JMenuItem();
            addEditStock = new JMenuItem();
            removeStock = new JMenuItem();
            
            editRecord.addActionListener(this);
            deleteRecord.addActionListener(this);
            addEditStock.addActionListener(this);
            removeStock.addActionListener(this);
            searchTextField.addActionListener(this);
            addStock.addActionListener(this);
            //FilterJtable.setFilterJtable(reportTable, searchTextField);
            
    	}catch(Exception ex){
    		
    	}
    }
    
    private void constructOrnamentReport(){
    	try{
    		MyPanel.setBorder("Ornament", panel);
    		
    		tableModelling(reportTable);
			editRecord.setText("Edit Ornament");
			deleteRecord.setText("Delete Ornament");
			
			popupMenu.add(editRecord);
			popupMenu.add(deleteRecord);
			
			reportTable.setComponentPopupMenu(popupMenu);
            
            reportTable.setBackground(Color.WHITE);
            scrollPane = new JScrollPane(reportTable);
            Dimension d = reportTable.getPreferredSize();
            int rows=30;
            scrollPane.setPreferredSize(
            new Dimension(d.width,reportTable.getRowHeight()*rows+1));
            secondPanel.add(scrollPane,"span,pushx,growx,wrap");
            
            EvenOddTableRenderer render =new EvenOddTableRenderer();
            reportTable.setDefaultRenderer(Object.class,  render);
            reportTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            firstPanel.add(new MyLabel("Search Ornament"),"push,al right");
            firstPanel.add(searchTextField,"al right, wrap");
            
            
            panel.add(firstPanel,"span,pushx,growx,wrap");
            panel.add(secondPanel,"span,pushx,growx,wrap");
            panel.add(thirdPanel,"span,pushx,growx,wrap");
    	}catch(Exception ex){
    		
    	}
    }
    
    private void constructLicenceOrnamentReport(){
    	try{
    		if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
    			MyPanel.setBorder("Stock Entry -GST", panel);
    		}else if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
    			MyPanel.setBorder("Stock Entry -NONGST", panel);
    		}
    		licenceStockTableModelling(reportTable);
			addEditStock.setText("Add/Edit Stock");
			removeStock.setText("Remove Stock");
			
			popupMenu.add(addEditStock);
			popupMenu.add(removeStock);
			
			reportTable.setComponentPopupMenu(popupMenu);
            
            reportTable.setBackground(Color.WHITE);
            scrollPane = new JScrollPane(reportTable);
            Dimension d = reportTable.getPreferredSize();
            int rows=30;
            scrollPane.setPreferredSize(
            new Dimension(d.width,reportTable.getRowHeight()*rows+1));
            secondPanel.add(scrollPane,"span,pushx,growx,wrap");
            
            EvenOddTableRenderer render =new EvenOddTableRenderer();
            reportTable.setDefaultRenderer(Object.class,  render);
            reportTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            firstPanel.add(new MyLabel("Search Ornament"),"push,al right");
            firstPanel.add(searchTextField,"al right, wrap");
            
            
            panel.add(firstPanel,"span,pushx,growx,wrap");
            panel.add(secondPanel,"span,pushx,growx,wrap");
            panel.add(thirdPanel,"span,pushx,growx,wrap");
    	}catch(Exception ex){
    		
    	}
    }
    
    private void tableModelling(JTable jTable){
		try{
			
			reportModel = new DefaultTableModel() {

				public Class<?> getColumnClass(int column) {
					switch (column) {
					
					case 0:
						return String.class;//Ornament Id
					case 1:
						return String.class;//Ornament Name
					case 2:
						return String.class;//Ornament Code
					case 3:
						return String.class;//GST Percentage        
					default:
						return String.class;
					}
				}
			};
			jTable.setModel(reportModel);
			reportModel.addColumn("ornamentId");
        	reportModel.addColumn("Ornament Name");
        	reportModel.addColumn("Ornament Code");
        	reportModel.addColumn("GST Percentage");

        	jTable.getColumn("ornamentId").setPreferredWidth(0);
        	jTable.getColumn("ornamentId").setMinWidth(0);
        	jTable.getColumn("ornamentId").setMaxWidth(0);
        	
        	if(userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_ADMIN)){
				
			}else if (userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_GST)){
				
			}else if(userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_NON_GST)){
				
	        	
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
    
    private void licenceStockTableModelling(JTable jTable){
		try{
			
			reportModel = new DefaultTableModel() {

				public Class<?> getColumnClass(int column) {
					switch (column) {
					
					case 0:
						return String.class;//Ornament Id
					case 1:
						return String.class;//Licence Opening Stock Id
					case 2:
						return String.class;//Ornament Name
					case 3:
						return String.class;//Ornament Code
					case 4:
						return String.class;//Grams
					default:
						return String.class;
					}
				}
			};
			jTable.setModel(reportModel);
			reportModel.addColumn("ornamentId");
			reportModel.addColumn("licenceOpeningStockId");
        	reportModel.addColumn("Ornament Name");
        	reportModel.addColumn("Ornament Code");
        	//reportModel.addColumn("GST Percentage");
        	reportModel.addColumn("Grams");

        	jTable.getColumn("ornamentId").setPreferredWidth(0);
        	jTable.getColumn("ornamentId").setMinWidth(0);
        	jTable.getColumn("ornamentId").setMaxWidth(0);
        	
        	jTable.getColumn("licenceOpeningStockId").setPreferredWidth(0);
        	jTable.getColumn("licenceOpeningStockId").setMinWidth(0);
        	jTable.getColumn("licenceOpeningStockId").setMaxWidth(0);
        	
        	if(userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_ADMIN)){
				
			}else if (userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_GST)){
				
			}else if(userType.equalsIgnoreCase(ConstantUtils.USER_TYPE_NON_GST)){
				
	        	
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
    private void fetchOrnamentList(){
    	try{
    		int rowCount = reportModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
            	reportModel.removeRow(0);
            }
            
            List<Ornament> ornamentList = null;
            
            ornamentList = MasterController.getInstace().getOrnamentList(Session.licence.getLicenceId());
            String temp;
            
            if(ornamentList!=null && ornamentList.size()>0){
            	for(Ornament data:ornamentList){
            		reportModel.addRow(new Object[]{
            				data.getOrnamentId(),
            				data.getOrnamentName(),
            				data.getOrnamentKeyCode(),
            				data.getGstPercentage()
            		});
            	}
            }
            
            
    	}catch(Exception ex){
			ex.printStackTrace();
		}
    }
    
    private void fetchLicenceOrnamentList(){
    	try{
    		int rowCount = reportModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
            	reportModel.removeRow(0);
            }
            
            List<LicenceOpeningStockDetailsDTO> licenceOrnamentListDTO = null;
            if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
            	licenceOrnamentListDTO = MasterController.getInstace().getLicenceOpeningStockDetailsList(ConstantUtils.GST_ENTRY,Session.licence.getLicenceId());
            }else if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
            	licenceOrnamentListDTO = MasterController.getInstace().getLicenceOpeningStockDetailsList(ConstantUtils.NON_GST_ENTRY,Session.licence.getLicenceId());
            }
            
            if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
            if(licenceOrnamentListDTO!=null && licenceOrnamentListDTO.size()>0){
            	for(LicenceOpeningStockDetailsDTO data:licenceOrnamentListDTO){
            		reportModel.addRow(new Object[]{
            				data.getOrnamentId(),
            				data.getLicenceOpeningStockDetailsId(),
            				data.getOrnamentName(),
            				data.getOrnamentKeyCode(),
            				data.getGstGrams()
            		});
            	}
            }
            }
            if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
                if(licenceOrnamentListDTO!=null && licenceOrnamentListDTO.size()>0){
                	for(LicenceOpeningStockDetailsDTO data:licenceOrnamentListDTO){
                		reportModel.addRow(new Object[]{
                				data.getOrnamentId(),
                				data.getLicenceOpeningStockDetailsId(),
                				data.getOrnamentName(),
                				data.getOrnamentKeyCode(),
                				data.getNonGstGrams()
                		});
                	}
                }
            }
            
    	}catch(Exception ex){
			ex.printStackTrace();
		}
    }

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		onClickEvent(evt.getSource());
		
	}
	
	public void onClickEvent(Object evt){
		try{
			if(evt ==  editRecord || evt ==  deleteRecord || evt == addEditStock || evt == removeStock){
				int selectedRow = reportTable.getSelectedRow();
				int ornamentId=0;
				int stockId=0;
				Double grams=0.0;
				
				if(selectedRow>-1){
					String selectedId = reportModel.getValueAt(selectedRow, 0).toString();
					Integer ornamentIdInCell = (Integer)reportTable.getValueAt(selectedRow, 0);
					
					if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK) ||
							calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)
							){
								if(reportTable.getValueAt(selectedRow, 1)!=null){
									Integer licenceStockIdInCell = (Integer)reportTable.getValueAt(selectedRow, 1);
									stockId = licenceStockIdInCell;
								}
								
								if(reportTable.getValueAt(selectedRow, 4)!=null){
									Double licenceStockGramsInCell = (Double)reportTable.getValueAt(selectedRow, 4);
									grams = licenceStockGramsInCell;
								}
					
					
					}
					//ornamentId = Integer.parseInt(selectedId);
					ornamentId = ornamentIdInCell;
					System.out.println("ornamentId - "+ornamentId);
					System.out.println("licenceStockId - "+stockId);
					
					if(evt ==  editRecord){
						Ornament ornament = MasterController.getInstace().getOrnament(ornamentId);
						if(ornament!=null){
						AppController.getInstance().addOrnamentFormPage(ornament.getMetalId().getMetalCode(), ornamentId, ConstantUtils.ORNAMENT_REPORT, selectedId, Session.licence.getLicenceId());
						}
					}else if(evt ==  deleteRecord){
						deleteOrnament(ornamentId);
					}else if(evt == addEditStock){
						addEditLicenceOpeningStock(ornamentId,stockId,grams);
					}else if(evt == removeStock){
						deleteLicenceStock(stockId);
					}
				}
				
			}else if(evt == addStock){
				addStock();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void deleteOrnament(int ornamentId){
		try{
			int selected = JOptionPane.showConfirmDialog(null, "Are you sure You want to delete Ornament?");
			if(selected==JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Deleted");
				Ornament deleteOrnament = MasterController.getInstace().getOrnament(ornamentId);
				if(deleteOrnament!=null){
					deleteOrnament.setDeletedFlag(ConstantUtils.CONSTANT_Y);
					Integer deletedFlag = MasterController.getInstace().saveOrUpdateOrnament(deleteOrnament);
					if(deletedFlag!=null && deletedFlag>0){
						JOptionPane.showMessageDialog(null, "Ornament Deleted");
						fetchOrnamentList();
					}else{
						JOptionPane.showMessageDialog(null, "Ornament Deletion Failed");
						fetchOrnamentList();
					}
				}
			}else if(selected==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "Not Deleted");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	MyLabel licenceOrnamentName;
	Integer licenecStockOrnamentId,licenceOpeningStockDetailsId;
	private void addEditLicenceOpeningStock(Integer ornamentId,Integer stockId,Double grams){
		try{
			System.out.println("ornamentId - "+ornamentId+",licenceStockId - "+stockId+", grams - "+grams);
			
			//int result = JOptionPane.showConfirmDialog(null, addEditLicenceStockPanel(), "Please Enter Grams", JOptionPane.OK_CANCEL_OPTION);
			//dialog.removeAll();
			//dialog.repaint();
			//dialog.pack();
			licenecStockOrnamentId = 0;
			licenceOpeningStockDetailsId = 0;
			dialog.add(getEditLicenceStockPanel(ornamentId,stockId));
			dialog.setTitle("Licence Stock Window");
			
			dialog.setSize(300, 200);
			
			
			final Toolkit toolkit = Toolkit.getDefaultToolkit();
			final Dimension screenSize = toolkit.getScreenSize();
			final int x = (screenSize.width - dialog.getWidth()) / 2;
			final int y = (screenSize.height - dialog.getHeight()) / 2;
			dialog.setLocation(x, y);
			dialog.setVisible(true);
			
			stockGSTGrams.grabFocus();
			stockNONGSTGrams.grabFocus();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	
	
	private JPanel getEditLicenceStockPanel(Integer licenecStockOrnamentId,Integer licenceOpeningStockDetailsId){
		
		try{
			licenceStockEntryPanel.removeAll();
			
			this.licenecStockOrnamentId= licenecStockOrnamentId;
			this.licenceOpeningStockDetailsId = licenceOpeningStockDetailsId;
			
			licenceOrnamentName = new MyLabel("");
			
			
			stockGSTGrams.setText("");
			stockNONGSTGrams.setText("");
			
			
			if(licenceOpeningStockDetailsId!=null && licenceOpeningStockDetailsId>0){
				LicenceOpeningStockDetails loadLicenceOpeningStockDetailsObj = MasterController.getInstace().getLicenceOpeningStockDetails(licenceOpeningStockDetailsId);
				if(loadLicenceOpeningStockDetailsObj!=null){
					//if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
						if(loadLicenceOpeningStockDetailsObj.getGstGrams()!=null){
							stockGSTGrams.setText(loadLicenceOpeningStockDetailsObj.getGstGrams().toString());
						}
					//}else if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
						if(loadLicenceOpeningStockDetailsObj.getNonGSTgrams()!=null){
							stockNONGSTGrams.setText(loadLicenceOpeningStockDetailsObj.getNonGSTgrams().toString());
						}
					//}
					licenceOrnamentName.setText(loadLicenceOpeningStockDetailsObj.getOrnament().getOrnamentName());
				}
			}else if(licenecStockOrnamentId!=null && licenecStockOrnamentId>0){
				Ornament loadOrnamentStockObj = MasterController.getInstace().getOrnament(licenecStockOrnamentId);
				if(loadOrnamentStockObj!=null){
					licenceOrnamentName.setText(loadOrnamentStockObj.getOrnamentName());
				}
			}
			
			
			licenceStockEntryPanel.add(new MyLabel("Ornament Name : "));
			licenceStockEntryPanel.add(licenceOrnamentName,"wrap");
			
			licenceStockEntryPanel.add(new MyLabel("Enter Grams :"));
			if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
				licenceStockEntryPanel.add(stockGSTGrams,"wrap");
				stockGSTGrams.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			}if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
				licenceStockEntryPanel.add(stockNONGSTGrams,"wrap");
				stockNONGSTGrams.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			}
			licenceStockEntryPanel.add(addStock);
			
			
			
			
			
			licenceStockEntryPanel.repaint();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return licenceStockEntryPanel;
	}
	
	private void addStock(){
		try{
			LicenceOpeningStockDetails openingStockObj = new LicenceOpeningStockDetails();
			
			if(licenceOpeningStockDetailsId!=null && licenceOpeningStockDetailsId>0){
				openingStockObj.setLicenceOpeningStockDetailsId(licenceOpeningStockDetailsId);
			}
			
			if(licenecStockOrnamentId!=null && licenecStockOrnamentId>0){
				openingStockObj.setOrnament(MasterController.getInstace().getOrnament(licenecStockOrnamentId));
			}
			
			if(!stockGSTGrams.getText().trim().equalsIgnoreCase("")){
				//if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
					openingStockObj.setGstGrams(Double.parseDouble(stockGSTGrams.getText().trim()));
				//}else if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
					//openingStockObj.setNonGSTgrams(Double.parseDouble(stockNONGSTGrams.getText().trim()));
				//}
			}
			
			if(!stockNONGSTGrams.getText().trim().equalsIgnoreCase("")){
				openingStockObj.setNonGSTgrams(Double.parseDouble(stockNONGSTGrams.getText().trim()));
			}
			openingStockObj.setDeletedFlag(ConstantUtils.CONSTANT_N);
			
			openingStockObj.setLicenceId(Session.licence.getLicenceId());
			
			if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
				//openingStockObj.setEntryType(MasterController.getInstace().getEntryType(ConstantUtils.GST_ENTRY));
			}else if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
				//openingStockObj.setEntryType(MasterController.getInstace().getEntryType(ConstantUtils.NON_GST_ENTRY));
			}
			
			Integer stockId = MasterController.getInstace().saveOrUpdateLicenceOpeningStockDetails(openingStockObj);
			
			if(stockId!=null && stockId>0){
				JOptionPane.showMessageDialog(null, "Stock Added successfully!!");
				fetchLicenceOrnamentList();
				dialog.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Stock Added Failed");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void deleteLicenceStock(int licenceOpeningStockDetailsId){
		try{
			int selected = JOptionPane.showConfirmDialog(null, "Are you sure You want to delete Stock Entry?");
			if(selected==JOptionPane.YES_OPTION){
				//JOptionPane.showMessageDialog(null, "Deleted");
				LicenceOpeningStockDetails deleteLicenceOpeningStock = MasterController.getInstace().getLicenceOpeningStockDetails(licenceOpeningStockDetailsId);
				if(deleteLicenceOpeningStock!=null){
					if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_GST_OPENING_STOCK)){
						deleteLicenceOpeningStock.setGstGrams(null);
					}else if(calledFrom.equalsIgnoreCase(ConstantUtils.ADD_NONGST_OPENING_STOCK)){
						deleteLicenceOpeningStock.setNonGSTgrams(null);
					}
					Integer deletedFlag = MasterController.getInstace().saveOrUpdateLicenceOpeningStockDetails(deleteLicenceOpeningStock);
					if(deletedFlag!=null && deletedFlag>0){
						JOptionPane.showMessageDialog(null, "Stock Deleted");
						fetchLicenceOrnamentList();
					}else{
						JOptionPane.showMessageDialog(null, "Stock Deletion Failed");
						fetchLicenceOrnamentList();
					}
				}
			}else if(selected==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "Not Deleted");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}

