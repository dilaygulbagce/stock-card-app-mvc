package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class WarehouseCardFrame extends JInternalFrame {
	
	public JTextField tfSearchBar;
	public JTextField tfWarehouseID;
	public JTextField tfWarehouseCode;
	public JTextField tfWarehouseName;
	
	public JTextArea taWarehouseDescription;
	
	public JButton insertButton;
	public JButton deleteButton;
	public JButton updateButton;
	public JButton cleanButton;
	public JButton searchButton;

	public WarehouseCardFrame() {
		setTitle("Depo Kart");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 445, 484);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		tfSearchBar = new JTextField();
		tfSearchBar.setColumns(10);
		tfSearchBar.setBounds(56, 49, 200, 23);
		getContentPane().add(tfSearchBar);
		
		JLabel lblNewLabel = new JLabel("Depo ID:");
		lblNewLabel.setBounds(47, 121, 100, 16);
		getContentPane().add(lblNewLabel);
		
		tfWarehouseID = new JTextField();
		tfWarehouseID.setBounds(171, 116, 200, 20);
		getContentPane().add(tfWarehouseID);
		tfWarehouseID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Depo Kodu:");
		lblNewLabel_1.setBounds(47, 161, 100, 16);
		getContentPane().add(lblNewLabel_1);
		
		tfWarehouseCode = new JTextField();
		tfWarehouseCode.setBounds(171, 156, 200, 20);
		getContentPane().add(tfWarehouseCode);
		tfWarehouseCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Depo Adı:");
		lblNewLabel_2.setBounds(47, 201, 100, 16);
		getContentPane().add(lblNewLabel_2);
		
		tfWarehouseName = new JTextField();
		tfWarehouseName.setBounds(171, 199, 200, 20);
		getContentPane().add(tfWarehouseName);
		tfWarehouseName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Açıklama:");
		lblNewLabel_3.setBounds(47, 241, 100, 16);
		getContentPane().add(lblNewLabel_3);
		
		taWarehouseDescription = new JTextArea();
		taWarehouseDescription.setBounds(171, 241, 200, 50);
		getContentPane().add(taWarehouseDescription);
		
		insertButton = new JButton("");
		insertButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/insert.png")));
		insertButton.setBounds(47, 345, 55, 40);
		getContentPane().add(insertButton);
		
		deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/delete.png")));
		deleteButton.setBounds(137, 345, 55, 40);
		getContentPane().add(deleteButton);
		
		updateButton = new JButton("");
		updateButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/update.png")));
		updateButton.setBounds(230, 345, 55, 40);
		getContentPane().add(updateButton);
		
		cleanButton = new JButton("");
		cleanButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/clean.png")));
		cleanButton.setBounds(316, 345, 55, 40);
		getContentPane().add(cleanButton);
		
		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/search.png")));
		searchButton.setBounds(269, 45, 91, 30);
		getContentPane().add(searchButton);

	}
}
