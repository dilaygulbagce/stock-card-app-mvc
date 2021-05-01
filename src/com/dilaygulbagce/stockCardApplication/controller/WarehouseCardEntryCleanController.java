package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardEntryCleanController implements ActionListener {

	private MainFrame mainFrame;
	
	public WarehouseCardEntryCleanController (MainFrame mainFrame) {

		this.mainFrame = mainFrame;
		
		this.mainFrame.warehouseCardFrame.cleanButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.warehouseCardFrame.cleanButton) {
			clean();
		}
	}
	
	public void clean() {
		mainFrame.warehouseCardFrame.tfSearchBar.setText(null);
		mainFrame.warehouseCardFrame.tfWarehouseCode.setText(null);
		mainFrame.warehouseCardFrame.tfWarehouseName.setText(null);
		mainFrame.warehouseCardFrame.taWarehouseDescription.setText(null);
	}
}
