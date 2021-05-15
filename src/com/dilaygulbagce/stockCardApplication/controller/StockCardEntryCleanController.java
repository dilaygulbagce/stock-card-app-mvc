package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardEntryCleanController implements ActionListener {
	
	private MainFrame mainFrame;
	
	public StockCardEntryCleanController (MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		
		this.mainFrame.stockCardFrame.cleanButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.cleanButton) {
			clean();
		}
	}
	
	public void clean() {
		mainFrame.stockCardFrame.tfStockCode.setText(null);
		mainFrame.stockCardFrame.tfStockName.setText(null);
		mainFrame.stockCardFrame.cbWarehouseCode.setSelectedItem(null);
		mainFrame.stockCardFrame.cbStockType.setSelectedIndex(-1);
		mainFrame.stockCardFrame.cbUnit.setSelectedItem(null);
		mainFrame.stockCardFrame.tfBarcode.setText(null);
		mainFrame.stockCardFrame.cbVATType.setSelectedItem(null);
		mainFrame.stockCardFrame.jdcCreationDate.setDate(null);
		mainFrame.stockCardFrame.taDescription.setText(null);
	}
}
