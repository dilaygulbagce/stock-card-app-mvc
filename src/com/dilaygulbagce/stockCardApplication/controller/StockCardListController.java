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

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardListController implements ActionListener, InternalFrameListener {
	
	private StockCardModel stockCardModel;
	private MainFrame mainFrame;
	
	public StockCardListController (StockCardModel stockCardModel, MainFrame mainFrame) {
		
		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		
		this.mainFrame.stockCardListFrame.listButton.addActionListener(this);
		this.mainFrame.stockCardListFrame.addInternalFrameListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardListFrame.listButton) {
			list();
			mainFrame.stockCardListFrame.listButton.setText("Yenile");
		}
	}
	
	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		DefaultTableModel recordTable = (DefaultTableModel) mainFrame.stockCardListFrame.stockCardTable.getModel();
        recordTable.setRowCount(0);
        
        mainFrame.stockCardListFrame.setBounds(100, 100, 750, 745);
		mainFrame.stockCardListFrame.listButton.setText("Listele");
	}
	
	@SuppressWarnings("unchecked")
	public void list() {
		try {
			@SuppressWarnings("rawtypes")
			ArrayList<Vector> stockCardList = stockCardModel.list();
			
			if (stockCardList != null) {
				DefaultTableModel recordTable = (DefaultTableModel) mainFrame.stockCardListFrame.stockCardTable.getModel();
	            recordTable.setRowCount(0);
	      
	            for (Vector<String> s : stockCardList) {
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
