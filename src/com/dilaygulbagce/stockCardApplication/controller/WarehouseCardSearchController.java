package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardSearchController implements ActionListener, KeyListener {
	
	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	
	public WarehouseCardSearchController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		
		this.mainFrame.warehouseCardFrame.searchButton.addActionListener(this);
		this.mainFrame.warehouseCardFrame.tfSearchBar.addKeyListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.warehouseCardFrame.searchButton) {
			if (mainFrame.warehouseCardFrame.tfSearchBar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Aranacak Kaydın Depo Kodunu Giriniz");
			}
			else {
				search();
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (mainFrame.warehouseCardFrame.tfSearchBar.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Aranacak Kaydın Depo Kodunu Giriniz");
			}
			else {
				search();
			}
		}
	}
	
	public void search() {
		warehouseCardModel.setWarehouseCode(mainFrame.warehouseCardFrame.tfSearchBar.getText().toUpperCase());
		
		try {
			if (warehouseCardModel.search()) {
				mainFrame.warehouseCardFrame.tfWarehouseCode.setText(warehouseCardModel.getWarehouseCode());
				mainFrame.warehouseCardFrame.tfWarehouseName.setText(warehouseCardModel.getWarehouseName());
				mainFrame.warehouseCardFrame.taWarehouseDescription.setText(warehouseCardModel.getWarehouseDescription());
				
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
