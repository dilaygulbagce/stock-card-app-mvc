package com.dilaygulbagce.stockCardApplication.controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCodeComboboxController {
	
	public WarehouseCodeComboboxController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame) {
		List warehouseCodeList = warehouseCardModel.fillWarehouseCodeCombobox("");
				
		if(warehouseCodeList != null) {
			mainFrame.stockCardFrame.cbWarehouseCode.setModel(new DefaultComboBoxModel(warehouseCodeList.toArray()));
		}
	}
}
