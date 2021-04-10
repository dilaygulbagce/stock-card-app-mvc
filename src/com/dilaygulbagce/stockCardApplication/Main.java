package com.dilaygulbagce.stockCardApplication;

import com.dilaygulbagce.stockCardApplication.controller.ProductController;
import com.dilaygulbagce.stockCardApplication.model.ProductEntiries;
import com.dilaygulbagce.stockCardApplication.model.ProductQueries;
import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class Main {
	
	public static void main (String[] args) {
		ProductEntiries productEntiries = new ProductEntiries();
		ProductQueries productQueries = new ProductQueries();
		MainFrame mainFrame = new MainFrame();
		
		ProductController productController = new ProductController(productEntiries, productQueries, mainFrame);
		
		productController.start();
	}
}
