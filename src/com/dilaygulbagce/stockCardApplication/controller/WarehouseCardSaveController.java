package com.dilaygulbagce.stockCardApplication.controller;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.view.WarehouseCardFrame;

import tr.com.guru.common.command.BaseCardSaveCommand;

public class WarehouseCardSaveController extends BaseCardSaveCommand<WarehouseCardFrame> {

	private WarehouseCardEntryCleanController cleanController;
	
	public WarehouseCardSaveController(WarehouseCardFrame iFrame, WarehouseCardEntryCleanController cleanController) {
		super(iFrame);

		this.cleanController = cleanController;
	}
	
	@Override
	public boolean isSuitableToSave(WarehouseCardFrame iFrame) {
		boolean isReady = true;
		if(iFrame.tfWarehouseCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Depo Kodu Alanı Boş Bırakılamaz");
			iFrame.tfWarehouseCode.requestFocus();
			return false;
        }
        
        else if (iFrame.tfWarehouseName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Depo Adı Alanı Boş Bırakılamaz");
            iFrame.tfWarehouseName.requestFocus();
            return false;
        }
		return isReady;
	}

	@Override
	public void prepareMasterData(WarehouseCardFrame iFrame) {
		iFrame.warehouseCardModel.setWarehouseCode(iFrame.tfWarehouseCode.getText());
		iFrame.warehouseCardModel.setWarehouseName(iFrame.tfWarehouseName.getText());	
		iFrame.warehouseCardModel.setWarehouseDescription(iFrame.taDescription.getText());
	}

	@Override
	public void saveModel(WarehouseCardFrame iFrame) {
		if(iFrame.warehouseCardModel.isRecorded()) {
			iFrame.warehouseCardModel.update();
			cleanController.clean();
		}
		else {
			iFrame.warehouseCardModel.insert();
			cleanController.clean();
		}		
	}
	
//	public WarehouseCardSaveController (WarehouseCardModel warehouseCardModel, MainFrame mainFrame,
//			WarehouseCardEntryControlController controlController, WarehouseCardEntryCleanController cleanController) {
//		
//		this.warehouseCardModel = warehouseCardModel;
//		this.mainFrame = mainFrame;
//		this.controlController = controlController;
//		this.cleanController = cleanController;
//		
//		this.mainFrame.warehouseCardFrame.insertButton.addActionListener(this);
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == mainFrame.warehouseCardFrame.insertButton) {
//			if(controlController.control() == true) {
//				insert();
//				new WarehouseCodeComboboxController(warehouseCardModel, mainFrame);
//			}
//		}
//	}
//	
//	public void insert() {
//		warehouseCardModel.setWarehouseCode(mainFrame.warehouseCardFrame.tfWarehouseCode.getText());
//		
//		WarehouseCardModel warehouseCard = new WarehouseCardModel(mainFrame.warehouseCardFrame.tfWarehouseCode.getText(),
//				mainFrame.warehouseCardFrame.tfWarehouseName.getText(),
//				mainFrame.warehouseCardFrame.taDescription.getText());
//		
//		if(warehouseCard.isRecorded(mainFrame.warehouseCardFrame.tfWarehouseCode.getText())) {
//			JOptionPane.showMessageDialog(null, "Bu Depo Kodu Zaten Kayıtlı!");
//		}
//		else {
//			if(warehouseCard.insert()) {
//				JOptionPane.showMessageDialog(null, "Kayıt İşlemi Başarılı!");
//				cleanController.clean();
//			}
//			else {
//				JOptionPane.showMessageDialog(null, "Hata!");
//			}
//		}
//	}

}
