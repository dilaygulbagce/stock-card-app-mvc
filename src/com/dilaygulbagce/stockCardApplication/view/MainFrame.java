package com.dilaygulbagce.stockCardApplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Toolkit;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	static JDesktopPane desktopPane;
	public StockCardFrame stockCardFrame;
	public StockCardListFrame stockCardListFrame;
	public WarehouseCardFrame warehouseCardFrame;
	public WarehouseCardListFrame warehouseCardListFrame;
	public JMenuItem stockCardMenuItem;
	public JMenuItem stockCardListMenuItem;
	public JMenuItem warehouseCardMenuItem;
	public JMenuItem warehouseCardListMenuItem;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 750);
		
		setTitle("Ana Ekran");
		setLocationRelativeTo(null);
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu stockMenu = new JMenu("Stok");
		menuBar.add(stockMenu);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		
		stockCardFrame = new StockCardFrame();
		desktopPane.add(stockCardFrame);
		
		stockCardListFrame = new StockCardListFrame();
		desktopPane.add(stockCardListFrame);
		
		warehouseCardFrame = new WarehouseCardFrame();
		desktopPane.add(warehouseCardFrame);
		
		warehouseCardListFrame = new WarehouseCardListFrame();
		desktopPane.add(warehouseCardListFrame);
		
		getContentPane().add(desktopPane);
			
		stockCardMenuItem = new JMenuItem("Stok Kartı İşlemleri");
		stockMenu.add(stockCardMenuItem);
		
		stockCardListMenuItem = new JMenuItem("Stok Kartlarını Listele");
		stockMenu.add(stockCardListMenuItem);
		
		warehouseCardMenuItem = new JMenuItem("Depo Kartı İşlemleri");
		stockMenu.add(warehouseCardMenuItem);
		
		warehouseCardListMenuItem = new JMenuItem("Depo Kartlarını Listele");
		stockMenu.add(warehouseCardListMenuItem);
	}
}
