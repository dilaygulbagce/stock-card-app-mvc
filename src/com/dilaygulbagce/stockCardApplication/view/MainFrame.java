package com.dilaygulbagce.stockCardApplication.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	static JFrame frame;
	static JDesktopPane desktopPane;
	public InternalFrameOperation iFrameOperation;
	public InternalFrameList iFrameList;
	public JMenuItem menuItemOperation;
	public JMenuItem menuItemList;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 750);
		
		setTitle("Stok");
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
		
		iFrameOperation = new InternalFrameOperation();
		desktopPane.add(iFrameOperation);
		
		iFrameList = new InternalFrameList();
		desktopPane.add(iFrameList);
		
		getContentPane().add(desktopPane);
			
		menuItemOperation = new JMenuItem("Stok Kartı İşlemleri");
		stockMenu.add(menuItemOperation);
		
		menuItemList = new JMenuItem("Stok Kartlarını Listele");
		stockMenu.add(menuItemList);
	}
}
