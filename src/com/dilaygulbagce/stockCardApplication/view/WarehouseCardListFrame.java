package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JInternalFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class WarehouseCardListFrame extends JInternalFrame {
	
	public JTable warehouseCardTable;
	public JButton listButton;

	public WarehouseCardListFrame() {
		setResizable(true);
		setTitle("Depo Kart Listesi");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 315, 400);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 313, 347);
		
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
		
		listButton = new JButton("Listele");
		listButton.setBounds(197, 6, 110, 29);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(217, Short.MAX_VALUE)
					.addComponent(listButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(listButton)
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
