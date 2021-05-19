package com.dilaygulbagce.stockCardApplication.controller;

import com.dilaygulbagce.stockCardApplication.view.WarehouseCardFrame;

import tr.com.guru.common.command.BaseCardFrameCommand;
import tr.com.guru.common.view.BaseCardFrame;
import tr.com.guru.common.view.BaseInternalFrame;
import tr.com.guru.common.view.MainFrameInterface;

public class WarehouseCardFrameCommand extends BaseCardFrameCommand {

	private WarehouseCardFrame iFrame;
	
	public WarehouseCardFrameCommand(MainFrameInterface mainFrame) {
		super(mainFrame);
		// TOD Auto-generated constructor stub
	}

	@Override
	public void execute() {
		bif = getFrameNewInstance();
		bcf = (BaseCardFrame) bif;
		setBaseFrameSpecificState();
		
	}
	@Override
	public String getActionConstant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setListeners() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getValueFromFace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected BaseInternalFrame getFrameNewInstance() {
		// TODO Auto-generated method stub
		return iFrame = new WarehouseCardFrame(mainFrame);
	}

}
