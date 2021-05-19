package com.dilaygulbagce.stockCardApplication.controller;

import com.dilaygulbagce.stockCardApplication.view.WarehouseCardFrame;

import tr.com.guru.common.command.BaseCardDeleteCommand;

public class WarehouseCardDeleteController extends BaseCardDeleteCommand<WarehouseCardFrame> {
	
	private WarehouseCardEntryCleanController cleanController;
	
	public WarehouseCardDeleteController(WarehouseCardFrame iFrame, WarehouseCardEntryCleanController cleanController) {
		super(iFrame);
		
		this.cleanController = cleanController;
	}

	@Override
	public boolean isSuitableToDelete(WarehouseCardFrame iFrame) {
		return true;
	}

	@Override
	public void deleteModel(WarehouseCardFrame iFrame) {
		iFrame.warehouseCardModel.delete();
		cleanController.clean();
	}

}
