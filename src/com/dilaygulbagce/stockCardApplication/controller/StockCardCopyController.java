package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class StockCardCopyController implements ActionListener {

	private StockCardModel productEntiries;
	private MainFrame mainFrame;
	private StockCardControlController controlController;
	private StockCardCleanController cleanController;
	
	public StockCardCopyController (StockCardModel productEntiries, MainFrame mainFrame, 
			StockCardControlController controlController, StockCardCleanController cleanController) {
		
		this.productEntiries = productEntiries;
		this.mainFrame = mainFrame;
		this.controlController = controlController;
		this.cleanController = cleanController;
		
		this.mainFrame.stockCardFrame.copyButton.addActionListener(this);
	}
	
	public void start() {
		mainFrame.setVisible(true);
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
		productEntiries.setStockCode(mainFrame.stockCardFrame.tfStockCode.getText());
		
		try {
			if (productEntiries.copy()) {
				JOptionPane.showMessageDialog(null, "Kopyalama İşlemi Başarılı!");
			}
			else {
				JOptionPane.showMessageDialog(null, "Bu Stok Kodu Zaten Kayıtlı!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
