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
		
		StockCardControlController scControlController = new StockCardControlController(mainFrame);
		StockCardCleanController scCleanController = new StockCardCleanController(mainFrame);
		new MainFrameMenuController(mainFrame);
		new StockCardSaveController(stockCardModel, mainFrame, scControlController, scCleanController);
		new StockCardDeleteController(stockCardModel, mainFrame, scCleanController);
		new StockCardUpdateController(stockCardModel, mainFrame, scControlController, scCleanController);
		new StockCardCopyController(stockCardModel, mainFrame, scControlController, scCleanController);
		new StockCardSearchController(stockCardModel, mainFrame);
		new StockCardListController(stockCardModel, mainFrame);
		
		WarehouseCardControlController wcControlController = new WarehouseCardControlController(mainFrame);
		WarehouseCardCleanController wcCleanController = new WarehouseCardCleanController(mainFrame);
		new WarehouseCardListController(warehouseCardModel, mainFrame);
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

