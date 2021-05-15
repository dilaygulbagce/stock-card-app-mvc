package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		this.mainFrame.stockCardFrame.tfStockCode.addKeyListener(this); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.searchButton) {
			if (mainFrame.stockCardFrame.tfStockCode.getText().isEmpty()) {
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
			if (mainFrame.stockCardFrame.tfStockCode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Aranacak Kaydın Stok Kodunu Giriniz");
			}
			else {
				search();
			}
		}
	}
	
	public void search() {
		StockCardModel stockCard = new StockCardModel(mainFrame.stockCardFrame.tfStockCode.getText());

		try {
			stockCardModel = (StockCardModel) stockCard.search(mainFrame.stockCardFrame.tfStockCode.getText());
			
			if (stockCardModel != null) {
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
				JOptionPane.showMessageDialog(null, "Kayıt Bulunamadı!");
			}
		} catch (HeadlessException e) {
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
