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
	
	private StockCardModel productEntiries;
	private MainFrame mainFrame;
	
	public StockCardSearchController (StockCardModel productEntiries, MainFrame mainFrame) {

		this.productEntiries = productEntiries;
		this.mainFrame = mainFrame;
		
		this.mainFrame.stockCardFrame.searchButton.addActionListener(this);
		this.mainFrame.stockCardFrame.tfSearchBar.addKeyListener(this); 
	}
	
	public void start() {
		mainFrame.setVisible(true);
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
		productEntiries.setStockCode(mainFrame.stockCardFrame.tfSearchBar.getText().toUpperCase());
		
		try {
			if (productEntiries.search()) {
				mainFrame.stockCardFrame.tfStockCode.setText(productEntiries.getStockCode());
				mainFrame.stockCardFrame.tfStockName.setText(productEntiries.getStockName());
				mainFrame.stockCardFrame.cbWarehouseCode.setSelectedItem(productEntiries.getWarehouseCode());
				mainFrame.stockCardFrame.cbStockType.setSelectedIndex(productEntiries.getStockType());
				mainFrame.stockCardFrame.cbUnit.setSelectedItem(productEntiries.getStockUnit());
				mainFrame.stockCardFrame.tfBarcode.setText(productEntiries.getStockBarcode());
				mainFrame.stockCardFrame.cbVATType.setSelectedItem(productEntiries.getVatType());
				mainFrame.stockCardFrame.jdcCreationDate.setDate(productEntiries.getCreationDate());
				mainFrame.stockCardFrame.taDescription.setText(productEntiries.getDescription());
				
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
