package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardCopyController implements ActionListener {

	private StockCardModel stockCardModel;
	private MainFrame mainFrame;
	private StockCardEntryControlController controlController;
	private StockCardEntryCleanController cleanController;
	
	public StockCardCopyController (StockCardModel stockCardModel, MainFrame mainFrame, 
			StockCardEntryControlController controlController, StockCardEntryCleanController cleanController) {
		
		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		this.controlController = controlController;
		this.cleanController = cleanController;
		
		this.mainFrame.stockCardFrame.copyButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.copyButton) {
			if(mainFrame.stockCardFrame.tfStockCode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Kopyalanacak Kaydı Seçiniz");
			}
			else {
				if(controlController.control() == true) {
					copy();
				}
			}
		}
	}
	
	public void copy() {
		String copyItem = JOptionPane.showInputDialog(null, "Kopyanın Stok Kodu?");

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
		
		stockCard.setStockCode(copyItem);
		
		if(stockCard.isRecorded(mainFrame.stockCardFrame.tfStockCode.getText())) {
			JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
		}
		else {
			if(stockCard.insert()) {
				JOptionPane.showMessageDialog(null, "Kopyalama İşlemi Başarılı!");
				cleanController.clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		}
	}
}
