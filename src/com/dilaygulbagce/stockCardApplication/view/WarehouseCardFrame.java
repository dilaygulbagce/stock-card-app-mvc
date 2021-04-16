package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dilaygulbagce.stockCardApplication.utility.EntryLimit;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class WarehouseCardFrame extends JInternalFrame {
	
	public JTextField tfSearchBar;
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
		setBounds(100, 100, 337, 331);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		tfSearchBar = new JTextField();
		tfSearchBar.setColumns(10);
		tfSearchBar.setBounds(6, 22, 200, 23);
		tfSearchBar.setDocument(new EntryLimit(15));
		getContentPane().add(tfSearchBar);
		
		JLabel lblNewLabel_1 = new JLabel("Depo Kodu:");
		lblNewLabel_1.setBounds(6, 75, 100, 16);
		getContentPane().add(lblNewLabel_1);
		
		tfWarehouseCode = new JTextField();
		tfWarehouseCode.setBounds(107, 73, 200, 20);
		tfWarehouseCode.setDocument(new EntryLimit(15));
		getContentPane().add(tfWarehouseCode);
		tfWarehouseCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Depo Adı:");
		lblNewLabel_2.setBounds(6, 115, 100, 16);
		getContentPane().add(lblNewLabel_2);
		
		tfWarehouseName = new JTextField();
		tfWarehouseName.setBounds(107, 113, 200, 20);
		tfWarehouseName.setDocument(new EntryLimit(50));
		getContentPane().add(tfWarehouseName);
		tfWarehouseName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Açıklama:");
		lblNewLabel_3.setBounds(6, 155, 100, 16);
		getContentPane().add(lblNewLabel_3);
		
		taWarehouseDescription = new JTextArea();
		taWarehouseDescription.setBounds(107, 155, 200, 50);
		taWarehouseDescription.setDocument(new EntryLimit(100));
		getContentPane().add(taWarehouseDescription);
		
		insertButton = new JButton("");
		insertButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/insert.png")));
		insertButton.setBounds(28, 227, 55, 40);
		getContentPane().add(insertButton);
		
		deleteButton = new JButton("");
		deleteButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/delete.png")));
		deleteButton.setBounds(95, 227, 55, 40);
		getContentPane().add(deleteButton);
		
		updateButton = new JButton("");
		updateButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/update.png")));
		updateButton.setBounds(162, 227, 55, 40);
		getContentPane().add(updateButton);
		
		cleanButton = new JButton("");
		cleanButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/clean.png")));
		cleanButton.setBounds(229, 227, 55, 40);
		getContentPane().add(cleanButton);
		
		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(WarehouseCardFrame.class.getResource("/com/dilaygulbagce/stockCardApplication/resource/search.png")));
		searchButton.setBounds(208, 22, 91, 23);
		getContentPane().add(searchButton);

	}
}
