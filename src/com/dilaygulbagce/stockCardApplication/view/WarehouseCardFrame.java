package com.dilaygulbagce.stockCardApplication.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardDeleteController;
import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardEntryCleanController;
import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardSaveController;
import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.utility.EntryLimit;

import tr.com.guru.common.command.BaseCardDeleteCommand;
import tr.com.guru.common.command.BaseCardSaveCommand;
import tr.com.guru.common.model.BaseDataModel2;
import tr.com.guru.common.view.BaseCardFrame;
import tr.com.guru.common.view.FindButton;
import tr.com.guru.common.view.LimitedTextField;
import tr.com.guru.common.view.MainFrameInterface;

@SuppressWarnings("serial")
public class WarehouseCardFrame extends BaseCardFrame {
	
	public JTextField tfWarehouseCode;
	public JTextField tfWarehouseName;
	
	public JTextArea taDescription;
	
	public JButton insertButton;
	public JButton deleteButton;
	public JButton updateButton;
	public JButton copyButton;
	public JButton cleanButton;
	public JButton searchButton;
	
	public WarehouseCardModel warehouseCardModel;
	
	public WarehouseCardFrame(MainFrameInterface mainFrame) {
		super(mainFrame);

		warehouseCardModel = new WarehouseCardModel(mainFrame);
			
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		GridBagLayout gridBagLayout = (GridBagLayout) centerPanel.getLayout();
		gridBagLayout.columnWidths = new int[]{41, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		
		JLabel codeLabel= new JLabel("Depo Kodu: ");
		GridBagConstraints gbc_codeLabel= new GridBagConstraints();
		gbc_codeLabel.anchor = GridBagConstraints.WEST;
		gbc_codeLabel.gridx = 0;
		gbc_codeLabel.gridy = 0;
		centerPanel.add(codeLabel, gbc_codeLabel);
		
		tfWarehouseCode = new LimitedTextField(20, WarehouseCardModel.CODE_LIMIT);
		GridBagConstraints gbc_tfWarehouseCode = new GridBagConstraints();
		gbc_tfWarehouseCode.anchor = GridBagConstraints.WEST;
		gbc_tfWarehouseCode.gridx = 1;
		gbc_tfWarehouseCode.gridy = 0;
		centerPanel.add(tfWarehouseCode, gbc_tfWarehouseCode);
		
		searchButton = new FindButton();
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.anchor = GridBagConstraints.WEST;
		gbc_searchButton.gridx = 2;
		gbc_searchButton.gridy = 0;
		centerPanel.add(searchButton, gbc_searchButton);

		JLabel nameLabel = new JLabel("Depo Adı: ");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 1;
		centerPanel.add(nameLabel, gbc_nameLabel);

		tfWarehouseName = new LimitedTextField(20, WarehouseCardModel.NAME_LIMIT);
		GridBagConstraints gbc_tfWarehouseName = new GridBagConstraints();
		gbc_tfWarehouseName.anchor = GridBagConstraints.WEST;
		gbc_tfWarehouseName.gridx = 1;
		gbc_tfWarehouseName.gridy = 1;
		centerPanel.add(tfWarehouseName, gbc_tfWarehouseName);

		JLabel descriptionLabel = new JLabel("Açıklama: ");
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.anchor = GridBagConstraints.WEST;
		gbc_descriptionLabel.gridx = 0;
		gbc_descriptionLabel.gridy = 2;
		centerPanel.add(descriptionLabel, gbc_descriptionLabel);

		taDescription = new JTextArea(3, 20);
		taDescription.setDocument(new EntryLimit(StockCardModel.DESCRIPTION_LIMIT));
		GridBagConstraints gbc_taDescription = new GridBagConstraints();
		gbc_taDescription.anchor = GridBagConstraints.WEST;
		gbc_taDescription.gridx = 1;
		gbc_taDescription.gridy = 2;
		centerPanel.add(taDescription, gbc_taDescription);
	}

	@Override
	public void setTitle() {
		setTitle("Depo Kart");
	}

	@Override
	public void setDefaultSize() {
		setSize(new Dimension(400, 232));
	}

	@Override
	public BaseDataModel2 getBaseDataModel() {
		return warehouseCardModel;
	}

	@Override
	public void setBaseDataModel(BaseDataModel2 bdm) {
		this.warehouseCardModel = (WarehouseCardModel) bdm;
	}

	@Override
	public void setNewBaseDataModel() {
		warehouseCardModel = new WarehouseCardModel(mainFrame);
	}

	@Override
	public void setDataState() {
		tfWarehouseCode.setText(warehouseCardModel.getWarehouseCode());
		tfWarehouseName.setText(warehouseCardModel.getWarehouseCode());
		taDescription.setText(warehouseCardModel.getWarehouseDescription());
	}

	@Override
	public String setPreCondition() {
		return null;
	}

	@Override
	public JTextField getMasterField() {
		return tfWarehouseCode;
	}

	@Override
	public String getModelMasterValue() {
		return warehouseCardModel.getWarehouseCode();
	}

	@Override
	public BaseCardSaveCommand<WarehouseCardFrame> getBaseSaveDataCommand() {
		return new WarehouseCardSaveController(this, new WarehouseCardEntryCleanController((MainFrame) mainFrame));
	}

	@Override
	public BaseCardDeleteCommand<WarehouseCardFrame> getBaseDeleteDataCommand() {
		return new WarehouseCardDeleteController(this, new WarehouseCardEntryCleanController((MainFrame) mainFrame));
	}

	@Override
	public void setMenuItems() {
		
	}

	@Override
	public boolean isCodeChangeCommandActive() {
		// TODO Auto-generated method stub
		return false;
	}
}