package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class StockCardListFrame extends JInternalFrame {
	
	public JTable stockCardTable;
	public JButton listButton;

	public StockCardListFrame() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Stok Kart Listesi");
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 750, 745);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		stockCardTable = new JTable();
		scrollPane.setViewportView(stockCardTable);
		stockCardTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		stockCardTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stok Kodu", "Stok Adı", "Depo Kodu", "Stok Tipi", "Birim", "Barkod", "KDV Tipi", "Oluşturma Tarihi", "Açıklama"
			}
		)
		);
		
		listButton = new JButton("Listele");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(631)
					.addComponent(listButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(listButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}