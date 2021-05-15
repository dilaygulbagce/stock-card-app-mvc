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
		
		WarehouseCardModel warehouseCard = new WarehouseCardModel(mainFrame.warehouseCardFrame.tfWarehouseCode.getText(),
				mainFrame.warehouseCardFrame.tfWarehouseName.getText(),
				mainFrame.warehouseCardFrame.taDescription.getText());
		
		if(warehouseCard.isRecorded(mainFrame.warehouseCardFrame.tfWarehouseCode.getText())) {
			JOptionPane.showMessageDialog(null, "Bu Depo Kodu Zaten Kayıtlı!");
		}
		else {
			if(warehouseCard.insert()) {
				JOptionPane.showMessageDialog(null, "Kayıt İşlemi Başarılı!");
				cleanController.clean();
			}
			else {
				JOptionPane.showMessageDialog(null, "Hata!");
			}
		}
	}
}
