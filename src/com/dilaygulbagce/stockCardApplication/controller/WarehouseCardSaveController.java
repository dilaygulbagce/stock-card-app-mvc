package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardSaveController implements ActionListener {
	
	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	
	public WarehouseCardSaveController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		
		this.mainFrame.warehouseCardFrame.insertButton.addActionListener(this);
	}
	
	public void start() {
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.warehouseCardFrame.insertButton) {
			insert();
		}
	}
	
	public void insert() {
		warehouseCardModel.setWarehouseCode(mainFrame.warehouseCardFrame.tfWarehouseCode.getText());
		warehouseCardModel.setWarehouseName(mainFrame.warehouseCardFrame.tfWarehouseName.getText());
		warehouseCardModel.setWarehouseDescription(mainFrame.warehouseCardFrame.taWarehouseDescription.getText());
		
		try {
			if (warehouseCardModel.insert()) {
				JOptionPane.showMessageDialog(null, "Kayıt İşlemi Başarılı!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
