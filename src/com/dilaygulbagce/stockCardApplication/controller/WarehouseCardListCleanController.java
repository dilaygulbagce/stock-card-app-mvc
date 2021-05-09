package com.dilaygulbagce.stockCardApplication.controller;

import javax.swing.table.DefaultTableModel;

import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardListCleanController {
	
	private MainFrame mainFrame;

	public WarehouseCardListCleanController (MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void cleanList() {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.warehouseCardListFrame.warehouseCardTable.getModel();
        recordTable.setRowCount(0);
	}
}
