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
					try {
						update();
						cleanController.clean();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	public void update() throws SQLException {
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
		
		if (stockCard.update()) {
			JOptionPane.showMessageDialog(null, "Güncelleme İşlemi Başarılı!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Hata!");
		}
	}
}
