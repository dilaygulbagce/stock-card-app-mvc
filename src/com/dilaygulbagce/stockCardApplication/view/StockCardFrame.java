package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;
import com.dilaygulbagce.stockCardApplication.model.StockCardModel;
import com.dilaygulbagce.stockCardApplication.utility.EntryLimit;

@SuppressWarnings("serial")
public class StockCardFrame extends JInternalFrame {
	
	public JTextField tfSearchBar;
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
		
		setIconifiable(true);
		setTitle("Stok Kart");
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 361, 745);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		tfSearchBar = new JTextField();
		tfSearchBar.setColumns(10);
		tfSearchBar.setBounds(16, 36, 200, 23);
		tfSearchBar.setDocument(new EntryLimit(StockCardModel.CODE_LIMIT));
		getContentPane().add(tfSearchBar);
		
		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/search.png")));
		searchButton.setBounds(225, 31, 91, 30);
		getContentPane().add(searchButton);
		
		JLabel lblNewLabel = new JLabel("Stok Kodu:");
		lblNewLabel.setBounds(16, 108, 100, 16);
		getContentPane().add(lblNewLabel);
		
		tfStockCode = new JTextField();
		tfStockCode.setColumns(10);
		tfStockCode.setBounds(128, 106, 200, 20);
		tfStockCode.setDocument(new EntryLimit(StockCardModel.CODE_LIMIT));
		getContentPane().add(tfStockCode);
		
		JLabel lblNewLabel_1 = new JLabel("Stok Adı:");
		lblNewLabel_1.setBounds(16, 158, 100, 15);
		getContentPane().add(lblNewLabel_1);
		
		tfStockName = new JTextField();
		tfStockName.setColumns(10);
		tfStockName.setBounds(128, 155, 200, 20);
		tfStockName.setDocument(new EntryLimit(StockCardModel.NAME_LIMIT));
		getContentPane().add(tfStockName);
		
		JLabel lblNewLabel_8 = new JLabel("Depo Kodu:");
		lblNewLabel_8.setBounds(16, 208, 100, 16);
		getContentPane().add(lblNewLabel_8);
		
		cbWarehouseCode = new JComboBox<String>();
		cbWarehouseCode.setBounds(128, 204, 200, 27);
		getContentPane().add(cbWarehouseCode);
		
		JLabel lblNewLabel_2 = new JLabel("Stok Tipi:");
		lblNewLabel_2.setBounds(16, 258, 100, 15);
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
		cbStockType.setBounds(128, 255, 200, 22);
		getContentPane().add(cbStockType);
		
		JLabel lblNewLabel_3 = new JLabel("Birimi:");
		lblNewLabel_3.setBounds(16, 308, 100, 15);
		getContentPane().add(lblNewLabel_3);
		
		cbUnit = new JComboBox<String>();
		cbUnit.addItem(null);
		cbUnit.addItem("Adet");
		cbUnit.addItem("Kilogram");
		cbUnit.addItem("Litre");
		cbUnit.setBounds(128, 305, 200, 22);
		getContentPane().add(cbUnit);
		
		JLabel lblNewLabel_4 = new JLabel("Barkodu:");
		lblNewLabel_4.setBounds(16, 358, 100, 15);
		getContentPane().add(lblNewLabel_4);
		
		tfBarcode = new JTextField();
		tfBarcode.setColumns(10);
		tfBarcode.setBounds(128, 355, 200, 20);
		tfBarcode.setDocument(new EntryLimit(StockCardModel.BARCODE_LIMIT));
		getContentPane().add(tfBarcode);
		
		JLabel lblNewLabel_5 = new JLabel("KDV Tipi:");
		lblNewLabel_5.setBounds(16, 408, 100, 15);
		getContentPane().add(lblNewLabel_5);
		
		cbVATType = new JComboBox<Double>();
		cbVATType.addItem(null);
		cbVATType.addItem(0.01);
		cbVATType.addItem(0.08);
		cbVATType.addItem(0.18);
		cbVATType.setBounds(128, 405, 200, 22);
		getContentPane().add(cbVATType);
		
		JLabel lblNewLabel_6 = new JLabel("Oluşturma Tarihi:");
		lblNewLabel_6.setBounds(16, 458, 100, 15);
		getContentPane().add(lblNewLabel_6);
		
		jdcCreationDate = new JDateChooser();
		jdcCreationDate.setBounds(128, 453, 200, 20);
		getContentPane().add(jdcCreationDate);
		
		JLabel lblNewLabel_7 = new JLabel("Açıklama:");
		lblNewLabel_7.setBounds(16, 508, 100, 15);
		getContentPane().add(lblNewLabel_7);
		
		taDescription = new JTextArea();
		taDescription.setWrapStyleWord(true);
		taDescription.setBounds(128, 507, 200, 60);
		taDescription.setDocument(new EntryLimit(StockCardModel.DESCRIPTION_LIMIT));
		getContentPane().add(taDescription);
		
		insertButton = new JButton("");
		insertButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/insert.png")));
		insertButton.setBounds(5, 619, 55, 40);
		getContentPane().add(insertButton);
		
		deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/delete.png")));
		deleteButton.setBounds(72, 619, 55, 40);
		getContentPane().add(deleteButton);
		
		copyButton = new JButton("");
		copyButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/copy.png")));
		copyButton.setBounds(139, 619, 55, 40);
		getContentPane().add(copyButton);
		
		updateButton = new JButton("");
		updateButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/update.png")));
		updateButton.setBounds(206, 619, 55, 40);
		getContentPane().add(updateButton);
		
		cleanButton = new JButton("");
		cleanButton.setIcon(new ImageIcon(StockCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/clean.png")));
		cleanButton.setBounds(273, 619, 55, 40);
		getContentPane().add(cleanButton);
	}
}
