package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardListController implements ActionListener, InternalFrameListener {
	
	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	
	public WarehouseCardListController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		
		this.mainFrame.warehouseCardListFrame.listButton.addActionListener(this);
		this.mainFrame.warehouseCardListFrame.addInternalFrameListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.warehouseCardListFrame.listButton) {
			list();
		}
	}
	
	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.warehouseCardListFrame.warehouseCardTable.getModel();
        recordTable.setRowCount(0);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void list() {
		try {
			ArrayList<Vector> warehouseCardList = warehouseCardModel.list();
			
			if (warehouseCardList != null) {
				DefaultTableModel recordTable = (DefaultTableModel) mainFrame.warehouseCardListFrame.warehouseCardTable.getModel();
	            recordTable.setRowCount(0);
	      
	            for (Vector<String> s : warehouseCardList) {
	                   recordTable.addRow(s);
	            }
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
