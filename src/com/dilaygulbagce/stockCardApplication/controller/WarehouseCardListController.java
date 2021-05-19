package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

import tr.com.guru.common.model.BaseEntity;

public class WarehouseCardListController implements ActionListener, InternalFrameListener {
	
	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	private WarehouseCardListCleanController cleanController;
	
	public WarehouseCardListController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame, 
			WarehouseCardListCleanController cleanController) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		this.cleanController = cleanController;
		
		this.mainFrame.warehouseCardListFrame.listButton.addActionListener(this);
		this.mainFrame.warehouseCardListFrame.addInternalFrameListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.warehouseCardListFrame.listButton) {
			cleanController.cleanList();
			list();
			mainFrame.warehouseCardListFrame.listButton.setText("Yenile");
		}
	}
	
	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.warehouseCardListFrame.warehouseCardTable.getModel();
        recordTable.setRowCount(0);
        
		mainFrame.warehouseCardListFrame.listButton.setText("Listele");
	}
	
	public void list() {
		List<BaseEntity> warehouseCardList = warehouseCardModel.listAll("");
		if (warehouseCardList != null) {
			DefaultTableModel recordTable = (DefaultTableModel) mainFrame.warehouseCardListFrame.warehouseCardTable.getModel();

			Object[] row = new Object[4];
			
			warehouseCardList.forEach(e -> {
				row[0] = ((WarehouseCardModel) e).getId();
				row[1] = ((WarehouseCardModel) e).getWarehouseCode();
				row[2] = ((WarehouseCardModel) e).getWarehouseName();
				row[3] = ((WarehouseCardModel) e).getWarehouseDescription();
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
