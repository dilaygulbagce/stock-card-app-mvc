package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
					cleanController.clean();
				}
			}
		}
	}
	
	public void copy() {
		stockCardModel.setStockCode(mainFrame.stockCardFrame.tfStockCode.getText());
		
		if (stockCardModel.copy()) {
			JOptionPane.showMessageDialog(null, "Kopyalama İşlemi Başarılı!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
		}
	}
}
