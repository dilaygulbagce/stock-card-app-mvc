package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class WarehouseCardUpdateController implements ActionListener {

	private WarehouseCardModel warehouseCardModel;
	private MainFrame mainFrame;
	private WarehouseCardEntryCleanController cleanController;
	
	public WarehouseCardUpdateController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame,
			WarehouseCardEntryCleanController cleanController) {
		
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		this.cleanController = cleanController;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			int dialog = JOptionPane.showConfirmDialog(null, "Güncellemeyi Onaylayınız", "Uyarı", JOptionPane.YES_NO_OPTION);
			
			if (dialog == JOptionPane.YES_OPTION) {
					update();
					new WarehouseCodeComboboxController(warehouseCardModel, mainFrame);
					cleanController.clean();
			}
	}

	public void update() {
		warehouseCardModel.setWarehouseCode(mainFrame.warehouseCardFrame.tfWarehouseCode.getText());
		
		WarehouseCardModel warehouseCard = new WarehouseCardModel(mainFrame);
				
		warehouseCard.update();
	}
}
