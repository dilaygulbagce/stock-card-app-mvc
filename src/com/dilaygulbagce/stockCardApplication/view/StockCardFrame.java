package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import tr.com.guru.common.command.BaseCardDeleteCommand;
import tr.com.guru.common.command.BaseCardSaveCommand;
import tr.com.guru.common.model.BaseDataModel2;
import tr.com.guru.common.view.BaseCardFrame;

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
	
	public StockCardFrame() {
		super(null);
				
		setBounds(100, 100, 428, 417);
		
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		
		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/search.png")));
		searchButton.setBounds(330, 50, 60, 30);
		getContentPane().add(searchButton);
		
		JLabel lblNewLabel = new JLabel("Stok Kodu:");
		lblNewLabel.setBounds(15, 55, 100, 20);
		getContentPane().add(lblNewLabel);
		
		tfStockCode = new JTextField();
		tfStockCode.setColumns(10);
		tfStockCode.setBounds(135, 55, 200, 20);
		tfStockCode.setDocument(new EntryLimit(StockCardModel.CODE_LIMIT));
		getContentPane().add(tfStockCode);
		
		JLabel lblNewLabel_1 = new JLabel("Stok Adı:");
		lblNewLabel_1.setBounds(15, 85, 100, 20);
		getContentPane().add(lblNewLabel_1);
		
		tfStockName = new JTextField();
		tfStockName.setColumns(10);
		tfStockName.setBounds(135, 85, 200, 20);
		tfStockName.setDocument(new EntryLimit(StockCardModel.NAME_LIMIT));
		getContentPane().add(tfStockName);
		
		JLabel lblNewLabel_8 = new JLabel("Depo Kodu:");
		lblNewLabel_8.setBounds(15, 115, 100, 20);
		getContentPane().add(lblNewLabel_8);
		
		cbWarehouseCode = new JComboBox<String>();
		cbWarehouseCode.setBounds(135, 115, 200, 22);
		getContentPane().add(cbWarehouseCode);
		
		JLabel lblNewLabel_2 = new JLabel("Stok Tipi:");
		lblNewLabel_2.setBounds(15, 145, 100, 20);
		getContentPane().add(lblNewLabel_2);
		
		cbStockType = new JComboBox<String>();
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
		cbStockType.setBounds(135, 145, 200, 22);
		getContentPane().add(cbStockType);
		
		JLabel lblNewLabel_3 = new JLabel("Birimi:");
		lblNewLabel_3.setBounds(15, 175, 100, 20);
		getContentPane().add(lblNewLabel_3);
		
		cbUnit = new JComboBox<String>();
		cbUnit.addItem(null);
		cbUnit.addItem("Adet");
		cbUnit.addItem("Kilogram");
		cbUnit.addItem("Litre");
		cbUnit.setBounds(135, 175, 200, 22);
		getContentPane().add(cbUnit);
		
		JLabel lblNewLabel_4 = new JLabel("Barkodu:");
		lblNewLabel_4.setBounds(15, 205, 100, 20);
		getContentPane().add(lblNewLabel_4);
		
		tfBarcode = new JTextField();
		tfBarcode.setColumns(10);
		tfBarcode.setBounds(135, 205, 200, 20);
		tfBarcode.setDocument(new EntryLimit(StockCardModel.BARCODE_LIMIT));
		getContentPane().add(tfBarcode);
		
		JLabel lblNewLabel_5 = new JLabel("KDV Tipi:");
		lblNewLabel_5.setBounds(15, 235, 100, 20);
		getContentPane().add(lblNewLabel_5);
		
		cbVATType = new JComboBox<Double>();
		cbVATType.addItem(null);
		cbVATType.addItem(0.01);
		cbVATType.addItem(0.08);
		cbVATType.addItem(0.18);
		cbVATType.setBounds(135, 235, 200, 22);
		getContentPane().add(cbVATType);
		
		JLabel lblNewLabel_6 = new JLabel("Oluşturma Tarihi:");
		lblNewLabel_6.setBounds(15, 265, 100, 20);
		getContentPane().add(lblNewLabel_6);
		
		jdcCreationDate = new JDateChooser();
		jdcCreationDate.setBounds(135, 265, 200, 20);
		getContentPane().add(jdcCreationDate);
		
		JLabel lblNewLabel_7 = new JLabel("Açıklama:");
		lblNewLabel_7.setBounds(15, 295, 100, 20);
		getContentPane().add(lblNewLabel_7);
		
		taDescription = new JTextArea();
		taDescription.setWrapStyleWord(true);
		taDescription.setBounds(135, 295, 200, 60);
		taDescription.setDocument(new EntryLimit(StockCardModel.DESCRIPTION_LIMIT));
		getContentPane().add(taDescription);
		
		insertButton = new JButton("");
//		insertButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/insert.png")));
//		insertButton.setBounds(5, 619, 55, 40);
		getContentPane().add(insertButton);
//		
		deleteButton = new JButton("");
//		deleteButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/delete.png")));
//		deleteButton.setBounds(72, 619, 55, 40);
		getContentPane().add(deleteButton);
//		
		copyButton = new JButton("");
//		copyButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/copy.png")));
//		copyButton.setBounds(139, 619, 55, 40);
		getContentPane().add(copyButton);
//		
		updateButton = new JButton("");
//		updateButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/update.png")));
//		updateButton.setBounds(206, 619, 55, 40);
		getContentPane().add(updateButton);
//		
		cleanButton = new JButton("");
//		cleanButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/clean.png")));
//		cleanButton.setBounds(273, 619, 55, 40);
		getContentPane().add(cleanButton);
	}

	@Override
	public void setDefaultSize() {
		
	}

	@Override
	public void setTitle() {
		setTitle("Stok Kart");
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
