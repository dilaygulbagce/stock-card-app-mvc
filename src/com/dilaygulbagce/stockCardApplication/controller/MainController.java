package com.dilaygulbagce.stockCardApplication.controller;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;
import com.dilaygulbagce.stockCardApplication.view.StockCardFrame;
import com.dilaygulbagce.stockCardApplication.view.WarehouseCardFrame;

public class MainController {

	StockCardModel stockCardModel;
	WarehouseCardModel warehouseCardModel;
	MainFrame mainFrame;
	StockCardFrame stockCardFrame;
	WarehouseCardFrame warehouseCardFrame;
	
	public MainController (StockCardModel stockCardModel, WarehouseCardModel warehouseCardModel, MainFrame mainFrame,
			StockCardFrame stockCardFrame, WarehouseCardFrame warehouseCardFrame) {
		
		this.stockCardFrame = stockCardFrame;
		this.warehouseCardFrame = warehouseCardFrame;
		this.stockCardModel = stockCardModel;
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		
		new MainFrameMenuController(mainFrame);
		
		StockCardEntryCleanController scCleanController = new StockCardEntryCleanController(mainFrame);
		StockCardListCleanController scListCleanController = new StockCardListCleanController(mainFrame);
		new StockCardSaveController(stockCardFrame);
		new StockCardDeleteController(stockCardFrame);
		new StockCardUpdateController(stockCardModel, mainFrame, scCleanController);
		new StockCardCopyController(stockCardModel, mainFrame, scCleanController);
		new StockCardSearchController(stockCardModel, mainFrame);
		new StockCardListController(stockCardModel, mainFrame, scListCleanController);
		
		WarehouseCardEntryCleanController wcCleanController = new WarehouseCardEntryCleanController(this.mainFrame);
		WarehouseCardListCleanController wcListCleanController = new WarehouseCardListCleanController(mainFrame);
		new WarehouseCardListController(warehouseCardModel, mainFrame, wcListCleanController);
//		new WarehouseCardSaveController(warehouseCardFrame, mainFrame, wcCleanController);
		new WarehouseCardDeleteController(warehouseCardFrame, wcCleanController);
		new WarehouseCardUpdateController(warehouseCardModel, mainFrame, wcCleanController);
		new WarehouseCardSearchController(warehouseCardModel, mainFrame);
		
		new WarehouseCodeComboboxController(warehouseCardModel, mainFrame);
	}

	public void start() {
		mainFrame.setVisible(true);
	}
}

