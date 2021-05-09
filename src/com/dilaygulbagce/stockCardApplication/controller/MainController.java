package com.dilaygulbagce.stockCardApplication.controller;

import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class MainController {

	StockCardModel stockCardModel;
	WarehouseCardModel warehouseCardModel;
	MainFrame mainFrame;
	
	public MainController (StockCardModel stockCardModel, WarehouseCardModel warehouseCardModel, 
			MainFrame mainFrame) {
		
		this.stockCardModel = stockCardModel;
		this.warehouseCardModel = warehouseCardModel;
		this.mainFrame = mainFrame;
		
		new MainFrameMenuController(mainFrame);
		
		StockCardEntryControlController scControlController = new StockCardEntryControlController(mainFrame);
		StockCardEntryCleanController scCleanController = new StockCardEntryCleanController(mainFrame);
		StockCardListCleanController scListCleanController = new StockCardListCleanController(mainFrame);
		new StockCardSaveController(stockCardModel, mainFrame, scControlController, scCleanController);
		new StockCardDeleteController(stockCardModel, mainFrame, scCleanController);
		new StockCardUpdateController(stockCardModel, mainFrame, scControlController, scCleanController);
		new StockCardCopyController(stockCardModel, mainFrame, scControlController, scCleanController);
		new StockCardSearchController(stockCardModel, mainFrame);
		new StockCardListController(stockCardModel, mainFrame, scListCleanController);
		
		WarehouseCardEntryControlController wcControlController = new WarehouseCardEntryControlController(mainFrame);
		WarehouseCardEntryCleanController wcCleanController = new WarehouseCardEntryCleanController(mainFrame);
		WarehouseCardListCleanController wcListCleanController = new WarehouseCardListCleanController(mainFrame);
		new WarehouseCardListController(warehouseCardModel, mainFrame, wcListCleanController);
		new WarehouseCardSaveController(warehouseCardModel, mainFrame, wcControlController, wcCleanController);
		new WarehouseCardDeleteController(warehouseCardModel, mainFrame, wcCleanController);
		new WarehouseCardUpdateController(warehouseCardModel, mainFrame, wcControlController, wcCleanController);
		new WarehouseCardSearchController(warehouseCardModel, mainFrame);
		
		new WarehouseCodeComboboxController(warehouseCardModel, mainFrame);
	}

	public void start() {
		mainFrame.setVisible(true);
	}
}

