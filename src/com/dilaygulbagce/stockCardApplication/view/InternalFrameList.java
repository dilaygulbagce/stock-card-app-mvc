package com.dilaygulbagce.stockCardApplication.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class InternalFrameList extends JInternalFrame {
	public JTable table;
	
	public JButton listButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalFrameList frame = new InternalFrameList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InternalFrameList() {
		setTitle("Stok Kartları");
		setClosable(true);
		setResizable(true);
		setBounds(100, 100, 800, 570);
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		listButton = new JButton("Listele");
		listButton.setBounds(685, 0, 89, 23);
		getContentPane().add(listButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 27, 784, 513);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stok Kodu", "Stok Adı", "Stok Tipi", "Birim", "Barkod", "KDV Tipi", "Oluşturma Tarihi", "Açıklama"
			}
		)
		);
	}
}
