package com.dilaygulbagce.stockCardApplication.model;

import java.sql.Date;

public class ProductEntiries {
	
	private String stockCode;
	private String stockName;
	private int stockType;
	private String stockUnit;
	private String stockBarcode;
	private Double vatType;
	private Date creationDate;
	private String description;
	
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
}
