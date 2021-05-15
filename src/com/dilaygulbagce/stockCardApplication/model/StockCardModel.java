package com.dilaygulbagce.stockCardApplication.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dilaygulbagce.stockCardApplication.utility.HibernateSessionManager;

@Entity
@Table(name = "stock_card")
public class StockCardModel<E> extends BaseCardModel implements Serializable {

	public static final int CODE_LIMIT = 50;
	public static final int NAME_LIMIT = 100;
	public static final int BARCODE_LIMIT = 30;
	public static final int DESCRIPTION_LIMIT = 100;

	@Id
	@Column(name = "code")
	private String stockCode;
	
	@Column(name = "name")
	private String stockName;
	
	@Column(name = "warehouse_code")
	private String warehouseCode;
	
	@Column(name = "type")
	private int stockType;
	
	@Column(name = "unit")
	private String stockUnit;
	
	@Column(name = "barcode")
	private String stockBarcode;
	
	@Column(name = "vat_type")
	private Double vatType;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "description")
	private String description;
	
	public StockCardModel() {
		
	}
	
	public StockCardModel(String stockCode) {
		super();
		this.stockCode = stockCode;
	}

	public StockCardModel(String stockCode, String stockName, String warehouseCode, int stockType, String stockUnit,
			String stockBarcode, Double vatType, Date creationDate, String description) {		
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.warehouseCode = warehouseCode;
		this.stockType = stockType;
		this.stockUnit = stockUnit;
		this.stockBarcode = stockBarcode;
		this.vatType = vatType;
		this.creationDate = creationDate;
		this.description = description;
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
	
//	public List<E> list(String whereClause) {
//		HibernateSessionManager sessionManager = new HibernateSessionManager();
//		
//		Session session = sessionManager.getSession();
//		Transaction transaction = session.getTransaction();
//		transaction.begin();
//		
//		@SuppressWarnings("unchecked")
//		Query<E> query = session.createQuery("from " + getClass().getName() + "");
//		List<E> results = query.getResultList();
//
//		session.close();
//		return results;
//	}
//	
//	public boolean insert() {
//		HibernateSessionManager sessionManager = new HibernateSessionManager();
//		
//		Session session = sessionManager.getSession();
//		Transaction transaction = session.getTransaction();
//		
//		transaction.begin();
//		session.save(this);
//		transaction.commit();
//		session.close();
//		
//		return true;
//	}
//	
//	public boolean delete() {
//		HibernateSessionManager sessionManager = new HibernateSessionManager();
//		
//		Session session = sessionManager.getSession();
//		Transaction transaction = session.getTransaction();
//		
//		transaction.begin();
//		session.delete(this);
//		transaction.commit();
//		session.close();
//		
//		return true;
//	}
//
//	public boolean update() {
//		HibernateSessionManager sessionManager = new HibernateSessionManager();
//		
//		Session session = sessionManager.getSession();
//		Transaction transaction = session.getTransaction();
//		
//		transaction.begin();
//		session.update(this);
//		transaction.commit();
//		session.close();
//		
//		return true;
//	}
		
//	@Transient
//	public boolean copy() {
//		HibernateSessionManager sessionManager = new HibernateSessionManager();
//		
//		Session session = sessionManager.getSession();
//		Transaction transaction = session.getTransaction();
//		
//		String copyItem = JOptionPane.showInputDialog(null, "Kopyanın Stok Kodu?");
//		
//		transaction.begin();
//		this.setStockCode(copyItem);
//		session.save(this);
//		transaction.commit();
//		session.close();
//		
//		return true;
//	}
//	
//	@Transient
//	public boolean search() {
//		HibernateSessionManager sessionManager = new HibernateSessionManager();
//		
//		Session session = sessionManager.getSession();
//		Transaction transaction = session.getTransaction();
//		
//		transaction.begin();
//		StockCardModel find = session.get(StockCardModel.class, stockCode);
//		
//		setStockCode(find.stockCode);
//		setStockName(find.stockName);
//		setWarehouseCode(find.warehouseCode);
//		setStockType(find.stockType);
//		setStockUnit(find.stockUnit);
//		setStockBarcode(find.stockBarcode);
//		setVatType(find.vatType);
//		setCreationDate(find.creationDate);
//		setDescription(find.description);
//		
//		transaction.commit();
//		session.close();
//		
//		return true;
//	}
	
//	@Transient
//	public boolean isRecorded() {
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
}