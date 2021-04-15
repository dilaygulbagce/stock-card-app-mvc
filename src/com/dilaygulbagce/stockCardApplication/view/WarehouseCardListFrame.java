package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class WarehouseCardListFrame extends JInternalFrame {
	
	public JTable warehouseCardTable;
	
	public JButton listButton;

	public WarehouseCardListFrame() {
		setResizable(true);
		setTitle("Depo Kart Listesi");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 689, 484);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		listButton = new JButton("Listele");
		listButton.setBounds(551, 6, 117, 29);
		getContentPane().add(listButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 675, 420);
		getContentPane().add(scrollPane);
		
		warehouseCardTable = new JTable();
		warehouseCardTable.setForeground(Color.BLACK);
		scrollPane.setViewportView(warehouseCardTable);
		warehouseCardTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		warehouseCardTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Depo ID", "Depo Kodu", "Depo Adı", "Açıklama"
			}
		));
	}
}
