package com.dilaygulbagce.stockCardApplication.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCodeComboboxController {
	
	public WarehouseCodeComboboxController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame) {
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
