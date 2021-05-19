package com.dilaygulbagce.stockCardApplication.controller;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.view.StockCardFrame;

import tr.com.guru.common.command.BaseCardDeleteCommand;

public class StockCardDeleteController extends BaseCardDeleteCommand<StockCardFrame> {

	private StockCardEntryCleanController cleanController;
	
	public StockCardDeleteController (StockCardFrame iFrame) {
		super(iFrame);
	}

	@Override
	public boolean isSuitableToDelete(StockCardFrame iFrame) {
		String stockCode = iFrame.stockCardModel.getStockCode();
		
		if(stockCode == null) {
			JOptionPane.showMessageDialog(null, "Silinecek Kaydi Seciniz");
			return false;
		}
		return true;
	}

	@Override
	public void deleteModel(StockCardFrame iFrame) {
		iFrame.stockCardModel.delete();
		cleanController.clean();
	}
	
//	public StockCardDeleteController (StockCardModel stockCardModel, MainFrame mainFrame, 
//			StockCardEntryCleanController cleanController) {
//		super(null);
//		
//		this.stockCardModel = stockCardModel;
//		this.mainFrame = mainFrame;
//		this.cleanController = cleanController;
//		
//		this.mainFrame.stockCardFrame.deleteButton.addActionListener(this);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		if (e.getSource() == mainFrame.stockCardFrame.deleteButton) {
//			if (mainFrame.stockCardFrame.tfStockCode.getText().isEmpty()) {
//				JOptionPane.showMessageDialog(null, "Silinecek Kaydı Seçiniz");
//			}
//			else {
//				int dialog = JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.YES_NO_OPTION);
//				
//				if (dialog == JOptionPane.YES_OPTION) {
//					
//					cleanController.clean();
//				}
//			}
//		}
//	}

}
