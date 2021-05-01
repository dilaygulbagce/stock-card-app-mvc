package com.dilaygulbagce.stockCardApplication.controller;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardEntryControlController {
	
	private MainFrame mainFrame;

	public WarehouseCardEntryControlController (MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public boolean control() {
		if(mainFrame.warehouseCardFrame.tfWarehouseCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Depo Kodu Alanı Boş Bırakılamaz");
			return false;
        }
        
        else if (mainFrame.warehouseCardFrame.tfWarehouseName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Depo Adı Alanı Boş Bırakılamaz");
            return false;
        }
		return true;
	}
}
