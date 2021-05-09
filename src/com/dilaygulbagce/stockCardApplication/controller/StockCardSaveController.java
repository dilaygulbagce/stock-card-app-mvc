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
	private StockCardEntryControlController controlController;
	private StockCardEntryCleanController cleanController;
	
	public StockCardSaveController (StockCardModel stockCardModel, MainFrame mainFrame, 
			StockCardEntryControlController controlController, StockCardEntryCleanController cleanController) {
		
		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		this.controlController = controlController;
		this.cleanController = cleanController;
		
		this.mainFrame.stockCardFrame.insertButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.insertButton) {
			if(controlController.control()) {
				try {
					insert();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void insert() throws SQLException {
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
		
		if(stockCardModel.isRecorded()) {
			JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
		}
		else {
			if(stockCardModel.insert()) {
				JOptionPane.showMessageDialog(null, "Kayıt İşlemi Başarılı!");
				cleanController.clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		}
	}
}
