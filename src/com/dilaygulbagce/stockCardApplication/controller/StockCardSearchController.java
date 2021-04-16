package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardSearchController implements ActionListener, KeyListener {
	
	private StockCardModel stockCardModel;
	private MainFrame mainFrame;
	
	public StockCardSearchController (StockCardModel stockCardModel, MainFrame mainFrame) {

		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		
		this.mainFrame.stockCardFrame.searchButton.addActionListener(this);
		this.mainFrame.stockCardFrame.tfSearchBar.addKeyListener(this); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.searchButton) {
			if (mainFrame.stockCardFrame.tfSearchBar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Aranacak Kaydın Stok Kodunu Giriniz");
			}
			else {
				search();
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			search();
		}
	}
	
	public void search() {
		stockCardModel.setStockCode(mainFrame.stockCardFrame.tfSearchBar.getText().toUpperCase());
		
		try {
			if (stockCardModel.search()) {
				mainFrame.stockCardFrame.tfStockCode.setText(stockCardModel.getStockCode());
				mainFrame.stockCardFrame.tfStockName.setText(stockCardModel.getStockName());
				mainFrame.stockCardFrame.cbWarehouseCode.setSelectedItem(stockCardModel.getWarehouseCode());
				mainFrame.stockCardFrame.cbStockType.setSelectedIndex(stockCardModel.getStockType());
				mainFrame.stockCardFrame.cbUnit.setSelectedItem(stockCardModel.getStockUnit());
				mainFrame.stockCardFrame.tfBarcode.setText(stockCardModel.getStockBarcode());
				mainFrame.stockCardFrame.cbVATType.setSelectedItem(stockCardModel.getVatType());
				mainFrame.stockCardFrame.jdcCreationDate.setDate(stockCardModel.getCreationDate());
				mainFrame.stockCardFrame.taDescription.setText(stockCardModel.getDescription());
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Kayıt Bulanamadı!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
