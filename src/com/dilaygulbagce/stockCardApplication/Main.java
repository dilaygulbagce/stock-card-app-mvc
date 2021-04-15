package com.dilaygulbagce.stockCardApplication;

import com.dilaygulbagce.stockCardApplication.controller.StockCardSaveController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardListController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardSearchController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardUpdateController;
import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardDeleteController;
import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardListController;
import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardSaveController;
import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardUpdateController;
import com.dilaygulbagce.stockCardApplication.controller.MainFrameMenuController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardCleanController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardControlController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardCopyController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardDeleteController;
import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class Main {
	
	public static void main (String[] args) {
		
		StockCardModel stockCardModel = new StockCardModel();
		WarehouseCardModel warehouseCardModel = new WarehouseCardModel();
		MainFrame mainFrame = new MainFrame();
		
		MainFrameMenuController menuController = new MainFrameMenuController(mainFrame);
		StockCardControlController scControlController = new StockCardControlController(mainFrame);
		StockCardCleanController scCleanController = new StockCardCleanController(mainFrame);
		StockCardSaveController scInsertController = new StockCardSaveController(stockCardModel, mainFrame, scControlController, scCleanController);
		StockCardDeleteController scDeleteController = new StockCardDeleteController(stockCardModel, mainFrame, scCleanController);
		StockCardUpdateController scUpdateController = new StockCardUpdateController(stockCardModel, mainFrame, scControlController, scCleanController);
		StockCardCopyController scCopyController = new StockCardCopyController(stockCardModel, mainFrame, scControlController, scCleanController);
		StockCardSearchController scSearchController = new StockCardSearchController(stockCardModel, mainFrame);
		StockCardListController scListController = new StockCardListController(stockCardModel, mainFrame);
		
		WarehouseCardListController wcListController = new WarehouseCardListController(warehouseCardModel, mainFrame);
		WarehouseCardSaveController wcSaveController = new WarehouseCardSaveController(warehouseCardModel, mainFrame);
		WarehouseCardDeleteController wcDeleteController = new WarehouseCardDeleteController(warehouseCardModel, mainFrame);
		WarehouseCardUpdateController wcUpdateController = new WarehouseCardUpdateController(warehouseCardModel, mainFrame);
		
		menuController.start();
		scInsertController.start();
		scDeleteController.start();
		scUpdateController.start();
		scCopyController.start();
		scSearchController.start();
		scCleanController.start();
		scListController.start();
		
		wcListController.start();
		wcSaveController.start();
		wcDeleteController.start();
		wcUpdateController.start();
	}
}
