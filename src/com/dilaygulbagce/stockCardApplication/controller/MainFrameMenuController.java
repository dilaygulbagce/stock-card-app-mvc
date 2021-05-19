package com.dilaygulbagce.stockCardApplication.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.dilaygulbagce.stockCardApplication.view.MainFrame;

public class MainFrameMenuController implements ActionListener {
	
	private MainFrame mainFrame;
	
	public MainFrameMenuController(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		
		this.mainFrame.stockCardMenuItem.addActionListener(this);
		this.mainFrame.stockCardListMenuItem.addActionListener(this);
		this.mainFrame.warehouseCardMenuItem.addActionListener(this);
		this.mainFrame.warehouseCardListMenuItem.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainFrame.stockCardMenuItem) {
			
			mainFrame.stockCardFrame.setLocation(3, 5);
			mainFrame.stockCardFrame.setVisible(true);
		}
		
		if (e.getSource() == mainFrame.stockCardListMenuItem) {
			mainFrame.stockCardListFrame.setLocation(3, 5);
			mainFrame.stockCardListFrame.setVisible(true);
		}
		
		if (e.getSource() == mainFrame.warehouseCardMenuItem) {
			mainFrame.warehouseCardFrame.setLocation(3, 5);
			mainFrame.warehouseCardFrame.setVisible(true);
		}
		
		if (e.getSource() == mainFrame.warehouseCardListMenuItem) {
			mainFrame.warehouseCardListFrame.setLocation(3, 5);
			mainFrame.warehouseCardListFrame.setVisible(true);
		}
	}
}
