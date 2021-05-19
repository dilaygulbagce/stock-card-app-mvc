package com.dilaygulbagce.stockCardApplication.view;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dilaygulbagce.stockCardApplication.controller.WarehouseCardFrameCommand;
import com.dilaygulbagce.stockCardApplication.utility.StokAppEntityRepository;

import tr.com.guru.common.db.ConnectionManager;
import tr.com.guru.common.model.ApplicationModel;
import tr.com.guru.common.model.DonemEntity;
import tr.com.guru.common.model.Kontrol;
import tr.com.guru.common.model.KullaniciEntity;
import tr.com.guru.common.model.SirketEntity;
import tr.com.guru.common.utility.HibernateSessionManager;
import tr.com.guru.common.utility.PropertyFileManager;
import tr.com.guru.common.view.BaseMainFrame;
import tr.com.guru.common.view.BaseMenuBar;
import tr.com.guru.common.view.BaseToolBar;
import tr.com.guru.common.view.JScrollableDesktopPane;

import javax.swing.JMenuItem;
import java.sql.Connection;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

@SuppressWarnings("serial")
public class MainFrame extends BaseMainFrame {
	
	static public ConnectionManager cm = null;
	public static int dbType = ConnectionManager.MySQL;

	private JPanel contentPane;

	static JFrame frame;

	public static MainFrame mainFrame;
	public static Connection connection;
	
	public static Kontrol ctrl;

	static JDesktopPane desktopPane;

	public StockCardFrame stockCardFrame;
	public StockCardListFrame stockCardListFrame;
	public WarehouseCardFrame warehouseCardFrame;
	public WarehouseCardListFrame warehouseCardListFrame;

	public JMenuItem stockCardMenuItem;
	public JMenuItem stockCardListMenuItem;
	public JMenuItem warehouseCardMenuItem;
	public JMenuItem warehouseCardListMenuItem;

	public WarehouseCardFrameCommand warehouseCardCommand;
	public JMenuBar menuBar;
	
	public MainFrame(KullaniciEntity personel, SirketEntity sirket, Vector sirketler, DonemEntity donem, Vector donemler) {
		super(new KullaniciEntity(), new SirketEntity(), new Vector(), new DonemEntity());

		this.mainFrame = this;
		
		ctrl = new Kontrol();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu stockMenu = new JMenu("Stok");
		menuBar.add(stockMenu);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
	
		stockCardFrame = new StockCardFrame(mainFrame);
		desktopPane.add(stockCardFrame);

		stockCardListFrame = new StockCardListFrame();
		desktopPane.add(stockCardListFrame);

		warehouseCardCommand = new WarehouseCardFrameCommand(mainFrame);
		warehouseCardCommand.execute();
		
		warehouseCardFrame = (WarehouseCardFrame) warehouseCardCommand.bif;
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

	public static void main(String[] args) {
		
		try {
			cm = cm.getInstance(PropertyFileManager.getGeneralProp());
			connection = cm.connect(dbType, "stock_card");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getIcon16Str() {
		return "";
	}

	@Override
	public JFrame getFrame() {
		return this;
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public int getDBType() {
		return 0;
	}

	@Override
	public Properties getGeneralProp() {
		return PropertyFileManager.getGeneralProp();
	}

	@Override
	public SirketEntity getSirket() {
		return null;
	}

	@Override
	public DonemEntity getDonem() {
		return donem;
	}

	@Override
	public int getKurType() {
		return 0;
	}

	@Override
	public KullaniciEntity getPersonel() {
		return personel;
	}

	@Override
	public Kontrol getCtrl() {
		return ctrl;
	}

	@Override
	public Vector getSirketler() {
		return sirketler;
	}

	@Override
	public int getOSType() {
		return OSType;
	}

	@Override
	public String getAppCode() {
		return ApplicationModel.COREERP;
	}

	@Override
	public Hashtable getFrameMap() {
		return frameMap;
	}

	@Override
	public JScrollableDesktopPane getScrollableDesktopPane() {
		return mainPane;
	}

	@Override
	public String getCurrentVersionNo() {
		return "";
	}

	@Override
	public String getVersionControlParameter() { 
		return "";
	}

	@Override
	public String getBackgroundImagePath() {
		return "";
	}

	@Override
	public String getBaseTitleName() {
		return "Ana Ekran";
	}

	@Override
	protected void setRepositories() {
		HibernateSessionManager.addEntityRepository(new StokAppEntityRepository());

	}

	@Override
	public BaseToolBar getMainToolBar() {
		return null;		
	}

	@Override
	public BaseMenuBar getMainMenuBar() {
		return (BaseMenuBar) menuBar;
	}

}
