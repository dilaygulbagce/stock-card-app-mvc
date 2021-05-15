package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dilaygulbagce.stockCardApplication.model.WarehouseCardModel;
import com.dilaygulbagce.stockCardApplication.utility.EntryLimit;

import tr.com.guru.common.command.BaseCardDeleteCommand;
import tr.com.guru.common.command.BaseCardSaveCommand;
import tr.com.guru.common.model.BaseDataModel2;
import tr.com.guru.common.view.BaseCardFrame;

import javax.swing.JTextArea;

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

	public WarehouseCardFrame() {
		super(null);
	
		setBounds(100, 100, 400, 232);
		
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		JLabel lblNewLabel_1 = new JLabel("Depo Kodu:");
		lblNewLabel_1.setBounds(15, 55, 100, 20);
		getContentPane().add(lblNewLabel_1);
		
		tfWarehouseCode = new JTextField();
		tfWarehouseCode.setBounds(115, 55, 200, 20);
		tfWarehouseCode.setDocument(new EntryLimit(WarehouseCardModel.CODE_LIMIT));
		getContentPane().add(tfWarehouseCode);
		tfWarehouseCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Depo Adı:");
		lblNewLabel_2.setBounds(15, 85, 100, 20);
		getContentPane().add(lblNewLabel_2);
		
		tfWarehouseName = new JTextField();
		tfWarehouseName.setBounds(115, 85, 200, 20);
		tfWarehouseName.setDocument(new EntryLimit(WarehouseCardModel.NAME_LIMIT));
		getContentPane().add(tfWarehouseName);
		tfWarehouseName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Açıklama:");
		lblNewLabel_3.setBounds(15, 115, 100, 20);
		getContentPane().add(lblNewLabel_3);
		
		taDescription = new JTextArea();
		taDescription.setBounds(115, 115, 200, 50);
		taDescription.setDocument(new EntryLimit(WarehouseCardModel.DESCRIPTION_LIMIT));
		getContentPane().add(taDescription);
		
		insertButton = new JButton("");
		insertButton.setBounds(0, 0, 0, 0);
//		insertButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/insert.png")));
//		insertButton.setBounds(28, 227, 55, 40);
		getContentPane().add(insertButton);
		
		deleteButton = new JButton("");
		deleteButton.setBounds(0, 0, 0, 0);
//		deleteButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/delete.png")));
//		deleteButton.setBounds(95, 227, 55, 40);
		getContentPane().add(deleteButton);
		
		updateButton = new JButton("");
		updateButton.setBounds(0, 0, 0, 0);
//		updateButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/update.png")));
//		updateButton.setBounds(162, 227, 55, 40);
		getContentPane().add(updateButton);
		
		cleanButton = new JButton("");
		cleanButton.setBounds(0, 0, 0, 0);
//		cleanButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/clean.png")));
//		cleanButton.setBounds(229, 227, 55, 40);
		getContentPane().add(cleanButton);
		
		searchButton = new JButton("");
		searchButton.setBounds(312, 50, 60, 30);
		searchButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/search.png")));
		getContentPane().add(searchButton);

	}

	@Override
	public void setTitle() {
		setTitle("Depo Kart");
	}

	@Override
	public void setDefaultSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseDataModel2 getBaseDataModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBaseDataModel(BaseDataModel2 bdm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNewBaseDataModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDataState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String setPreCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTextField getMasterField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModelMasterValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseCardSaveCommand getBaseSaveDataCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseCardDeleteCommand getBaseDeleteDataCommand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMenuItems() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCodeChangeCommandActive() {
		// TODO Auto-generated method stub
		return false;
	}
}