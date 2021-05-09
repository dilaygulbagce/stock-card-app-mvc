package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardSaveController implements ActionListener {
	
	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	private WarehouseCardEntryControlController controlController;
	private WarehouseCardEntryCleanController cleanController;
	
	public WarehouseCardSaveController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame,
			WarehouseCardEntryControlController controlController, WarehouseCardEntryCleanController cleanController) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		this.controlController = controlController;
		this.cleanController = cleanController;
		
		this.mainFrame.warehouseCardFrame.insertButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.warehouseCardFrame.insertButton) {
			if(controlController.control() == true) {
				insert();
				new WarehouseCodeComboboxController(warehouseCardModel, mainFrame);
			}
		}
	}
	
	public void insert() {
		warehouseCardModel.setWarehouseCode(mainFrame.warehouseCardFrame.tfWarehouseCode.getText());
		warehouseCardModel.setWarehouseName(mainFrame.warehouseCardFrame.tfWarehouseName.getText());
		warehouseCardModel.setWarehouseDescription(mainFrame.warehouseCardFrame.taWarehouseDescription.getText());
		

		if(warehouseCardModel.isRecorded()) {
			JOptionPane.showMessageDialog(null, "Bu Depo Kodu Zaten Kayıtlı!");
		}
		else {
			if(warehouseCardModel.insert()) {
				JOptionPane.showMessageDialog(null, "Kayıt İşlemi Başarılı!");
				cleanController.clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		}
	}
}
