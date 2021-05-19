package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

import tr.com.guru.common.model.BaseEntity;

public class StockCardListController implements ActionListener, InternalFrameListener {

	private StockCardModel stockCardModel;
	private MainFrame mainFrame;
	private StockCardListCleanController cleanController;

	public StockCardListController(StockCardModel stockCardModel, MainFrame mainFrame,
			StockCardListCleanController cleanController) {
	
		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		this.cleanController = cleanController;

		this.mainFrame.stockCardListFrame.listButton.addActionListener(this);
		this.mainFrame.stockCardListFrame.addInternalFrameListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardListFrame.listButton) {
			cleanController.cleanList();
			list();
			mainFrame.stockCardListFrame.listButton.setText("Yenile");
		}
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.stockCardListFrame.stockCardTable.getModel();
		recordTable.setRowCount(0);

		mainFrame.stockCardListFrame.listButton.setText("Listele");
	}

	public void list() {
		List<BaseEntity> stockCardList = stockCardModel.listAll("");
		
		if (stockCardList != null) {
			DefaultTableModel recordTable = (DefaultTableModel) mainFrame.stockCardListFrame.stockCardTable.getModel();

			Object[] row = new Object[9];
			
			stockCardList.forEach(e -> {
				row[0] = ((StockCardModel) e).getStockCode();
				row[1] = ((StockCardModel) e).getStockName();
				row[2] = ((StockCardModel) e).getWarehouseCode();
				row[3] = ((StockCardModel) e).getStockType();
				row[4] = ((StockCardModel) e).getStockUnit();
				row[5] = ((StockCardModel) e).getStockBarcode();
				row[6] = ((StockCardModel) e).getVatType();
				row[7] = ((StockCardModel) e).getCreationDate();
				row[8] = ((StockCardModel) e).getDescription();
				recordTable.addRow(row);
			});
			
		} else {
			JOptionPane.showMessageDialog(null, "Hata!");
		}
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}
}
