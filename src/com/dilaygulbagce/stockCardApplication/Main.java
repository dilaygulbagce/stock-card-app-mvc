package com.dilaygulbagce.stockCardApplication;

import com.dilaygulbagce.stockCardApplication.controller.MainController;
import com.dilaygulbagce.stockCardApplication.model.BaseCardModel;
import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class Main {

	public static void main (String[] args) {
		
		StockCardModel stockCardModel = new StockCardModel();
		WarehouseCardModel warehouseCardModel = new WarehouseCardModel();
		MainFrame mainFrame = new MainFrame();
		
		MainController mainController = new MainController(stockCardModel, warehouseCardModel, mainFrame);
		mainController.start();
 	}
}
