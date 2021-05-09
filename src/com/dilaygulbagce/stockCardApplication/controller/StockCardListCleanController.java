package com.dilaygulbagce.stockCardApplication.controller;

import javax.swing.table.DefaultTableModel;

import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardListCleanController {

	private MainFrame mainFrame;

	public StockCardListCleanController (MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public void cleanList() {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.stockCardListFrame.stockCardTable.getModel();
        recordTable.setRowCount(0);
	}
}
