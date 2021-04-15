package com.dilaygulbagce.stockCardApplication.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.dilaygulbagce.stockCardApplication.utility.DatabaseConnection;

public class StockCardModel {
	
	private DatabaseConnection databaseConnection = new DatabaseConnection();
	
	private String stockCode;
	private String stockName;
	private String warehouseCode;
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

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	
	@SuppressWarnings("serial")
	HashMap<String, String> stockTypeMap = new HashMap<String, String>() {{
		put("1", "Süt ve Süt Ürünleri");
		put("2", "Et ve Et Ürünleri");
		put("3", "Yağ");
		put("4", "Meyve ve Sebze Ürünleri");
		put("5", "Konserve Gıda");
		put("6", "Dondurulmuş Gıda");
		put("7", "Kuru Gıda");
		put("8", "Unlu Mamüller");
		put("9", "Su Ürünleri");
	}};

	
	@SuppressWarnings("rawtypes")
	public ArrayList<Vector> list() throws SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection connect = databaseConnection.getConnection();
		ResultSet resultSet = null;
			
		ArrayList<Vector> stockCardList = new ArrayList<Vector>();
			
		String sql = "SELECT * FROM stock_card";
	
		try {
			preparedStatement = connect.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
				
			ResultSetMetaData stData = resultSet.getMetaData();
				
			int dbColumnCount;
			dbColumnCount = stData.getColumnCount();
				
			while(resultSet.next()) {
				Vector<String> columnData = new Vector<String>();
					
				for(int i=1; i<dbColumnCount; i++) {
					columnData.add(resultSet.getString("stock_code"));
	                columnData.add(resultSet.getString("stock_name"));
	                columnData.add(resultSet.getString("warehouse_code"));
	                columnData.add(stockTypeMap.get(resultSet.getString("stock_type")));
	                columnData.add(resultSet.getString("stock_unit"));
	                columnData.add(resultSet.getString("stock_barcode"));
	                columnData.add(resultSet.getString("stock_vat_type"));
	                String date[] = resultSet.getString("stock_creation_date").split(" ");
	                columnData.add(date[0]);
	                columnData.add(resultSet.getString("stock_description"));
				}
				stockCardList.add(columnData);
			}
			return stockCardList;
		} catch (SQLException exception) {
			System.err.println(exception);
			return null;
		} finally {
			try {
				connect.close();
			} catch (SQLException exception) {
				System.err.println(exception);
			}
		}
	}
	
	public boolean insert() throws SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection connect = databaseConnection.getConnection();
		
		String sql = "INSERT INTO stock_card (stock_code, stock_name, warehouse_code, stock_type, stock_unit, "
				+ "stock_barcode, stock_vat_type, stock_creation_date, stock_description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			preparedStatement = connect.prepareStatement(sql);
			
			preparedStatement.setString(1, getStockCode());
			preparedStatement.setString(2, getStockName());
			preparedStatement.setString(3, getWarehouseCode());
			preparedStatement.setInt(4, getStockType());
			preparedStatement.setString(5, getStockUnit());
			preparedStatement.setString(6, getStockBarcode());
			preparedStatement.setDouble(7, getVatType());
			preparedStatement.setDate(8, getCreationDate());
			preparedStatement.setString(9, getDescription());
			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
			
		} finally {
			try {
				connect.close();
			} catch (SQLException exception) {
				System.err.println(exception);
			}
		}
	}
	
	public boolean delete() throws SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection connect = databaseConnection.getConnection();
		
		String sql = "DELETE FROM stock_card WHERE stock_code = ?";
		
		try {
			preparedStatement = connect.prepareStatement(sql);
			
			preparedStatement.setString(1, getStockCode());
			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
			
		} finally {
			try {
				connect.close();
				
			} catch (SQLException exception) {
				System.err.println(exception);
			}
		}
	}
	
	public boolean update() throws SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection connect = databaseConnection.getConnection();
		
		String sql = "UPDATE stock_card.stock_card SET stock_name = ?, stock_type = ?, warehouse_code = ?, stock_unit = ?, "
				+ "stock_barcode = ?, stock_vat_type = ?, stock_creation_date = ?, stock_description = ? WHERE stock_code = ?";
		
		try {
			preparedStatement = connect.prepareStatement(sql);
			
			preparedStatement.setString(1, getStockName());
			preparedStatement.setInt(2, getStockType());
			preparedStatement.setString(3, getWarehouseCode());
			preparedStatement.setString(4, getStockUnit());
			preparedStatement.setString(5, getStockBarcode());
			preparedStatement.setDouble(6, getVatType());
			preparedStatement.setDate(7, getCreationDate());
			preparedStatement.setString(8, getDescription());
			preparedStatement.setString(9, getStockCode());
			preparedStatement.execute();
			
			return true;
			
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
			
		} finally {
			try {
				connect.close();
				
			} catch (SQLException exception) {
				System.err.println(exception);
			}
		}
	}
	
	public boolean copy() throws SQLException {
		PreparedStatement preparedStatement = null;
		Connection connect = databaseConnection.getConnection();
		
		String stockCode = getStockCode();
		
		String copyItem = JOptionPane.showInputDialog(null, "Kopyanın Stok Kodu?");
		
		String sql = "INSERT INTO stock_card (stock_code, stock_name, warehouse_code, stock_type, stock_unit, stock_barcode, stock_vat_type, stock_creation_date, stock_description)"
                + "SELECT ?, stock_name, warehouse_code, stock_type, stock_unit, stock_barcode, stock_vat_type, stock_creation_date, stock_description FROM stock_card WHERE stock_code = ?";
		
		if(copyItem!= null) {
			try {
		
				preparedStatement = connect.prepareStatement(sql);
			
				preparedStatement.setString(1, copyItem);
				preparedStatement.setString(2, stockCode);
	        
				preparedStatement.executeUpdate();
	        
				return true;
			} catch (SQLException exception) {
				System.err.println(exception);
				return false;
			
			} finally {
				try {
					connect.close();
				
				} catch (SQLException exception) {
					System.err.println(exception);
				}
			}
		}
		return false;
	}
	
	public boolean search() throws SQLException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connect = databaseConnection.getConnection();
		
		String sql = "SELECT * FROM stock_card WHERE stock_code = ?";
		
		try {
			preparedStatement = connect.prepareStatement(sql);
			
			preparedStatement.setString(1, getStockCode());
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				setStockCode(resultSet.getString("stock_code"));
				setStockName(resultSet.getString("stock_name"));
				setWarehouseCode(resultSet.getString("warehouse_code"));
				setStockType(resultSet.getInt("stock_type"));
				setStockUnit(resultSet.getString("stock_unit"));
				setStockBarcode(resultSet.getString("stock_barcode"));
				setVatType(resultSet.getDouble("stock_vat_type"));
				setCreationDate(resultSet.getDate("stock_creation_date"));
				setDescription(resultSet.getString("stock_description"));
				
				return true;
			}
			return false;
		} catch (SQLException exception) {
			System.err.println(exception);
			return false;
			
		} finally {
			try {
				connect.close();
				
			} catch (SQLException exception) {
				System.err.println(exception);
			}
		}
	}
}