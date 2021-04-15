package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardSaveController implements ActionListener {
	
	private StockCardModel stockCardModel;
	private MainFrame mainFrame;
	private StockCardControlController controlController;
	private StockCardCleanController cleanController;
	
	public StockCardSaveController (StockCardModel stockCardModel, MainFrame mainFrame, 
			StockCardControlController controlController, StockCardCleanController cleanController) {
		
		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		this.controlController = controlController;
		this.cleanController = cleanController;
		
		this.mainFrame.stockCardFrame.insertButton.addActionListener(this);
	}

	public void start() {
		mainFrame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.insertButton) {
			if(controlController.control() == true) {
				insert();
				cleanController.clean();
			}
		}
		
	}
	
	public void insert() {
		stockCardModel.setStockCode(mainFrame.stockCardFrame.tfStockCode.getText());
		stockCardModel.setStockName(mainFrame.stockCardFrame.tfStockName.getText());
		stockCardModel.setWarehouseCode(mainFrame.stockCardFrame.cbWarehouseCode.getSelectedItem().toString());
		stockCardModel.setStockType(mainFrame.stockCardFrame.cbStockType.getSelectedIndex());
		stockCardModel.setStockUnit(mainFrame.stockCardFrame.cbUnit.getSelectedItem().toString());
		stockCardModel.setStockBarcode(mainFrame.stockCardFrame.tfBarcode.getText());
		stockCardModel.setVatType(Double.parseDouble((String) mainFrame.stockCardFrame.cbVATType.getSelectedItem().toString()));
		Date date = new Date(mainFrame.stockCardFrame.jdcCreationDate.getDate().getTime());
		stockCardModel.setCreationDate(date);
		stockCardModel.setDescription(mainFrame.stockCardFrame.taDescription.getText());
		
		try {
			if (stockCardModel.insert()) {
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
