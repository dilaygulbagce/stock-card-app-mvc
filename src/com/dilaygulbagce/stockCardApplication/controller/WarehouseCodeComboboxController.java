package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCodeComboboxController implements FocusListener {
	
	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	
	public WarehouseCodeComboboxController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		
		this.mainFrame.stockCardFrame.cbWarehouseCode.addFocusListener(this);;
	}
	
	@Override
	public void focusGained(FocusEvent e) {

		if(e.getSource() == mainFrame.stockCardFrame.cbWarehouseCode) {
			try {
				ArrayList<String> warehouseCodeList = warehouseCardModel.fillWarehouseCodeCombobox();
				
				if(warehouseCodeList != null) {
					mainFrame.stockCardFrame.cbWarehouseCode.setModel(new DefaultComboBoxModel<String>(warehouseCodeList.toArray(new String[0])));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
