package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardDeleteController implements ActionListener {

	private StockCardModel stockCardModel;
	private MainFrame mainFrame;
	private StockCardCleanController cleanController;

	public StockCardDeleteController (StockCardModel stockCardModel, MainFrame mainFrame, StockCardCleanController cleanController) {
		
		this.stockCardModel = stockCardModel;
		this.mainFrame = mainFrame;
		this.cleanController = cleanController;
		
		this.mainFrame.stockCardFrame.deleteButton.addActionListener(this);
	}
	
	public void start() {
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == mainFrame.stockCardFrame.deleteButton) {
			if (mainFrame.stockCardFrame.tfStockCode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Silinecek Kaydı Seçiniz");
			}
			else {
				int dialog = JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.YES_NO_OPTION);
				
				if (dialog == JOptionPane.YES_OPTION) {
					delete();
					cleanController.clean();
				}
			}
		}
	}
	
	public void delete() {
		stockCardModel.setStockCode(mainFrame.stockCardFrame.tfStockCode.getText());
		
		try {
			if (stockCardModel.delete()) {
				JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
