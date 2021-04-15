package com.dilaygulbagce.stockCardApplication.view;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class StockCardListFrame extends JInternalFrame {
	
	public JTable stockCardTable;
	
	public JButton listButton;

	public StockCardListFrame() {
		setIconifiable(true);
		setTitle("Stok Kart Listesi");
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 800, 570);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		listButton = new JButton("Listele");
		listButton.setBounds(681, 6, 89, 23);
		getContentPane().add(listButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 35, 776, 489);
		getContentPane().add(scrollPane);
		
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
	}
}
