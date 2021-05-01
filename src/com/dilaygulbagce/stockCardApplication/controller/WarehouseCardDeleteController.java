package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardDeleteController implements ActionListener {
	
	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	private WarehouseCardEntryCleanController cleanController;
	
	public WarehouseCardDeleteController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame, 
			WarehouseCardEntryCleanController cleanController) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		this.cleanController = cleanController;
		
		this.mainFrame.warehouseCardFrame.deleteButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.warehouseCardFrame.deleteButton) {
			if (mainFrame.warehouseCardFrame.tfWarehouseCode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Silinecek Kaydı Seçiniz");
			}
			else {
				int dialog = JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.YES_NO_OPTION);
				
				if (dialog == JOptionPane.YES_OPTION) {
					delete();
					new WarehouseCodeComboboxController(warehouseCardModel, mainFrame);
					cleanController.clean();
				}
			}
		}
	}
	
	public void delete() {
		warehouseCardModel.setWarehouseCode(mainFrame.warehouseCardFrame.tfWarehouseCode.getText());
		
		try {
			if (warehouseCardModel.delete()) {
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
