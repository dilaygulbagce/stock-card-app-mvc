package com.dilaygulbagce.stockCardApplication;

import java.util.Vector;

import com.dilaygulbagce.stockCardApplication.controller.MainController;
import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;
import com.dilaygulbagce.stockCardApplication.view.StockCardFrame;
import com.dilaygulbagce.stockCardApplication.view.WarehouseCardFrame;

import tr.com.guru.common.model.DonemEntity;
import tr.com.guru.common.model.KullaniciEntity;
import tr.com.guru.common.model.SirketEntity;

public class Main {

	public static void main (String[] args) {
		
		MainFrame mainFrame = new MainFrame(new KullaniciEntity(), new SirketEntity(), new Vector(), new DonemEntity(), new Vector());
		StockCardModel stockCardModel = new StockCardModel(mainFrame);
		WarehouseCardModel warehouseCardModel = new WarehouseCardModel(mainFrame);
//		StockCardFrame stockCardFrame = new StockCardFrame(mainFrame);
//		WarehouseCardFrame warehouseCardFrame = new WarehouseCardFrame(mainFrame);
		
		MainController mainController = new MainController(stockCardModel, warehouseCardModel, mainFrame,
				mainFrame.stockCardFrame, mainFrame.warehouseCardFrame);
		
		mainController.start();
 	}
}
