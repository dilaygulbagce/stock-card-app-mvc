package com.dilaygulbagce.stockCardApplication.controller;

import java.sql.Date;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.view.StockCardFrame;

import tr.com.guru.common.command.BaseCardSaveCommand;

public class StockCardSaveController extends BaseCardSaveCommand<StockCardFrame> {
	
	private StockCardEntryCleanController cleanController;
	
	public StockCardSaveController(StockCardFrame iFrame) {
		super(iFrame);
	}
	
	@Override
	public boolean isSuitableToSave(StockCardFrame iFrame) {
		if(iFrame.tfStockCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Stok Kodu Alanı Boş Bırakılamaz");
			iFrame.tfStockCode.requestFocus();
			return false;
        }
        
        else if (iFrame.tfStockName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Stok Adı Alanı Boş Bırakılamaz");
			iFrame.tfStockName.requestFocus();
            return false;
        }
		
        else if (iFrame.cbWarehouseCode.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Depo Kodu Alanı Boş Bırakılamaz");
			iFrame.cbWarehouseCode.requestFocus();
			return false;
        }
        
        else if (iFrame.cbStockType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Stok Tipi Alanı Boş Bırakılamaz");
			iFrame.cbStockType.requestFocus();
            return false;
        }
        
        else if (iFrame.cbUnit.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Stok Birimi Alanı Boş Bırakılamaz");
			iFrame.cbUnit.requestFocus();
            return false;
        }
        
        else if (iFrame.tfBarcode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Barkod Alanı Boş Bırakılamaz");
			iFrame.tfBarcode.requestFocus();
            return false;
        }
        
        else if (iFrame.cbVATType.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "KDV Tipi Alanı Boş Bırakılamaz");
			iFrame.cbVATType.requestFocus();
            return false;
        }
        
        else if (iFrame.jdcCreationDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Oluşturma Tarihi Alanı Boş Bırakılamaz");
			iFrame.jdcCreationDate.requestFocus();
            return false;
        }
		return true;
	}

	@Override
	public void prepareMasterData(StockCardFrame iFrame) {
		iFrame.stockCardModel.setStockCode(iFrame.tfStockCode.getText());
		iFrame.stockCardModel.setStockName(iFrame.tfStockName.getText());
		iFrame.stockCardModel.setWarehouseCode((String) iFrame.cbWarehouseCode.getSelectedItem());
		iFrame.stockCardModel.setStockType(iFrame.cbStockType.getSelectedIndex());
		iFrame.stockCardModel.setStockUnit((String) iFrame.cbUnit.getSelectedItem());
		iFrame.stockCardModel.setStockBarcode(iFrame.tfBarcode.getText());
		iFrame.stockCardModel.setVatType((Double) iFrame.cbVATType.getSelectedItem());
		Date date = new Date(iFrame.jdcCreationDate.getDate().getTime());
		iFrame.stockCardModel.setCreationDate(date);
		iFrame.stockCardModel.setDescription(iFrame.taDescription.getText());
	}

	@Override
	public void saveModel(StockCardFrame iFrame) {
		if(iFrame.stockCardModel.isRecorded()) {
			iFrame.stockCardModel.update();
			cleanController.clean();
		}
		else {
			iFrame.stockCardModel.insert();
			cleanController.clean();
		}
		
	}

}
