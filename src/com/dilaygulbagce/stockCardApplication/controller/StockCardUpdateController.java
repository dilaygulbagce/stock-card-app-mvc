package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardUpdateController implements ActionListener {
	
	private StockCardModel stockCardModel;
	private MainFrame mainFrame;
	private StockCardEntryControlController controlController;
	private StockCardEntryCleanController cleanController;
	
	public StockCardUpdateController(StockCardModel stockCardModel, MainFrame mainFrame, 
			StockCardEntryControlController controlController, StockCardEntryCleanController cleanController) {
		
		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		this.controlController = controlController;
		this.cleanController = cleanController;
		
		this.mainFrame.stockCardFrame.updateButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.updateButton) {
			if(controlController.control() == true) {
				int dialog = JOptionPane.showConfirmDialog(null, "Güncellemeyi Onaylayınız", "Uyarı", JOptionPane.YES_NO_OPTION);
				
				if (dialog == JOptionPane.YES_OPTION) {
						update();
						cleanController.clean();
				}
			}
		}
	}
	
	public void update() {
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
			if (stockCardModel.update()) {
				JOptionPane.showMessageDialog(null, "Güncelleme İşlemi Başarılı!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
