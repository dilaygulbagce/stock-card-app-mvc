package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardCopyController implements ActionListener {

	private MainFrame mainFrame;
	private StockCardEntryCleanController cleanController;
	
	public StockCardCopyController (StockCardModel stockCardModel, MainFrame mainFrame, 
		 StockCardEntryCleanController cleanController) {
		
		this.mainFrame = mainFrame;
		this.cleanController = cleanController;
		
//		this.mainFrame.stockCardFrame.copyButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardFrame.copyButton) {
			if(mainFrame.stockCardFrame.tfStockCode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Kopyalanacak Kaydı Seçiniz");
			}
			else {
				copy();
			}
		}
	}
	
	public void copy() {
		String copyItem = JOptionPane.showInputDialog(null, "Kopyanın Stok Kodu?");
		
		StockCardModel stockCard = new StockCardModel(mainFrame);
		
		stockCard.setStockCode(copyItem);
		
		if(stockCard.isRecorded()) {
			JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
			return;
		}
		else {
			stockCard.insert();
			cleanController.clean();
		}
	}
}
