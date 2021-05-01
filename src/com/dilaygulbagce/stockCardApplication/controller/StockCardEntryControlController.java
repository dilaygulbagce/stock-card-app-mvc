package com.dilaygulbagce.stockCardApplication.controller;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardEntryControlController {

	private MainFrame mainFrame;
	
	public StockCardEntryControlController (MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public boolean control() {
		if(mainFrame.stockCardFrame.tfStockCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Stok Kodu Alanı Boş Bırakılamaz");
			return false;
        }
        
        else if (mainFrame.stockCardFrame.tfStockName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Stok Adı Alanı Boş Bırakılamaz");
            return false;
        }
		
        else if (mainFrame.stockCardFrame.cbWarehouseCode.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Depo Kodu Alanı Boş Bırakılamaz");
			return false;
        }
        
        else if (mainFrame.stockCardFrame.cbStockType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Stok Tipi Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.stockCardFrame.cbUnit.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Stok Birimi Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.stockCardFrame.tfBarcode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Barkod Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.stockCardFrame.cbVATType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "KDV Tipi Alanı Boş Bırakılamaz");
            return false;
        }
        
        else if (mainFrame.stockCardFrame.jdcCreationDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Oluşturma Tarihi Alanı Boş Bırakılamaz");
            return false;
        }
		return true;
	}
}
