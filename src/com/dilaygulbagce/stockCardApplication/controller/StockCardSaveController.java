package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.BaseCardModel;
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
		Date date = new Date(mainFrame.stockCardFrame.jdcCreationDate.getDate().getTime());

		StockCardModel stockCard = new StockCardModel(mainFrame.stockCardFrame.tfStockCode.getText(), 
				mainFrame.stockCardFrame.tfStockName.getText(),
				mainFrame.stockCardFrame.cbWarehouseCode.getSelectedItem().toString(), 
				mainFrame.stockCardFrame.cbStockType.getSelectedIndex(),
				mainFrame.stockCardFrame.cbUnit.getSelectedItem().toString(), 
				mainFrame.stockCardFrame.tfBarcode.getText(),
				Double.parseDouble((String) mainFrame.stockCardFrame.cbVATType.getSelectedItem().toString()), 
				date,
				mainFrame.stockCardFrame.taDescription.getText());
				
		if(stockCard.isRecorded(mainFrame.stockCardFrame.tfStockCode.getText())) {
			JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
		}
		else {
			if(stockCard.insert()) {
				JOptionPane.showMessageDialog(null, "Kayıt İşlemi Başarılı!");
				cleanController.clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		}
	}
}
