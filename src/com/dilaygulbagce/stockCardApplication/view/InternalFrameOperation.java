package com.dilaygulbagce.stockCardApplication.view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

public class InternalFrameOperation extends JInternalFrame {
	public JTextField tfSearchBar;
	public JTextField tfStockCode;
	public JTextField tfStockName;
	public JTextField tfBarcode;
	
	public JComboBox<String> cbUnit;
	public JComboBox<String> cbStockType;
	public JComboBox<Double> cbVATType;
	
	public JDateChooser jdcCreationDate;
	
	public JTextArea taDescription;
	
	public JButton insertButton;
	public JButton deleteButton;
	public JButton updateButton;
	public JButton copyButton;
	public JButton cleanButton;
	public JButton searchButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameOperation frame = new InternalFrameOperation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InternalFrameOperation() {
		setTitle("Stok Kartı İşlemleri");
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 445, 570);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		tfSearchBar = new JTextField();
		tfSearchBar.setColumns(10);
		tfSearchBar.setBounds(63, 29, 200, 23);
		getContentPane().add(tfSearchBar);
		
		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon("C:\\Users\\dilay\\OneDrive\\Masa\u00FCst\u00FC\\stockCardV2\\stockCardApp\\src\\view\\icons\\search.png"));
		searchButton.setBounds(279, 29, 91, 25);
		getContentPane().add(searchButton);
		
		JLabel lblNewLabel = new JLabel("Stok Kodu:");
		lblNewLabel.setBounds(41, 84, 100, 16);
		getContentPane().add(lblNewLabel);
		
		tfStockCode = new JTextField();
		tfStockCode.setColumns(10);
		tfStockCode.setBounds(151, 82, 200, 20);
		getContentPane().add(tfStockCode);
		
		tfStockName = new JTextField();
		tfStockName.setColumns(10);
		tfStockName.setBounds(151, 121, 200, 20);
		getContentPane().add(tfStockName);
		
		JLabel lblNewLabel_1 = new JLabel("Stok Adı:");
		lblNewLabel_1.setBounds(41, 124, 100, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stok Tipi:");
		lblNewLabel_2.setBounds(41, 164, 100, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Birimi:");
		lblNewLabel_3.setBounds(41, 204, 100, 15);
		getContentPane().add(lblNewLabel_3);
		
		cbUnit = new JComboBox<String>();
		cbUnit.addItem(null);
		cbUnit.addItem("Adet");
		cbUnit.addItem("Kilogram");
		cbUnit.addItem("Litre");
		cbUnit.setBounds(151, 200, 200, 22);
		getContentPane().add(cbUnit);
		
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
		cbStockType.setBounds(151, 160, 200, 22);
		getContentPane().add(cbStockType);
		
		JLabel lblNewLabel_4 = new JLabel("Barkodu:");
		lblNewLabel_4.setBounds(41, 244, 100, 15);
		getContentPane().add(lblNewLabel_4);
		
		tfBarcode = new JTextField();
		tfBarcode.setColumns(10);
		tfBarcode.setBounds(151, 241, 200, 20);
		getContentPane().add(tfBarcode);
		
		JLabel lblNewLabel_5 = new JLabel("KDV Tipi:");
		lblNewLabel_5.setBounds(41, 284, 100, 15);
		getContentPane().add(lblNewLabel_5);
		
		cbVATType = new JComboBox<Double>();
		cbVATType.addItem(null);
		cbVATType.addItem(0.01);
		cbVATType.addItem(0.08);
		cbVATType.addItem(0.18);
		cbVATType.setBounds(151, 280, 200, 22);
		getContentPane().add(cbVATType);
		
		JLabel lblNewLabel_6 = new JLabel("Oluşturma Tarihi:");
		lblNewLabel_6.setBounds(41, 324, 100, 15);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Açıklama:");
		lblNewLabel_7.setBounds(41, 364, 100, 15);
		getContentPane().add(lblNewLabel_7);
		
		taDescription = new JTextArea();
		taDescription.setWrapStyleWord(true);
		taDescription.setBounds(151, 359, 200, 60);
		getContentPane().add(taDescription);
		
		insertButton = new JButton("");
		insertButton.setIcon(new ImageIcon("C:\\Users\\dilay\\OneDrive\\Masa\u00FCst\u00FC\\stockCardV2\\stockCardApp\\src\\view\\icons\\insert.png"));
		insertButton.setBounds(31, 452, 50, 35);
		getContentPane().add(insertButton);
		
		deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon("C:\\Users\\dilay\\OneDrive\\Masa\u00FCst\u00FC\\stockCardV2\\stockCardApp\\src\\view\\icons\\delete.png"));
		deleteButton.setBounds(111, 452, 50, 35);
		getContentPane().add(deleteButton);
		
		copyButton = new JButton("");
		copyButton.setIcon(new ImageIcon("C:\\Users\\dilay\\OneDrive\\Masa\u00FCst\u00FC\\stockCardV2\\stockCardApp\\src\\view\\icons\\copy.png"));
		copyButton.setBounds(191, 452, 50, 35);
		getContentPane().add(copyButton);
		
		updateButton = new JButton("");
		updateButton.setIcon(new ImageIcon("C:\\Users\\dilay\\OneDrive\\Masa\u00FCst\u00FC\\stockCardV2\\stockCardApp\\src\\view\\icons\\update.png"));
		updateButton.setBounds(271, 452, 50, 35);
		getContentPane().add(updateButton);
		
		cleanButton = new JButton("");
		cleanButton.setIcon(new ImageIcon("C:\\Users\\dilay\\OneDrive\\Masa\u00FCst\u00FC\\stockCardV2\\stockCardApp\\src\\view\\icons\\clean.png"));
		cleanButton.setBounds(351, 452, 50, 35);
		getContentPane().add(cleanButton);
		
		jdcCreationDate = new JDateChooser();
		jdcCreationDate.setBounds(151, 319, 200, 20);
		getContentPane().add(jdcCreationDate);
	}
}
