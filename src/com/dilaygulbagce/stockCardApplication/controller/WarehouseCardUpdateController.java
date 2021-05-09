package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardUpdateController implements ActionListener {

	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	private WarehouseCardEntryControlController controlController;
	private WarehouseCardEntryCleanController cleanController;
	
	public WarehouseCardUpdateController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame,
			WarehouseCardEntryControlController controlController, WarehouseCardEntryCleanController cleanController) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		this.controlController = controlController;
		this.cleanController = cleanController;
		
		this.mainFrame.warehouseCardFrame.updateButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(controlController.control() == true) {
			int dialog = JOptionPane.showConfirmDialog(null, "Güncellemeyi Onaylayınız", "Uyarı", JOptionPane.YES_NO_OPTION);
			
			if (dialog == JOptionPane.YES_OPTION) {
					update();
					new WarehouseCodeComboboxController(warehouseCardModel, mainFrame);
					cleanController.clean();
			}
		}
	}

	public void update() {
		warehouseCardModel.setWarehouseCode(mainFrame.warehouseCardFrame.tfWarehouseCode.getText());
		warehouseCardModel.setWarehouseName(mainFrame.warehouseCardFrame.tfWarehouseName.getText());
		warehouseCardModel.setWarehouseDescription(mainFrame.warehouseCardFrame.taWarehouseDescription.getText());
		
		if (warehouseCardModel.update()) {
			JOptionPane.showMessageDialog(null, "Güncelleme İşlemi Başarılı!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Hata!");
		}
	}
}
