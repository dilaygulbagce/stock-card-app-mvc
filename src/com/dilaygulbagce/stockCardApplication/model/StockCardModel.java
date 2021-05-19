package com.dilaygulbagce.stockCardApplication.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dilaygulbagce.stockCardApplication.utility.HibernateSessionManager;

import tr.com.guru.common.model.BaseEntity;
import tr.com.guru.common.model.MasterValue;
import tr.com.guru.common.view.MainFrameInterface;

@Entity
@Table(name = StockCardModel.TABLE)
public class StockCardModel extends BaseEntity implements Serializable {
	
	public static final String TABLE = "stock_card";
	public static final String ALIAS = "s";

	public static final int CODE_LIMIT = 50;
	public static final int NAME_LIMIT = 100;
	public static final int BARCODE_LIMIT = 30;
	public static final int DESCRIPTION_LIMIT = 100;
	
	@MasterValue
	private static final String KODU = "stockCode";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int stockId;
	
	@Column(name = "code", nullable=false, length=CODE_LIMIT)
	private String stockCode;
	
	@Column(name = "name", nullable=false, length=NAME_LIMIT)
	private String stockName;
	
	@Column(name = "warehouse_code", nullable=false)
	private String warehouseCode;
	
	@Column(name = "type", nullable=false)
	private int stockType;
	
	@Column(name = "unit", nullable=false)
	private String stockUnit;
	
	@Column(name = "barcode", nullable=false, length=BARCODE_LIMIT)
	private String stockBarcode;
	
	@Column(name = "vat_type", nullable=false, columnDefinition="DOUBLE")
	private Double vatType;
	
	@Column(name = "creation_date", nullable=false, columnDefinition="DATE")
	private Date creationDate;
	
	@Column(name = "description", nullable=false, length=DESCRIPTION_LIMIT)
	private String description;
	
	public StockCardModel() {
		super(null);
	}
	
	public StockCardModel(MainFrameInterface mainFrame) {
		super(mainFrame);
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	public String getStockUnit() {
		return stockUnit;
	}

	public void setStockUnit(String stockUnit) {
		this.stockUnit = stockUnit;
	}

	public String getStockBarcode() {
		return stockBarcode;
	}

	public void setStockBarcode(String stockBarcode) {
		this.stockBarcode = stockBarcode;
	}

	public Double getVatType() {
		return vatType;
	}

	public void setVatType(Double vatType) {
		this.vatType = vatType;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	
	public boolean copy() {
		HibernateSessionManager sessionManager = new HibernateSessionManager();
		
		Session session = sessionManager.getSession();
		Transaction transaction = session.getTransaction();
		
		String copyItem = JOptionPane.showInputDialog(null, "Kopyanın Stok Kodu?");
		
		transaction.begin();
		this.setStockCode(copyItem);
		session.save(this);
		transaction.commit();
		session.close();
		
		return true;
	}
	
//	public boolean isRecorded(String stockCode) {
//		HibernateSessionManager sessionManager = new HibernateSessionManager();
//		
//		Session session = sessionManager.getSession();
//		Transaction transaction = session.getTransaction();
//		
//		transaction.begin();
//		StockCardModel find = session.get(StockCardModel.class, stockCode);
//		
//		if(find == null) {
//			return false;
//		}
//		return true;
//	}

	@Override
	public BaseEntity emptyModel() {
		return new StockCardModel(mainFrame);
	}

	@Override
	public void setCodeChangeComponentDataList() {
		
	}

	@Override
	public String getTableName() {
		return TABLE;
	}

	@Override
	public String getAlias() {
		return ALIAS;
	}
	
}