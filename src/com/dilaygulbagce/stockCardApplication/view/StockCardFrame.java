package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import com.toedter.calendar.JDateChooser;

import tr.com.guru.common.command.BaseCardDeleteCommand;
import tr.com.guru.common.command.BaseCardSaveCommand;
import tr.com.guru.common.model.BaseDataModel2;
import tr.com.guru.common.view.BaseCardFrame;
import tr.com.guru.common.view.FindButton;
import tr.com.guru.common.view.LimitedTextField;
import tr.com.guru.common.view.MainFrameInterface;

import com.dilaygulbagce.stockCardApplication.controller.StockCardDeleteController;
import com.dilaygulbagce.stockCardApplication.controller.StockCardSaveController;
import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.utility.EntryLimit;

@SuppressWarnings("serial")
public class StockCardFrame extends BaseCardFrame {

	public JTextField tfStockCode;
	public JTextField tfStockName;
	public JTextField tfBarcode;

	public JComboBox<String> cbUnit;
	public JComboBox<String> cbStockType;
	public JComboBox<Double> cbVATType;
	public JComboBox<String> cbWarehouseCode;

	public JDateChooser jdcCreationDate;

	public JTextArea taDescription;

	public JButton insertButton;
	public JButton deleteButton;
	public JButton updateButton;
	public JButton copyButton;
	public JButton cleanButton;
	public JButton searchButton;
	
	public StockCardModel stockCardModel;

	public StockCardFrame(MainFrameInterface mainFrame) {
		super(mainFrame);
		
		setNewBaseDataModel();

		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);

		GridBagLayout gridBagLayout = (GridBagLayout) centerPanel.getLayout();
		gridBagLayout.columnWidths = new int[]{41, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		
		JLabel codeLabel= new JLabel("Stok Kodu: ");
		GridBagConstraints gbc_codeLabel= new GridBagConstraints();
		gbc_codeLabel.anchor = GridBagConstraints.WEST;
		gbc_codeLabel.gridx = 0;
		gbc_codeLabel.gridy = 0;
		centerPanel.add(codeLabel, gbc_codeLabel);
		
		tfStockCode = new LimitedTextField(20, StockCardModel.CODE_LIMIT);
		GridBagConstraints gbc_tfStockCode = new GridBagConstraints();
		gbc_tfStockCode.anchor = GridBagConstraints.WEST;
		gbc_tfStockCode.gridx = 1;
		gbc_tfStockCode.gridy = 0;
		centerPanel.add(tfStockCode, gbc_tfStockCode);
		
		searchButton = new FindButton();
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.anchor = GridBagConstraints.WEST;
		gbc_searchButton.gridx = 2;
		gbc_searchButton.gridy = 0;
		centerPanel.add(searchButton, gbc_searchButton);

		JLabel nameLabel = new JLabel("Stok Adı: ");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 1;
		centerPanel.add(nameLabel, gbc_nameLabel);

		tfStockName = new LimitedTextField(20, StockCardModel.NAME_LIMIT);
		GridBagConstraints gbc_tfStockName = new GridBagConstraints();
		gbc_tfStockName.anchor = GridBagConstraints.WEST;
		gbc_tfStockName.gridx = 1;
		gbc_tfStockName.gridy = 1;
		centerPanel.add(tfStockName, gbc_tfStockName);
		
		JLabel warehouseCodeLabel = new JLabel("Depo Kodu: ");
		GridBagConstraints gbc_warehouseCodeLabel = new GridBagConstraints();
		gbc_warehouseCodeLabel.anchor = GridBagConstraints.WEST;
		gbc_warehouseCodeLabel.gridx = 0;
		gbc_warehouseCodeLabel.gridy = 2;
		centerPanel.add(warehouseCodeLabel, gbc_warehouseCodeLabel);
		
		cbWarehouseCode = new JComboBox<String>();
		GridBagConstraints gbc_cbWarehouseCode = new GridBagConstraints();
		gbc_cbWarehouseCode.anchor = GridBagConstraints.WEST;
		gbc_cbWarehouseCode.gridx = 1;
		gbc_cbWarehouseCode.gridy = 2;
		centerPanel.add(cbWarehouseCode, gbc_cbWarehouseCode);
		
		JLabel typeLabel = new JLabel("Stok Tipi: ");
		GridBagConstraints gbc_typeLabel = new GridBagConstraints();
		gbc_typeLabel.anchor = GridBagConstraints.WEST;
		gbc_typeLabel.gridx = 0;
		gbc_typeLabel.gridy = 3;
		centerPanel.add(typeLabel, gbc_typeLabel);
		
		cbStockType = new JComboBox<String>();
		GridBagConstraints gbc_cbStockType = new GridBagConstraints();
		cbStockType.addItem(null);
		cbStockType.addItem("Süt ve Süt Ürünleri");
		cbStockType.addItem("Et ve Et Ürünleri");
		cbStockType.addItem("Yağ");
		cbStockType.addItem("Meyve ve Sebze Ürünleri");
		cbStockType.addItem("Konserve Gıda");
		cbStockType.addItem("Dondurulmuş Gıda");
		cbStockType.addItem("Kuru Gıda");
		cbStockType.addItem("Unlu Mamüller");
		cbStockType.addItem("Su Ürünleri");
		gbc_cbStockType.anchor = GridBagConstraints.WEST;
		gbc_cbStockType.gridx = 1;
		gbc_cbStockType.gridy = 3;
		centerPanel.add(cbStockType, gbc_cbStockType);
		
		JLabel unitLabel = new JLabel("Birimi: ");
		GridBagConstraints gbc_unitLabel = new GridBagConstraints();
		gbc_unitLabel.anchor = GridBagConstraints.WEST;
		gbc_unitLabel.gridx = 0;
		gbc_unitLabel.gridy = 4;
		centerPanel.add(unitLabel, gbc_unitLabel);
		
		cbUnit = new JComboBox<String>();
		GridBagConstraints gbc_cbUnit = new GridBagConstraints();
		cbUnit.addItem(null);
		cbUnit.addItem("Adet");
		cbUnit.addItem("Kilogram");
		cbUnit.addItem("Litre");
		gbc_cbUnit.anchor = GridBagConstraints.WEST;
		gbc_cbUnit.gridx = 1;
		gbc_cbUnit.gridy = 4;
		centerPanel.add(cbUnit, gbc_cbUnit);
		
		JLabel barcodeLabel = new JLabel("Barkod: ");
		GridBagConstraints gbc_barcodeLabel = new GridBagConstraints();
		gbc_barcodeLabel.anchor = GridBagConstraints.WEST;
		gbc_barcodeLabel.gridx = 0;
		gbc_barcodeLabel.gridy = 5;
		centerPanel.add(barcodeLabel, gbc_barcodeLabel);

		tfBarcode = new LimitedTextField(20, StockCardModel.BARCODE_LIMIT);
		GridBagConstraints gbc_tfBarcode = new GridBagConstraints();
		gbc_tfBarcode.anchor = GridBagConstraints.WEST;
		gbc_tfBarcode.gridx = 1;
		gbc_tfBarcode.gridy = 5;
		centerPanel.add(tfBarcode, gbc_tfBarcode);
		
		JLabel vatLabel = new JLabel("KDV Tipi: ");
		GridBagConstraints gbc_vatLabel = new GridBagConstraints();
		gbc_vatLabel.anchor = GridBagConstraints.WEST;
		gbc_vatLabel.gridx = 0;
		gbc_vatLabel.gridy = 6;
		centerPanel.add(vatLabel, gbc_vatLabel);
		
		cbVATType = new JComboBox<Double>();
		GridBagConstraints gbc_cbVATType = new GridBagConstraints();
		cbVATType.addItem(null);
		cbVATType.addItem(0.01);
		cbVATType.addItem(0.08);
		cbVATType.addItem(0.18);
		gbc_cbVATType.anchor = GridBagConstraints.WEST;
		gbc_cbVATType.gridx = 1;
		gbc_cbVATType.gridy = 6;
		centerPanel.add(cbVATType, gbc_cbVATType);
		
		JLabel dateLabel = new JLabel("Oluşturma Tarihi: ");
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.anchor = GridBagConstraints.WEST;
		gbc_dateLabel.gridx = 0;
		gbc_dateLabel.gridy = 7;
		centerPanel.add(dateLabel, gbc_dateLabel);

		jdcCreationDate = new JDateChooser();
		GridBagConstraints gbc_jdcCreationDate = new GridBagConstraints();
		gbc_jdcCreationDate.anchor = GridBagConstraints.WEST;
		gbc_jdcCreationDate.gridx = 1;
		gbc_jdcCreationDate.gridy = 7;
		centerPanel.add(jdcCreationDate, gbc_jdcCreationDate);
		
		JLabel descriptionLabel = new JLabel("Açıklama");
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.anchor = GridBagConstraints.WEST;
		gbc_descriptionLabel.gridx = 0;
		gbc_descriptionLabel.gridy = 8;
		centerPanel.add(descriptionLabel, gbc_descriptionLabel);

		taDescription = new JTextArea(3, 20);
		taDescription.setDocument(new EntryLimit(StockCardModel.DESCRIPTION_LIMIT));
		GridBagConstraints gbc_taDescription = new GridBagConstraints();
		gbc_taDescription.anchor = GridBagConstraints.WEST;
		gbc_taDescription.gridx = 1;
		gbc_taDescription.gridy = 8;
		centerPanel.add(taDescription, gbc_taDescription);

//		insertButton = new JButton("");
//		insertButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/insert.png")));
//		insertButton.setBounds(5, 619, 55, 40);
//		getContentPane().add(insertButton);
//		
//		deleteButton = new JButton("");
//		deleteButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/delete.png")));
//		deleteButton.setBounds(72, 619, 55, 40);
//		getContentPane().add(deleteButton);
//		
		copyButton = new JButton("");
//		copyButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/copy.png")));
//		copyButton.setBounds(139, 619, 55, 40);
//		getContentPane().add(copyButton);
//		
		updateButton = new JButton("");
//		updateButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/update.png")));
//		updateButton.setBounds(206, 619, 55, 40);
//		getContentPane().add(updateButton);
//		
		cleanButton = new JButton("");
//		cleanButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/clean.png")));
//		cleanButton.setBounds(273, 619, 55, 40);
//		getContentPane().add(cleanButton);
	}

	@Override
	public void setDefaultSize() {
		setSize(new Dimension(428, 417));
	}

	@Override
	public void setTitle() {
		setTitle("Stok Kart");
	}

	@Override
	public BaseDataModel2 getBaseDataModel() {
		return stockCardModel;
	}

	@Override
	public void setBaseDataModel(BaseDataModel2 bdm) {
		this.stockCardModel = (StockCardModel) bdm;
	}

	@Override
	public void setNewBaseDataModel() {
		stockCardModel = new StockCardModel(mainFrame);
	}

	@Override
	public void setDataState() {
		tfStockCode.setText(stockCardModel.getStockCode());
		tfStockName.setText(stockCardModel.getStockName());
		cbWarehouseCode.setSelectedItem(stockCardModel.getWarehouseCode());
		cbStockType.setSelectedIndex(stockCardModel.getStockType());
		cbUnit.setSelectedItem(stockCardModel.getStockUnit());
		tfBarcode.setText(stockCardModel.getStockBarcode());
		cbVATType.setSelectedItem(stockCardModel.getVatType());
		jdcCreationDate.setDate(stockCardModel.getCreationDate());
		taDescription.setText(stockCardModel.getDescription());
	}

	@Override
	public String setPreCondition() {
		return null;
	}

	@Override
	public JTextField getMasterField() {
		return tfStockCode;
	}

	@Override
	public String getModelMasterValue() {
		return stockCardModel.getStockCode();
	}

	@Override
	public BaseCardSaveCommand<StockCardFrame> getBaseSaveDataCommand() {
		return new StockCardSaveController(this);
	}

	@Override
	public BaseCardDeleteCommand<StockCardFrame> getBaseDeleteDataCommand() {
		return new StockCardDeleteController(this);
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
